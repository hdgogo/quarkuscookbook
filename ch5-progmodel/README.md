# ch5-progmodel Project

编程模型

`Quarkus`的所遵循的编程模型是独特的，与其他框架不同的是， `Quarkus`允许混合使用CDI命令式模型和SmallRye Mutiny响应式模型


## 对JSON进行编组和解组

[JSON-B](http://json-b.net)

[Jackson](https://oreil.ly/U3hwH)


## 对XML进行编组和解组

[JAX-B](https://oreil.ly/r9FKb)



## 校验输入值和输出值

使用Bean Validation 规范来为模型添加校验

```shell
$ ./mvnw quarkus:add-extension -Dextensions="quarkus-hibernate-validator"
```

[Jakarta Bean Validation](https://oreil.ly/YHR_X)



## 创建自定义校验

通过实现javax.validation.ConstraintValidator接口来使用Bean Validation 扩展模型


## 以程序化的方式校验对象

使用Bean Validation `javax.validation.Validator`类

## 依赖注入

Quarkus中的Bean发现遵循标准CDI的简化过程。

[CDI]（https://oreil.ly/jm4QF）

## 创建工厂类

使用CDI中的javax.enterprise.inject.Produces概念。

CDI有一个叫作producer的概念，它允许你创建任何类型的对象，需要在可解析的实例列表中添加一个新的bean或类


## 执行对象生命周期事件

CDI使用@javax.annotation.PostConstruct和@javax.annotation.PreDestroy 注解进行对象生命周期的管理，对于PostConstruct来说， 
使用这些注解的方法将在对象创建之后被调用，对于PreDestroy来说，使用这些注解的方法将在对象被销毁之前被调用


## 执行应用程序生命周期事件

`io.quarkus.runtime.StartupEvent` 和 `io.quarkus.runtime.ShutdownEvent` 

在应用程序启动是，产生StartupEvent事件， 在关闭时，会产生ShutdownEvent事件。

## 使用命名限定符

使用@javax.inject.Named注解

[注入点的限定符]（https://oreil.ly/5NydQ）


## 使用自定义限定符

使用@javax.injext.Qualifier注解

[Qualifiers](https://oreil.ly/MOfwa)


## 限定和配置注解

使用procucer中的InjectionPoint和限定符注解上的非绑定属性的组合，可以同时限定和配置一个Bean

[注入点元数据]（https://oreil.ly/BVmV2）

## 创建拦截器