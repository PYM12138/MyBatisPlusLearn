
import com.atguigu.bean.Employee;
import com.atguigu.bean.User;
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MyBatisPlustest06 {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
    private final UserMapper userMapper = ioc.getBean("userMapper", UserMapper.class);
    @Test
    public void test1(){//自定义自动注入器
        List<Employee> employees = employeeMapper.selectAll(1);
        System.out.println(employees);

    }
    @Test
    public void test2(){ //逻辑删除操作

       /* Integer integer = userMapper.deleteById(1);
        System.out.println(integer);*/

        //验证
        // SELECT id,`name`,logic_flag AS logicFlag FROM tbl_user WHERE id=? AND logic_flag=1
        User user = userMapper.selectById(1);
        System.out.println(user);
    }



}
