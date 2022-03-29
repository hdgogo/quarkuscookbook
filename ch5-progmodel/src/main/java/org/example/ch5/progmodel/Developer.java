package org.example.ch5.progmodel;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *  实体类，该类将在端点被编组和解组
 */
public class Developer {

    @Size(min=4) //字符串最小长度为4
    private String name;

    @JvmLanguage
    @NotBlank  //不能为空
    @JsonbProperty("favorite-language")
    private String favoriteLanguage;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
