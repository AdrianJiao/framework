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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-mybatis.xml");
        //<mybatis:scan> 注入的mapper
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        //MapperFactoryBean 注入的mapper
//        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        User user = userMapper.getUser("zhangsan");
        System.out.println("name: " + user.getName() + "|age: " + user.getAge());
    }
}
