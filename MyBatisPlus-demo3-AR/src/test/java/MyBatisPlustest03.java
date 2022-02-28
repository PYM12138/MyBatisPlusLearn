
import com.atguigu.bean.Employee;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MyBatisPlustest03 {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    //private final EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void test1ARInsert(){
        Employee employee = new Employee();
        employee.setLastName("吕子乔");
        employee.setEmail("lzq@ipartment.com");
        employee.setGender(1);
        employee.setAge(22);

        employee.insert();
    }


    @Test
    public void test2ARUpdate(){
        Employee employee = new Employee();
        employee.setLastName("陈美嘉");
        employee.setEmail("cmj@ipartment.com");
        employee.setGender(1);
        employee.setAge(22);
        employee.setId(8);
        boolean b = employee.updateById();
        System.out.println(b);

    }
    @Test
    public  void  test3ARSelect(){
        Employee employee = new Employee();
        //通过id查询
      /*  Employee employee1 = employee.selectById(1);
        System.out.println(employee1);

        employee.setId(1);
        Employee employee2 = employee.selectById();
        System.out.println(employee2);*/

        //查询全部
        /*List<Employee> employees = employee.selectAll();
        System.out.println(employees);*/

        //带条件查询
       /* List<Employee> gender = employee.selectList(new EntityWrapper(new Employee()).like("gender", "1"));
        System.out.println(gender);*/

        /*List<Employee> employees = employee.selectList("gender=1", "1");
        System.out.println(employees);*/

        //查询条数
        /*int i = employee.selectCount(null);
        System.out.println(i);*/
        int i1 = employee.selectCount("gender=1", null);
        System.out.println(i1);


    }
    @Test
    public  void  test4ARDelete(){
        Employee employee = new Employee();
//        employee.setId(1);
//        boolean b = employee.deleteById();
//
//        boolean b1 = employee.deleteById(1);
//
//        employee.delete(new EntityWrapper(new Employee()).like())
    }

    @Test
    public  void  test5ARPage(){
        Employee employee = new Employee();
        Page<Employee> gender = employee.selectPage(new Page<>(1, 2), new EntityWrapper<>(new Employee()).like("gender", "1"));
        List<Employee> records = gender.getRecords();
        System.out.println(records);
    }





}
