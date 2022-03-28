package org.example.ch4.config;


import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix="newGrouping")
public interface NewGroupingConfiguration {

    @WithName("name") //重写配置名
    @WithDefault("127.0.0.1") //默认值
    String host();

    int port();

    Log log();

    interface Log {   //嵌套配置
        @WithDefault("false")
        boolean enabled();

        String suffix();

        @WithDefault("true")
        boolean rotate();
    }
}
