package com.atguigu.mapper;

import com.atguigu.bean.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/*
* 只要继承BaseMapper,然后再把javaBean填入泛型就可以CRUD了
* */

public interface EmployeeMapper extends BaseMapper<Employee> {
}
