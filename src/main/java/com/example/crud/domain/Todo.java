package com.example.crud.domain;

import lombok.Data;

/**
 * @author lyx
 */
@Data
public class Todo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 任务
     */
    private String task;
}
