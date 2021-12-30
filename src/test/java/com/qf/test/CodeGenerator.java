package com.qf.test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前路径
        String projectPath = System.getProperty("user.dir");
        //设置生成代码位置
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置代码文件头作者
        gc.setAuthor("在逃老甜心");
        //设置是否在资源管理器打开
        gc.setOpen(true);
        //设置生成代码是否覆盖
        gc.setFileOverride(true);
        //设置去除生成代码接口中的I
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql:///new_order");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("left5501");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置模块名称
        //pc.setModuleName("shopping");
        pc.setParent("com.qf");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名  下划线转驼峰  tb_user
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名  下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //实体类是否使用lombok
        strategy.setEntityLombokModel(true);
        //Controller是否使用RESTful风格(RestController)
        strategy.setRestControllerStyle(true);

        //设置逻辑删除字段(数据库中需要有deleted字段)
        strategy.setLogicDeleteFieldName("deleted");
        //设置乐观锁注解(数据库中需要有version字段)
        strategy.setVersionFieldName("version");
        
        //设置生成的表名
        strategy.setInclude("merchants","order","order_detail","product","user");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}