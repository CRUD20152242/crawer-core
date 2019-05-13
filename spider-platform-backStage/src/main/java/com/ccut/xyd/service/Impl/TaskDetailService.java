package com.ccut.xyd.service.Impl;

import com.ccut.xyd.DBRpc;
import com.ccut.xyd.Po.TaskRulePo;
import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.Vo.DataTask;
import com.ccut.xyd.Vo.TaskInfoVo;
import com.ccut.xyd.Vo.TaskVo;
import com.ccut.xyd.service.RuleService;
import com.ccut.xyd.service.TaskServices;
import com.ccut.xyd.service.TaskStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskDetailService implements TaskServices {

    @Autowired
    private TaskStateService taskStateService;
    @Autowired
    private RuleService ruleService;
    @Autowired
    private DBRpc dbRpc;


    public List<TaskInfoVo> getTaskDetail(String taskName){
        List<TaskInfoVo> res = new ArrayList<TaskInfoVo>();
        TaskInfoVo taskInfoVo = new TaskInfoVo();
        log.info("任务详细信息查询开始准备查库 taskname = {}",taskName);
        try {
            //首先查询任务状态表
            List<TaskStatePo> task = taskStateService.searchTaskState(taskName);
            log.info("任务状态表查询成功");
            //然后查询任务规则表
            TaskRulePo taskRulePo,rule;
            for (TaskStatePo statue:task) {
                taskRulePo = new TaskRulePo();
                taskRulePo.setTaskId(statue.getTaskId());
                rule = ruleService.searchRule(taskRulePo);
                log.info("任务规则表查询成功");
                //查询所在的目录
                DataTask dataTask = new DataTask();
                dataTask.setTaskId(statue.getTaskId());
                List<DataTask> data =  dbRpc.getData(dataTask);
                log.info("任务数据表查询成功");
                 taskInfoVo.setTask(statue);
                taskInfoVo.setRulePo(rule);
                taskInfoVo.setDatas(data);
                res.add(taskInfoVo);
                log.info("获取数据成功 准备返回 res = {}",res.toString());
            }
            return res;
        } catch (Exception e) {
            log.error("查询任务详细信息异常");
            e.printStackTrace();
            return null;
        }
    }
}
