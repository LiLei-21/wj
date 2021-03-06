package com.ll.wj.service;

import com.ll.wj.dao.UserDao;
import com.ll.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10162496
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username){
        User user =getByName(username);
        return null!=user;
    }

    public User getByName(String username){
        return userDao.findByUsername(username);
    }

    public User get (String username, String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDao.save(user);
    }
}
