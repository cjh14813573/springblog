package me.jinhao.springblog.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public Category test() {
        return null;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.findCategoryById(id);
        return category;
    }
}