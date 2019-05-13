package com.ccut.xyd.Vo;

import com.ccut.xyd.Po.TaskRulePo;
import com.ccut.xyd.Po.TaskStatePo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 返回给前端的任务数据表
 */
@Getter
@Setter
@ToString
public class TaskInfoVo {
    private  TaskStatePo task;
    private TaskRulePo  rulePo;
    private List<DataTask>  datas;
}
