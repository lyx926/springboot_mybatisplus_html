package com.example.crud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.crud.domain.Book;

/**
 * @author lyx
 */
public interface BookService extends IService<Book> {

    /**
     * 修改
     *
     * @param book
     * @return
     */
    boolean modify(Book book);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Book> getPage(int currentPage, int pageSize);

    /**
     * 参数查询
     *
     * @param currentPage
     * @param pageSize
     * @param book
     * @return
     */
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
