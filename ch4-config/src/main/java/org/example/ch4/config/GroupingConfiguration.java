package org.example.ch4.config;


import io.quarkus.arc.config.ConfigProperties;

import java.util.List;

@ConfigProperties(prefix = "grouping") //配置POJO的共同前缀
public class GroupingConfiguration {
    public String message; //映射 grouping.message 属性
    public String suffix = "!"; //如果没有设置该属性，grouping.suffix 的默认值

    //嵌套的对象配置
    public OutputConfiguration output; //子类别的名称

    public static class OutputConfiguration{
        public List<String> recipients;   // 映射配置grouping.output.recipients
    }

}
