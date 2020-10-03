package com.pedrosantos.application.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.pedrosantos.application.domain.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String name;

    public CategoryDTO(Category c) {
        this.id = c.getId();
        this.name = c.getName();
    }
}