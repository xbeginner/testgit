package com.viewtest.design.myview;

/**
 * Created by pc on 2016/12/7.
 */
public class UserInfo {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
