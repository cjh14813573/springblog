package me.jinhao.springblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.exception.CategoryNotFoundException;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.BlogRepository;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BlogRepository blogRepository;

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public void addCategory(Category category) {
		category.setSlug(category.getName().trim().toLowerCase().replace(" ", "-"));
		categoryRepository.save(category);
	}

	public Category findCategoryById(Integer id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (!optionalCategory.isPresent()) {
			throw new CategoryNotFoundException("category does not exist");
		}
		return optionalCategory.get();
	}

	public void editCategory(Category category) {
		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
		if (!optionalCategory.isPresent()) {
			throw new CategoryNotFoundException("category does not exist");
		}

		String name = category.getName();
		String slug = name.trim().toLowerCase().replace(" ", "-");
		Category category2Save = optionalCategory.get();
		category2Save.setName(name);
		category2Save.setSlug(slug);
		categoryRepository.save(category2Save);
	}

	public void deleteCategoryById(Integer id) {
		if (!categoryRepository.existsById(id)) {
			throw new CategoryNotFoundException("category does not exist");
		}
		if(id == 1){
			throw new CategoryNotFoundException("you cannot delete the default category");
		}
		Category defaultCategory = categoryRepository.getOne(1);
		Category category = categoryRepository.getOne(id);
		List<Blog> blogs = category.getBlogList();
		for(Blog blog : blogs){
			blog.setCategory(defaultCategory);
			blogRepository.save(blog);
		}
		categoryRepository.deleteById(id);
	}
}