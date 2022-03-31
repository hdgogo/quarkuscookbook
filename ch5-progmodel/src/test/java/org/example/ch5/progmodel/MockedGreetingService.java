package org.example.ch5.progmodel;


import io.quarkus.test.Mock;

@Mock  //在CDI中把POJO标记为模拟类（替代类）
public class MockedGreetingService extends  GreetingService{ //该类必须扩展或者实现基础服务


    @Override
    public String greetingMessage(int age) {
        return "Hello World";  //预先设置的结果
    }
}
