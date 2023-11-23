package com.itcast.springsecurity.Service;

import com.itcast.springsecurity.domain.ResponseResult;
import com.itcast.springsecurity.domain.User;

public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();

}
