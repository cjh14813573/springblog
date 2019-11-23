package me.jinhao.springblog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.jinhao.springblog.exception.CategoryNotFoundException;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public String index(@PathVariable Integer id, Model model, HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) {
        try {
            Category category = categoryService.findCategoryById(id);
            model.addAttribute("category", category);
            return "/category";
        } catch (CategoryNotFoundException e) {
            redirectAttributes.addFlashAttribute("message","category does not exist");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:" + httpServletRequest.getHeader("referer");
        }
    }
}