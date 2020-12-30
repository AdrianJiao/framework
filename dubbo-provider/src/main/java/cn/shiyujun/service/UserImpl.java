package cn.shiyujun.service;

import cn.shiyujun.model.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//暴露服务
//这里的@Service是Dubbo提供的，不是spring中的
//version必填
@Service(version = "${dubbo.application.version}")
@Component
public class UserImpl implements UserService {
    @Override
    public List<User> getAll() {
        User user1 = new User("张三");
        User user2 = new User("lisi");
        List<User> list = Arrays.asList(user1, user2);
        return list;
    }

    @Override
    public List<User> getAll2() {
        return null;
    }
}