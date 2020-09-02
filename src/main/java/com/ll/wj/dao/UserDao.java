package com.ll.wj.dao;

import com.ll.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10162496
 */
public interface UserDao extends JpaRepository<User,Integer>{
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
}
