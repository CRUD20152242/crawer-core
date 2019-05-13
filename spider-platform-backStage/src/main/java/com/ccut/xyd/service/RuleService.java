package com.ccut.xyd.service;

import com.ccut.xyd.Po.TaskRulePo;

public interface RuleService {
    void addRule(TaskRulePo po);
    TaskRulePo searchRule(TaskRulePo po);
}
