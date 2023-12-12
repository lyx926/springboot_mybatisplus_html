package com.example.book_crud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book_crud.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lyx
 */
@Mapper
public interface TodoDao extends BaseMapper<Todo> {

}
