package com.itcast.springsecurity.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itcast.springsecurity.Mapper.MenuMapper;
import com.itcast.springsecurity.Mapper.UserMapper;
import com.itcast.springsecurity.domain.LoginUser;
import com.itcast.springsecurity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
@Autowired
private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
       LambdaQueryWrapper<User> wrapper =new LambdaQueryWrapper<>();
       wrapper.eq(User::getUserName,username);
       User user=userMapper.selectOne(wrapper);
       if(Objects.isNull(user))
       {
           throw  new RuntimeException("用户名或密码错误");
       }
//        List<String> list=new ArrayList<>(Arrays.asList("test","admin"));
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        return new LoginUser(user,list);
    }
}
