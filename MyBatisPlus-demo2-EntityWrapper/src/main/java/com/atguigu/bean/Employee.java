package com.atguigu.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/*
* @TableName(value = "tbl_employee")
* 指定表名。不使用则默认为当前的类名
* */
@TableName(value = "tbl_employee")
public class Employee {
    /*
    *  @TableId(value = "id",type = IdType.AUTO)
    * - 指定主键注解
    * - value是对应的数据表的主键名，该值默认开启驼峰命名，两者一样则可以省略
    * - type用于指定主键策略
    * */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*
    * 指定字段名，里面还有一个属性是 exist=false,如果对应的数据表不存在这个类的字段，可以用这个属性声明
    * */
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
