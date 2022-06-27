# app-reactive Project

reactive入门

## maven命令行创建项目

```shell
$ mvn io.quarkus.platform:quarkus-maven-plugin:2.10.0.Final:create \                                                                     ✔ 
-DprojectGroupId=org.example \
-DprojectArtifactId=app-reactive \
-DnoCode
```

## 添加必要的扩展

```shell
$ cd app-reactive
$ ./mvnw quarkus:add-extension -Dextensions="hibernate-reactive-panache,resteasy-reactive-jackson,reactive-mysql-client,jdbc-mariadb" 
```


## 添加数据路配置
在`src/main/resource/application.properties`文件中添加数据库配置
```properties
quarkus.datasource.db-kind=mariadb
quarkus.datasource.username=hongda
quarkus.datasource.password=hongda
quarkus.datasource.reactive.url=mysql://localhost:3306/quarkus
quarkus.datasource.reactive.max-size=16


# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.log.sql=true
quarkus.hibernate-orm.sql-load-script=import.sql
```


## 添加健康检查

```shell
$ ./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-health"
```

## 添加opanapi
```shell
$ ./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
```







