package com.ccut.xyd.service;

import com.ccut.xyd.Vo.TaskInfoVo;

import java.util.List;

public interface TaskServices {
    List<TaskInfoVo> getTaskDetail(String taskName);
}
