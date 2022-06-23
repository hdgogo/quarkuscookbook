package org.example.basedi.interceptor2;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("B")

/*
    1. 允许在同一位置重复使用同一个注解，这是java注解的通用功能，并非quarkus独有
    2. 重复使用注解时，必须定义注解容器，用来放置重复的注解，这里的容器是SendMessageList
    3. 使用Repeatable修饰SendMessage，这样就能在同一位置重复使用SendMessage注解了，注意Repeatable的属性值是容器SendMessageList
    4. sendType是注解属性，用来保存通知类型，任何使用SendMessage注解的地方都能通过设置sendType来指定通知类型，如果不指定则使用默认值sms
       要注意sendType的注解Nonbinding，此注解非常重要，如果不添加此注解，在使用SendMessage的时候，设置sendType为email时拦截器不会生效
 */


public class SayHelloB implements SayHello {
    @Override
    @SendMessage(sendType = "email")
    public String hello() {
        Log.info("hello from B");
        return "hello from B";
    }
}
