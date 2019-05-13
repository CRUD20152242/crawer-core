package com.ccut.xyd.service;

import com.ccut.xyd.Po.TaskStatePo;

import java.util.List;

public interface TaskStateService {
    boolean addTaskState(TaskStatePo po);
    List<TaskStatePo> searchTaskState(String taskName);
    void updateState(TaskStatePo po);
}
