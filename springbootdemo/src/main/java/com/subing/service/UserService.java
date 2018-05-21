package com.subing.service;

import com.subing.po.User;
import com.subing.po.User;

import java.util.List;

/**
 * Created by SUBING on 2018/4/4.
 */
public interface UserService {
    List<User> selectAll(int a, int b);
    int insert(User user);
    String selectName(User user);
    String selectpass(User user);
}
