package com.example.crud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.crud.dao.TodoDao;
import com.example.crud.domain.Todo;
import com.example.crud.service.TodoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyx
 */
@Service
public class TodoServiceImpl extends ServiceImpl<TodoDao, Todo> implements TodoService {
    private final TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public boolean saveTodo(Todo todo) {
        List<Todo> task = todoDao.selectList(new QueryWrapper<Todo>().eq("task", todo.getTask()));
        if (task.isEmpty()) {
            return todoDao.insert(todo) > 0;
        } else {
            return true;
        }
    }


    @Override
    public boolean modify(Todo todo) {
        return todoDao.updateById(todo) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return todoDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Todo> getPage(int currentPage, int pageSize) {
        return todoDao.selectPage(new Page(currentPage, pageSize), null);
    }

    @Override
    public IPage<Todo> getPage(int currentPage, int pageSize, Todo todo) {
        LambdaQueryWrapper<Todo> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(todo.getTask()), Todo::getTask, todo.getTask());
        lqw.orderByDesc(Todo::getId);
        return todoDao.selectPage(new Page(currentPage, pageSize), lqw);
    }
}