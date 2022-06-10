package org.example.app.security.jpa;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "test_user")
@UserDefinition   //只有使用UserDefinition 注解是，security-jpa扩展才会初始化
public class User extends PanacheEntity {

    @Username         //用于用户名的字段
    public String uname;
    @Password         //用于密码的字段
    public String pwd;
    @Roles            //用逗号分割的角色列表
    public String role;


    public static void add(String uname, String pwd, String role) {
        User user = new User();
        user.uname = uname;
        user.pwd = BcryptUtil.bcryptHash(pwd);
        user.role = role;
        user.persist();
    }
}
