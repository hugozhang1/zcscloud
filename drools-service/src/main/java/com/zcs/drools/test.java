package com.zcs.drools;

import com.zcs.drools.domain.PointDomain;
import com.zcs.drools.services.IPointRuleEngine;
import com.zcs.drools.services.impl.PointRuleEngineImpl;
import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.io.*;

/**
 * Created by hugo on 2018/1/16.
 */
public class test {

    public static void main(String[] args) throws IOException {
       IPointRuleEngine pointRuleEngine = new PointRuleEngineImpl();
        while(true){
            InputStream is = System.in;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input = br.readLine();

            if(null != input && "s".equals(input)){
                System.out.println("初始化规则引擎...");
                pointRuleEngine.initEngine();
                System.out.println("初始化规则引擎结束.");
            }else if("e".equals(input)){
                final PointDomain pointDomain = new PointDomain();
                pointDomain.setUserName("hello kity");
                pointDomain.setBackMondy(100d);
                pointDomain.setBuyMoney(500d);
                pointDomain.setBackNums(1);
                pointDomain.setBuyNums(5);
                pointDomain.setBillThisMonth(5);
                pointDomain.setBirthDay(true);
                pointDomain.setPoint(0l);

                pointRuleEngine.executeRuleEngine(pointDomain);

                System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());
                System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());
                System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());

                System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
            } else if("r".equals(input)){
                System.out.println("刷新规则文件...");
                pointRuleEngine.refreshEnginRule();
                System.out.println("刷新规则文件结束.");
            }
        }
    }
}
