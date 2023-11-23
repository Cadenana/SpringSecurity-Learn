package com.itcast.springsecurity.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcast.springsecurity.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userid);
}
