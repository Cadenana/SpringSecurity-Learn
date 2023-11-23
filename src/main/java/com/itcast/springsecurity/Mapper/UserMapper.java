package com.itcast.springsecurity.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcast.springsecurity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
