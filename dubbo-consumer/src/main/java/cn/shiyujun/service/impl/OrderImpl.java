package cn.shiyujun.service.impl;

import cn.shiyujun.model.User;
import cn.shiyujun.service.OrderService;
import cn.shiyujun.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {

    //使用dubbo提供的@Reference访问远程服务
    //version对应服务提供者的version
    @Reference(version = "3")
    private UserService userService;

    @Override
    public List<User> init() {
        List<User> list = userService.getAll();
        list.forEach(item -> System.out.println(item.getName()));
        return list;
    }
}
