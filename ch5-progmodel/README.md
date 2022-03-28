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


## 以程序化的方式校验对象


## 依赖注入

## 创建工厂类


## 执行对象生命周期事件


## 执行应用程序生命周期事件

## 使用命名限定符