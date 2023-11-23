package com.itcast.springsecurity.Contorller;

import com.itcast.springsecurity.domain.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    //    @PreAuthorize("hasAnyAuthority('system:dept:list')")
//  @PreAuthorize("hasAnyRole('admin','coder')")
//    @PreAuthorize("hasAnyAuthority('system:dept:list','test')")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")//自定义权限校验
    @RequestMapping("/hello")
    public String hello()
{
return  "hello";
}

@RequestMapping("/testCors")
    public ResponseResult testCors()
{
    return new ResponseResult(200,"testCors");
}
}
