package org.example.ch6.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain     //将该类设置为main
public class JavaMain {

    public static void main(String[] args) {
        Quarkus.run(GreetingMain.class, args); //启动进程
    }
}
