import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestConfig {

    @Test
    public void testGenerator(){
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)//AR模式
                .setAuthor("pym")//作者
                .setIdType(IdType.AUTO)//主键策略
                .setOutputDir("D:\\MyBatis-plus-learn\\MyBatisPlus-demo3-MPG\\src\\main\\java")//生成输出路径
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的首字母是否为I
                .setBaseResultMap(true) //基本的结果映射集
                .setBaseColumnList(true);//基本的sql片段==>基本列名

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("root");
        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)//指定表名 字段名 是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//数据库表名映射到实体的命名策略
                .setTablePrefix("tbl_")//默认表名的前缀，稍后只要加上实体类名就是对应的表名了
                .setInclude("tbl_employee");//生成所被需要的表

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.atguigu")//父包名
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("bean")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6.执行
        autoGenerator.execute();
    }

}
