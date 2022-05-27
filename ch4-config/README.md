# ch4-config Project

配置

## 使用自定义属性配置应用程序
`Quarkus`使用了`Eclipse Microprofile`规范，其中之一就是配置规范，但是为了简化配额， Quarkus只使用一个文件来处理所有的配置，即`application.properties`,
这个文件必须放在classpath的根目录下。

在`application.properties`中定义自定义属性， 通过在字段中使用`org.eclipse.microprofile.config.inject.ConfigProperty`注解来注入在`application.properties`
中定义的属性值。

支持给属性设置多个值， 属性值的分割符是逗号(,) , 转义符为反斜杠(\) ; 对应的字段可以定义为`Arrays`，`java.util.List`,`java.util.Set`中的一种。


要使用`YAML`格式的配置文件`application.yaml`或`application.yml`，需要添加`config-yaml`扩展
```shell
./mvnw quarkus:add-extension -Dextensions="config-yaml"
```

## 以程序化的方式访问配置属性

`Eclipse Microprofile Configuration`规范允许注入`org.eclipse.microprofile.config.Config`来程序化地获取属性值，而不是使用`org.eclipse.microprofile.config.inject.ConfigProperty`
直接注入。


## 使用profile进行配置

`Quarkus`支持profile的配置。 这允许在同一个文件中为同一属性设置多个配置值， 请在运行Quarkus服务的不同环境中使用不同的值。

启用profile的语法是 %{profile}.config.key=value

`Quarkus`有三个内置的profile
- dev ：在开发环境中启用 （quarkus:dev）。
- test : 运行测试时使用。
- prod ： 当不在开发或测试模式下运行时的默认配置文件。 它是隐式设置的，不需要在`application.properties`中设置。

> 例： 在开发模式下以8181端口启动， 在测试环境下以8282端口启动
> %dev.qurakus.http.port=8181
> %test.quarkus.http.port=8282


## 使用自定的profile进行配置
通过`quarkus.profile`系统属性或`QUARKUS_PROFILE`环境变量来指定想要启用的profile， 如果两者都设置了，则系统属性忧于环境变量

> 例： 设置当staging profile 启用时， 启动端口为8182
> %staging.quarkus.http.port=8182
> ./mvnw -Dquarkus.profile=staging quarkus:dev

## 创建自定义的配置源
如何从其他配置源而不是从applicaiont.properties 文件加载配置参数？

Quarkus使用Eclipse MicroProfile Configuration规范来实现所有关于配置的逻辑， 改规范提供了`org.eclipse.micrpprofile.config.spi.ConfigSource` JAVA
SPI 接口， 以实现一种自定义的方式来加载配置属性。


## 创建自定义转换器
如何实现一个自定义的装换器？

通过实现`org.eclipse.microprofile.config.spi.Converter` JAVA SPI接口

## 配置值的分组


## 验证配置值


