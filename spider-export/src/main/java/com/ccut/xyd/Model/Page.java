package com.ccut.xyd.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class Page implements Serializable {
    private String Htmlpage;
    private String page;
    private String url;
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
    //扩展用  暂时不用
    private List<String> ext;
}
