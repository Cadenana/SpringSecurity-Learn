package com.itcast.springsecurity;

import com.itcast.springsecurity.Mapper.MenuMapper;
import com.itcast.springsecurity.Mapper.UserMapper;
import com.itcast.springsecurity.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class mpTest {
@Autowired
    private UserMapper userMapper;
@Autowired
private MenuMapper mapper;
@Test
public void Test02()
{
    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    String encode = passwordEncoder.encode("1234");
    String encode1 = passwordEncoder.encode("1234");
    System.out.println(encode1);
    System.out.println(encode);
    boolean mac = passwordEncoder.matches("1234", "$2a$10$yM7ITY74Ko592lc42veRbOq3Zdb4d8iQXDEcsQ0uHVGBrYPvRlYyC");
    System.out.println(mac);
}
    @Test
    public void testUserMapper()
    {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void test04()
    {
        long userid = 2L;
        List<String> strings = mapper.selectPermsByUserId(userid);
        System.out.println(strings);
    }
}
