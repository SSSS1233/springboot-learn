package com.subing.service;

import com.subing.dao.UserMapper;
import com.subing.po.User;
import com.github.pagehelper.PageHelper;
import com.subing.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SUBING on 2018/4/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapping;
    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
  @Transactional
    public List<User> selectAll(int pageNum,int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapping.selectAll();
    }

    @Transactional
    public int insert(User user) {
        return userMapping.insert(user);
    }

    @Override
    public String selectName(User user) {
        return userMapping.selectName(user);
    }

    @Override
    public String selectpass(User user) {
        return userMapping.selectpass(user);
    }
}
