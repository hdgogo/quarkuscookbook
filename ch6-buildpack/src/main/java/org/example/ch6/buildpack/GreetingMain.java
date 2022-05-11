package org.example.ch6.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class GreetingMain implements QuarkusApplication { // QuarkusApplication 接口设置在命令行模式运行
    @Override
    public int run(String... args) throws Exception { //调用main方法执行
        System.out.println("Hello World");
        Quarkus.waitForExit();        // 等到Quarkus进程停止后退出
        return 0;
    }
}
