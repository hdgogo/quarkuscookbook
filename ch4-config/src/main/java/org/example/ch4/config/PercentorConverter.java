package org.example.ch4.config;

import org.eclipse.microprofile.config.spi.Converter;

import javax.annotation.Priority;

/**
 * 创建自定义的转换器
 *  Quarkus使用Eclipse MicroProfile Configuration 规范来实现所有关于配置的逻辑， 该规范提供了org.eclipse.microprofile.config.spi.Converter SPI接口，
 *  来实现配置值到自定义类型的转换
 *
 *  注册Java SPI 的方法
 *  通过在src/main/resources/META-INF 中创建services文件夹， 然后在此文件夹中创建一个名为org.eclipse.microprofile.config.spi.Converter的文件，
 *  文件内容为org.example.ch4.config.PercentorConverter
 */

@Priority(300)  //设置优先级
public class PercentorConverter  implements Converter<Percentage> { //设置通用的类型转换
    @Override
    public Percentage convert(String value) throws IllegalArgumentException, NullPointerException {
        String numeric = value.substring(0, value.length() - 1);
        return new Percentage(Double.parseDouble(numeric) / 100);
    }
}
