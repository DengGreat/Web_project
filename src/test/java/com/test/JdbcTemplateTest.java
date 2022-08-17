package com.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class JdbcTemplateTest {
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        int row = app.getBean(JdbcTemplate.class).update("insert into account value(?,?)","l李四",5000);
        System.out.println(row);
    }


    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        int row = app.getBean(JdbcTemplate.class).update("insert into account value(?,?)","l李四",5000);
        System.out.println(row);
    }
    @Test
    //测试JdbcTemplate开发步骤
    public void test1(){
        //创建数据源
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象，知道数据库在哪
        jdbcTemplate.setDataSource(app.getBean(DataSource.class));
//        执行操作
        int row = jdbcTemplate.update("   insert into account value(?,?)","tom",5000);
        System.out.println(row);
    }
}
