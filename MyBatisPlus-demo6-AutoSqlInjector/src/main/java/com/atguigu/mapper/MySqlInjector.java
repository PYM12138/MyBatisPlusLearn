package com.atguigu.mapper;

import com.atguigu.bean.Employee;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MySqlInjector extends AutoSqlInjector {

    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //1.在EmployeeMapper接口中，定义一个方法。处理成对应的MappedStatement对象，加入到configuration对象中(也就是Spring配置文件)
        //2.注入sql语句
        String sql ="select * from " + table.getTableName();

        //3.注入方法名 要和接口方法名一致
        String method="selectAll";

        //4.构造sqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        //5.构造一个查询的MappedStatement
        this.addSelectMappedStatement(mapperClass, method, sqlSource, Employee.class, table);



    }
}
