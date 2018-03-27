package com.zcs.drools.utils;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;

/**
 * Created by hugo on 2018/1/16.
 */
public class RuleBaseFacatory {

    private static RuleBase ruleBase;

    public static RuleBase getRuleBase(){
        return null != ruleBase ? ruleBase : RuleBaseFactory.newRuleBase();
    }
}
