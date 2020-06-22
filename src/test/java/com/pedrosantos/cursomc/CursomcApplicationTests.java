package com.pedrosantos.cursomc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedrosantos.cursomc.domain.Category;
import com.pedrosantos.cursomc.service.CategoryService;

@SpringBootTest
class CursomcApplicationTests {

	@Autowired
	public CategoryService categoryService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void list_ValidArg_ReturnCategory() {
		Category expected = new Category(1, "Informática");
		
		Category result = categoryService.find(expected.getId());
		
		assertThat(result.equals(expected));
	}

}
