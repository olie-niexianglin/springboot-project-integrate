package com.olie.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6123494199269058433L;


    private int age;

    @JSONField(name = "heloo")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
