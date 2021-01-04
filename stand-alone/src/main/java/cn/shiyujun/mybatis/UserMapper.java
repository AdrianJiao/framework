package cn.shiyujun.mybatis;

import cn.shiyujun.entity.User;

/**
 * @author jsf
 * @description:
 * @date 1/4/2021 10:03 AM
 */
public interface UserMapper {
    public void insertUser(User user);

    public User getUser(String name);
}
