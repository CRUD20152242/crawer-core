package com.ccut.xyd.VO;

import jdk.nashorn.internal.objects.annotations.ScriptClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class InitVo {
    /**
     * 种子
     */
    private String seed;
    /**
     * url过滤  最对支持4个
     */
    private String regex1;
    private String regex2;
    private String regex3;
    private String regex4;
    /**
     * 爬取的深度
     */
    private String deep;

    /**
     * 是否加载js
     */
    private boolean turbo;

    /**
     * 目录名
     */
    private String fileName;

    /**
     * 是否自动解析页面
     */
    private boolean autoParse;

    private String threads;
    //    文本抽取暂定10个规则  可以为null  待改进为list
    private String rule1;
    private String rule2;
    private String rule3;
    private String rule4;
    private String rule5;
    private String rule6;
    private String rule7;
    private String rule8;
    private String rule9;
    private String rule10;

    private List<String> rules;
}
