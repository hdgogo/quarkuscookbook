# ch6-buildpack Project

打包Quarkus 应用程序

## 在命令行模式下运行

要在Quarkus中启动命令行模式， 需要创建一个实现了`io.quarkus.runtime.QuarkusApplication`接口的类， 然后编写main 方法，另外，有main方法的类必须用
`@io.quarkus.runtime.annotations.QuarkusMain`来注解。

如果想使用命令参数， 可以使用`@io.quarkus.runtime.annotations.CommandLineArguments` 注解


