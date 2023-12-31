package com.itcast.springsecurity.Contorller;

import com.itcast.springsecurity.Service.LoginService;
import com.itcast.springsecurity.domain.ResponseResult;
import com.itcast.springsecurity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user)
    {
   return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout()
    {
        return loginService.logout();
    }
}
