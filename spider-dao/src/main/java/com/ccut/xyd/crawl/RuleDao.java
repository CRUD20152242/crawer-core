package com.ccut.xyd.crawl;

import com.ccut.xyd.Po.TaskRulePo;

public interface RuleDao {
    void addRule(TaskRulePo po);
    TaskRulePo searchRule(TaskRulePo po);
}
