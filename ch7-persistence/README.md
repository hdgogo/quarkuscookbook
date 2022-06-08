# ch7-persistence Project

持久化

## 配置数据源
使用`Agroal`扩展和application.properites

```shell
./mvnw quarkus:add-extension -Dextensions="agroal" -Dextensions="jdbc-mariadb"
```

需要访问数据源，可以使用下面的注入方式

```java
import javax.inject.Inject;

@Inject
DataSource defaultDataSource;
```

```properties
quarkus.datasource.db-kind=mariadb 
quarkus.datasource.username=<your username>
quarkus.datasource.password=<your password>

quarkus.datasource.jdbc.url=jdbc:mariadb://localhost:3306/test
quarkus.datasource.jdbc.max-size=16
```


## 使用多个数据源

使用命名的数据源，注解的方式不变，需要添加限定符 `@DataSource`

```java
    @Inject
    @DataSource("user")
    AgroalDataSource userDataSource;
```


## 添加数据源的健康检查

使用quarkus-agroal 和 quarkus-smallrye-health 两个扩展， 使用`quarkus-smallrye-health`扩展时，数据源的建康检查会自动添加。
如果需要禁用， 可以修改application.properites 中的 quarkus.datasource.health.enabled 属性（默认为true）， 要查看健康状态， 
可以访问`/health/ready` 接口。



## 定义事务的边界

使用 quarkus-narayana-jta扩展的@javax.transaction.Transactional注解。

@Transactional注解可以被添加道任何CDI bean的方法和类中，让这些方法成为事务性的。

