package com.itcast.springsecurity.handler;


import com.alibaba.fastjson.JSON;
import com.itcast.springsecurity.domain.ResponseResult;
import com.itcast.springsecurity.uitils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult responseResult=new ResponseResult(HttpStatus.FORBIDDEN.value(),"您的权限不足");
        String jsonString = JSON.toJSONString(responseResult);
        //处理认证异常
        WebUtils.renderString(httpServletResponse,jsonString);
    }
}
