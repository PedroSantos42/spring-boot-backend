package com.pedrosantos.cursomc.dto;

import java.io.Serializable;

import com.pedrosantos.cursomc.domain.Category;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoryDTO(Category c) {
        this.id = c.getId();
        this.name = c.getName();
    }

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}