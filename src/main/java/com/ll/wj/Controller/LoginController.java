package com.ll.wj.Controller;

import com.ll.wj.pojo.Result;
import com.ll.wj.pojo.User;
import com.ll.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author 10162496
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requesUser, HttpSession session){

        String username = requesUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requesUser.getPassword());
        if(null == user){
            return new Result(400);
        }else{
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
