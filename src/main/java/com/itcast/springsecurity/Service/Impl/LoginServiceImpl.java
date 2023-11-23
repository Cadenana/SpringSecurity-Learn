package com.itcast.springsecurity.Service.Impl;

import com.itcast.springsecurity.Service.LoginService;
import com.itcast.springsecurity.domain.LoginUser;
import com.itcast.springsecurity.domain.ResponseResult;
import com.itcast.springsecurity.domain.User;
import com.itcast.springsecurity.uitils.JwtUtil;
import com.itcast.springsecurity.uitils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
if(Objects.isNull(authenticate))
{
    throw new RuntimeException("登陆失败");
}
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        Long id = principal.getUser().getId();
        String jwt = JwtUtil.createJWT(id.toString());
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+id,principal);
        return new ResponseResult(200,"登陆成功",map);

    }

    @Override
    public ResponseResult logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
LoginUser loginUser=(LoginUser) authentication.getPrincipal();
        Long id = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+id);
return new  ResponseResult(200,"注销成功");

    }
}
