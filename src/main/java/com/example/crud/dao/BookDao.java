package com.example.crud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.crud.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lyx
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
