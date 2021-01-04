package cn.shiyujun.mybatis;

import cn.shiyujun.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jsf
 * @description:
 * @date 12/25/2020 9:30 AM
 */
public class TestSpringMybatis {

    public static void main(String[] args) {
        testMapper();
        testMapperFactoryBeanMapper();
    }

    public static void testMapper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-mybatis.xml");
        //<mybatis:scan> 注入的mapper
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.getUser("zhangsan");
        System.out.println("name: " + user.getName() + "|age: " + user.getAge());
    }

    public static void testMapperFactoryBeanMapper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-mybatis.xml");
        //MapperFactoryBean 注入的mapper, 获取工厂本事用name &userMapper2
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        User user = userMapper.getUser("zhangsan");
        System.out.println("name: " + user.getName() + "|age: " + user.getAge());
    }
}