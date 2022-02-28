package com.atguigu.bean;

import com.baomidou.mybatisplus.annotations.TableLogic;

public class User {
    private Integer id;
    private String name;
    @TableLogic //标明逻辑操作属性
    private Integer logicFlag;

    public User() {
    }

    public User(Integer id, String name, Integer logicFlag) {
        this.id = id;
        this.name = name;
        this.logicFlag = logicFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logicFlag=" + logicFlag +
                '}';
    }
}
