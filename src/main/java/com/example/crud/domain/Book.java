package com.example.crud.domain;

import lombok.Data;

/**
 * @author lyx
 */
@Data
public class Book {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型
     */
    private String type;
    /**
     * 名字
     */
    private String name;
    /**
     * 描述
     */
    private String description;
}
