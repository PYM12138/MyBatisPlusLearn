
import com.atguigu.bean.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MyBatisPlustest02 {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void test1() throws Exception {
        DataSource source = ioc.getBean("dataSource", DataSource.class);
        System.out.println(source);
        Connection connection = source.getConnection();
        System.out.println(connection);
    }

    /*
     * 条件构造器 查询操作
     */

    @Test
    public void test2() {//selectPage  selectList
        //分页查询：年龄在10~15之间，并且性别为男，姓名为胡图图
        List<Employee> employeeList = employeeMapper.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>()
                        //column填写的是数据库的列名，非javaBean的属性名
                        .between("age", 22, 25)
                        .eq("last_name", "Tom")
                        .eq("gender", 1)
        );
        System.out.println(employeeList);

        //查询条件中，性别为女，并且名字中带有T的。或者邮箱中带有"e"
        List<Employee> employeeList1 = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 0)
                .like("last_name", "T")
                //.or()     //SQL:(gender = ? AND last_name LIKE ? OR email LIKE ?)
                .orNew()    //SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
                .like("email", "e")
        );
        System.out.println(employeeList1);
    }


    /*
    * 条件构造器 修改操作
    * */
    @Test
    public void test3(){
        Employee employee = new Employee();//要修改的内容
        employee.setLastName("再见");
        employee.setGender(0);
        Integer update = employeeMapper.update(employee, new EntityWrapper<Employee>()
                //被修改的条件
                .eq("last_name", "关谷神奇")
                .eq("gender", 1)
        );
        System.out.println(update);
    }

    /*
    条件按构造器 删除操作
    */
    @Test
    public void test4(){
        Integer delete = employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name", "再见"));
        System.out.println(delete);

    }
    @Test
    public void test5(){
        List<Employee> age = employeeMapper.selectList(new EntityWrapper<>(new Employee())
                //.orderDesc(Collections.singletonList("age"))
                //.orderAsc(Collections.singletonList("age"))
                //.orderBy("age", false)
                .orderBy("age")

                //这个是直接在sql语句之后加入字符串，所以有sql注入风险
                .last("desc")
        );
        System.out.println(age);

    }


}
