# app-security-jpa Project

Quarkus应用程序如何使用数据库存储用户身份



## 引入最小依赖
```shell
./mvnw quarkus:add-extension -Dextensions="security-jpa"
./mvnw quarkus:add-extension -Dextensions="jdbc-mariadb"
./mvnw quarkus:add-extension -Dextensions="resteasy-reactive"
./mvnw quarkus:add-extension -Dextensions="hibernate-orm-panache"
```
