package org.example.ch4.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 创建自定义的配置源
 * Quarkus使用Eclipse MicroProfile Configuration 规范来实现所有关于配置的逻辑， 该规范提供了org.eclipse.microprofile.config.spi.ConfigSource SPI接口，
 * 以实现一种自定义的方式来加载配置属性， 而不是使用Quarkus提供的默认方式加载配置属性。
 *
 * 注册Java SPI 的方法
 * 通过在src/main/resources/META-INF 中创建services文件夹， 然后在此文件夹中创建一个名为org.eclipse.microprofile.config.spi.ConfigSource的文件，
 *  文件内容为 ： org.example.ch4.config.InMemoryConfigSource
 *
 */
public class InMemoryConfigSource  implements ConfigSource {
    private Map<String, String> prop = new HashMap<>();

    public InMemoryConfigSource() { //用属性填充Map
        prop.put("greeting.color", "red");
    }

    @Override
    public int getOrdinal() { //用于确定配置值的重要程度， 数字越大，优先级越高
        return 500;
    }

    @Override
    public Map<String, String> getProperties() { //以Map的形式获取所有的属性
        return prop;
    }

    @Override
    public String getValue(String propertyName) { //获取单个属性的值
        return prop.get(propertyName);
    }

    @Override
    public String getName() { //返回此配置源的名称
        return "MemoryConfigSource";
    }

    @Override
    public Set<String> getPropertyNames() {
        return prop.keySet();
    }


}
