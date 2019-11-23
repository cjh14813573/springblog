package me.jinhao.springblog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.CategoryRepository;
import me.jinhao.springblog.service.BlogService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void addBlog(){
		Category category = new Category();
		category.setName("test");
		category.setSlug("test");

		categoryRepository.save(category);

		Blog blog = new Blog();
		blog.setTitle("test");
		blog.setCategory(categoryRepository.getOne(1));
		blog.setContent("testtesttest");
		blogService.addBlog(blog);
	}

}
