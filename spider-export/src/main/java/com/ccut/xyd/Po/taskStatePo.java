package com.ccut.xyd.Po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class taskStatePo {
    /**
     * 数据库id  从1自增
     */
    private int id;

    /**
     * 任务id url + 任务名 +时间取hash值
     */
    private int taskId;
    /**
     * 种子
     */
    private String url;
    /**
     * 爬取深度
     */
    private int deep;
    /**
     * 任务状态 0-未完成  1-已完成
     */
    private int state;
}
