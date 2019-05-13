package com.ccut.xyd.Vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class TaskVo implements Serializable {
    /**
     * 任务名字
     */
    private String taskName;
    /**
     * 种子
     */
    private Integer seed;
    /**
     * 深度
     */
    private String deep;
    /**
     * 状态0-正在进行  1-已完成
     */
    private String statue;

    private String taskId;

    private String createTime;

    /**
     * 已完成的任务数
     */
    private String urls;
    /**
     * 任务的所有文件
     */
    private List<String> file;

}
