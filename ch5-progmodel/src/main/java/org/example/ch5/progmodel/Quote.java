package org.example.ch5.progmodel;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD, ElementType.PARAMETER})
public @interface Quote {
    @Nonbinding String msg() default "" ;  //属性被设置为非绑定
    @Nonbinding String source() default  "" ;
}
