package com.zcs.drools.services.impl;

import com.zcs.drools.domain.PointDomain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.zcs.drools.services.IPointRuleEngine;
import com.zcs.drools.utils.RuleBaseFacatory;
import jdk.nashorn.internal.runtime.linker.Bootstrap;
import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.cdi.KSession;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.spi.Activation;

/**
 * Created by hugo on 2018/1/16.
 */
public class PointRuleEngineImpl implements IPointRuleEngine {
    private RuleBase ruleBase;

    @Override
    public void initEngine() {
        // 设置时间格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        ruleBase = RuleBaseFacatory.getRuleBase();
        try {
            PackageBuilder backageBuilder = getPackageBuilderFromDrlFile();
            ruleBase.addPackages(backageBuilder.getPackages());
        } catch (DroolsParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refreshEnginRule() {
        ruleBase = RuleBaseFacatory.getRuleBase();
        org.drools.rule.Package[] packages = ruleBase.getPackages();
        for (org.drools.rule.Package pg : packages) {
            ruleBase.removePackage(pg.getName());
        }

        initEngine();
    }

    @Override
    public void executeRuleEngine(PointDomain pointDomain) {
        if (null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
            return;
        }
        KSession
        StatefulSession statefulSession = ruleBase.newStatefulSession();
        statefulSession.insert(pointDomain);

        // fire
        statefulSession.fireAllRules(new org.drools.spi.AgendaFilter() {
            public boolean accept(Activation activation) {
                return !activation.getRule().getName().contains("_test");
            }
        });

        statefulSession.dispose();
    }

    /**
     * 从Drl规则文件中读取规则
     *
     * @return
     * @throws Exception
     */
    private PackageBuilder getPackageBuilderFromDrlFile() throws Exception {
        // 获取测试脚本文件
        List<String> drlFilePath = getTestDrlFile();
        // 装载测试脚本文件
        List<Reader> readers = readRuleFromDrlFile(drlFilePath);

        PackageBuilder backageBuilder = new PackageBuilder();
        for (Reader r : readers) {
            backageBuilder.addPackageFromDrl(r);
        }

        // 检查脚本是否有问题
        if (backageBuilder.hasErrors()) {
            throw new Exception(backageBuilder.getErrors().toString());
        }

        return backageBuilder;
    }

    /**
     * @param drlFilePath 脚本文件路径
     * @return
     * @throws FileNotFoundException
     */
    private List<Reader> readRuleFromDrlFile(List<String> drlFilePath) throws FileNotFoundException {
        if (null == drlFilePath || 0 == drlFilePath.size()) {
            return null;
        }

        List<Reader> readers = new ArrayList<Reader>();

        for (String ruleFilePath : drlFilePath) {
           File file=  new File(ruleFilePath);
          FileReader fileReader=   new FileReader(file);
            try {
                int t;
                while ((t = fileReader.read()) != - 1){
                    if (((char) t) != '\r') {
                        System.out.print((char) t);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            readers.add(fileReader);
        }

        return readers;
    }

    /**
     * 获取测试规则文件
     *
     * @return
     */
    private List<String> getTestDrlFile() {
        List<String> drlFilePath = new ArrayList<String>();
        java.net.URL url = this.getClass().getResource("/drl/addpoint.drl");

        File f = new File("D:\\project\\zcscloud\\drools-service\\src\\main\\resources\\drl\\addpoint.drl");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       Reader  reader = new InputStreamReader(inputStream);
        try {

            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println();
        drlFilePath
                .add("D:\\project\\zcscloud\\drools-service\\src\\main\\resources\\drl\\addpoint.drl");
        drlFilePath
                .add("D:\\project\\zcscloud\\drools-service\\src\\main\\resources\\drl\\subpoint.drl");

        return drlFilePath;
    }
}
