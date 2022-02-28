
import com.atguigu.bean.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MyBatisPlustest05 {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    /*
    * 测试分页插件
    * */
    @Test
    public void test1(){
        Page<Employee> employeePage = new Page<>(1, 1);

        List<Employee> employees = employeeMapper.selectPage(employeePage, null);
        System.out.println(employees);
        System.out.println("============分页所需功能展示====================");
        System.out.println("总条数"+employeePage.getTotal());
        System.out.println("当前页码:"+employeePage.getCurrent());
        System.out.println("总页数："+employeePage.getPages());
        System.out.println("每页显示的条数目:"+employeePage.getSize());
        System.out.println("是否有上一页:"+employeePage.hasPrevious());
        System.out.println("是否有下一页:"+employeePage.hasNext());

        //刚刚我实验了，发现page对象里面没有数据结果，需要自己手动去set!
        employeePage.setRecords(employees);

    }

    /*
    * 测试执行分析插件
    * */
    @Test
    public void test2(){
        // Error: Full table operation is prohibited. SQL: DELETE FROM tbl_employee
        //在sql语句前面加入EXPLAIN 可以分析你当前的操作，这也是执行分析插件的原理
        employeeMapper.delete(null);

    }

    /*
    *
    * 测试性能分析插件
    * */
    @Test
    public void test3(){
        // 超过规定的执行时间报错:The SQL execution time is too large, please optimize !
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }



}
