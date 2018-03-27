package com.zcs.drools.services;

import com.zcs.drools.domain.PointDomain;

/**
 * Created by hugo on 2018/1/16.
 */
public interface IPointRuleEngine {

    /**
     * 初始化规则引擎
     */
    public void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    public void refreshEnginRule();

    /**
     * 执行规则引擎
     * @param pointDomain 积分Fact
     */
    public void executeRuleEngine(final PointDomain pointDomain);
}
