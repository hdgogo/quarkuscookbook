# ch2-scaffolding Project

使用脚手架快速搭建Quarkus项目。


## 使用maven命令行搭建quarkus项目脚手架
```shell
$ mvn io.quarkus.platform:quarkus-maven-plugin:2.7.1.Final:create \  
  -DprojectGroupId org.example        \
  -DprojectArtifactId ch2-scaffolding  \
  -DclassName="org.acme.quickstart.GreetingResource" \
  -Dpath="/hello"
```


## 运行项目在开发（dev）模式下
```shell script
$ ./mvnw compile quarkus:dev
```


## 打包和运行项目

- 打包（package）
```shell script
$ ./mvnw package
```
运行上面的命令，会在目录`target/quarkus-app/`下生成`quarkus-run.jar` 。
> 请注意，这不是一个 _über-jar_ ，jar包的运行依赖会复制到目录`target/quarkus-app/lib/`中；

- 运行 （run）
```shell
$ java -jar target/quarkus-app/quarkus-run.jar
```

- _über-jar_ 打包 
```shell
$ ./mvnw package -Dquarkus.package.type=uber-jar
```

- _über-jar_ 运行
```shell
$ java -jar target/*-runner.jar
```


## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ch2-scaffolding-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

