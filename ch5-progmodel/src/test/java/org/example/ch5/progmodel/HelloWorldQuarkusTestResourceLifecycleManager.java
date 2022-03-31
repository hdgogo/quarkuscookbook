package org.example.ch5.progmodel;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

public class HelloWorldQuarkusTestResourceLifecycleManager  implements QuarkusTestResourceLifecycleManager { //必须实现QuarkusTestResourceLifecycleManager


    @Override
    public Map<String, String> start() { //测试用例开始之前执行的方法
        System.out.println("Start Test Suite execution");
        return Collections.emptyMap();
    }

    @Override
    public void stop() { //测试用列执行完成后执行的方法
        System.out.println("Stop Test Suite execution");
    }

    @Override
    public void inject(Object testInstance) { //每执行一个测试类，都会调用这个方法，传递测试实例
        QuarkusTestResourceLifecycleManager.super.inject(testInstance);
    }

    @Override
    public int order() { //设定在定义了多个resource的情况下的执行顺序
        return 0;
    }
}
