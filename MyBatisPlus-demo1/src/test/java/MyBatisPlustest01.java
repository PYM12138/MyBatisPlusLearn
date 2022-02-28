
import com.atguigu.bean.Employee;
import com.atguigu.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;


public class MyBatisPlustest01 {
   private final ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
   private final EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
    @Test
    public void test1() throws Exception {
        DataSource source = ioc.getBean("dataSource", DataSource.class);
        System.out.println(source);
        Connection connection = source.getConnection();
        System.out.println(connection);
    }
    @Test
    public void test2Insert(){
        Employee htt = new Employee(null, "胡图图", "htt@168.com", 1, 12);
       /*
       * insert() 这个方法会对属性进行非空判断，有值才有对应的字段插入，无则数据库自动给默认值(null)
       * insertAllColumn() 默认对全部属性全部字段进行插入
       *
       * */

        Integer insert = employeeMapper.insert(htt);
        System.out.println("影响的行数："+insert);
        //获取当前插入数据的主键值
        /*
        * Mybatis获取返回的主键值方式
        * <insert userGenerated=true,keyProperty=(javaBean)"id">sql语句<insert/>
        * */
        Integer id = htt.getId();
        System.out.println(id);

    }
    @Test
    public void test3Update(){
        /*
        * 这里面也有一个updateAllColumnById()方法，相关信息同上面的差不多
        * */
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("胡一菲");
        employee.setEmail("dajixuedefengtu@168.com");
        employee.setGender(0);
        Integer integer = employeeMapper.updateById(employee);
        System.out.println(integer);

    }

    @Test
    public void test4Select(){
        /*
        * selectById和selectOne 都是只能返回一条结果，只是查询条件不同
        * */
 /*       Employee employee1 = employeeMapper.selectById(1);
        System.out.println(employee1);
        System.out.println("---------------------------------------");
        Employee employee = new Employee();
        employee.setLastName("胡一菲");
        employee.setAge(12);
        Employee employee2 = employeeMapper.selectOne(employee);
        System.out.println(employee2);
        System.out.println("---------------------------------------");*/

        //通过id集合来查询多个数据
       /* List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(employees);*/

        //用map集合封装查询条件
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("last_name", "胡一菲");
        List<Employee> employees1 = employeeMapper.selectByMap(hashMap);
        System.out.println(employees1);


    }
    @Test
    public void test5Delete(){
       /* //1.通过id删除数据
        Integer integer = employeeMapper.deleteById(1);
        System.out.println("影响行数:"+integer);
        //2.map集合封装删除条件
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("last_name", "胡一菲");
        employeeMapper.deleteByMap(hashMap);
        //3.通过id集合批量删除
        employeeMapper.deleteBatchIds(Arrays.asList(1, 2, 3));*/
    }

}
