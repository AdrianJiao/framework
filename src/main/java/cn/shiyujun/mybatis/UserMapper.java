package cn.shiyujun.mybatis;

import cn.shiyujun.entity.User;

public interface UserMapper {
    public void insertUser(User user);

    public User getUser(String name);
}
