package com.example.crud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.crud.domain.Todo;

/**
 * @author lyx
 */
public interface TodoService extends IService<Todo> {
    /**
     * 追加的操作与原始操作通过名称区分，功能类似
     *
     * @param book
     * @return
     */
    boolean saveTodo(Todo book);

    /**
     * 修改任务
     *
     * @param book
     * @return
     */
    boolean modify(Todo book);

    /**
     * 删除任务
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 获取分页数据
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Todo> getPage(int currentPage, int pageSize);

    /**
     * 获取分页数据
     *
     * @param currentPage
     * @param pageSize
     * @param book
     * @return
     */
    IPage<Todo> getPage(int currentPage, int pageSize, Todo book);
}
