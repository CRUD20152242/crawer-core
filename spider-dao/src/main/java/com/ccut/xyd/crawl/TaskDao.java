package com.ccut.xyd.crawl;

import com.ccut.xyd.Po.TaskStatePo;

import java.util.List;

public interface TaskDao {
    void addTaskState(TaskStatePo po);
    List<TaskStatePo> searchTaskState(String taskName);
    void updateState(TaskStatePo po);
}
