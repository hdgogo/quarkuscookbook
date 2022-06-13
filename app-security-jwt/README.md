# app-security-jwt Project

Quarkus应用程序如何使用JWT验证用户身份

## 必要的扩展依赖
`smallrye-jwt` ,`smallrye-jwt-build` 

```shell
$ ./mvnw quarkus:add-extension -Dextensions="smallrye-jwt,smallrye-jwt-build"
```

## 相关配置
```properties
mp.jwt.verify.publickey.location=publicKey.pem      //公钥位置
mp.jwt.verify.issuer=https://example.com/issuer     //验证发行人

quarkus.native.resources.includes=publicKey.pem     
```


### openssl钥匙对

```shell
$ openssl genrsa -out rsaPrivateKey.pem 2048                           //生成私钥
$ openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem         //基于私钥生成公钥
$ openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem  //将私钥转换为PKCS#8格式
```
