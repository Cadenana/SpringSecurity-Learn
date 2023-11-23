package com.itcast.springsecurity.expression;

import com.itcast.springsecurity.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ex")
public class SGExpressionRoot {
 public  boolean hasAuthority(String authority)
 {
     //获取当前用户权限
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
     List<String> permission = loginUser.getPermission();
     //用户及和权限是否存在
     return permission.contains(authority);
 }
}
