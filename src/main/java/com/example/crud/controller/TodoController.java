package com.example.crud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.crud.controller.utils.Result;
import com.example.crud.domain.Todo;
import com.example.crud.service.TodoService;
import org.springframework.web.bind.annotation.*;

/**
 * @author lyx
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Result queryAll() {
        return new Result(true, todoService.list());
    }

    @PostMapping
    public Result save(@RequestBody Todo todo) {
        return new Result(todoService.saveTodo(todo));
    }

    @PutMapping
    public Result update(@RequestBody Todo todo) {
        return new Result(todoService.modify(todo));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(todoService.delete(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, todoService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Todo todo) {
        IPage<Todo> page = todoService.getPage(currentPage, pageSize, todo);
        // 如果当前页码值大于总页码数，那么重新执行查询操作，使用最大页码值作为当前页码值。
        if (currentPage > page.getPages()) {
            return new Result(true, todoService.getPage((int) page.getPages(), pageSize));
        }
        return new Result(true, todoService.getPage(currentPage, pageSize, todo));
    }

}