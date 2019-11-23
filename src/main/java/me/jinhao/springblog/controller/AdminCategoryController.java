package me.jinhao.springblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.jinhao.springblog.exception.CategoryNotFoundException;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model){
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "/admin/category/index";
    }

    @GetMapping("/add")
    public String add(Category category, Model model){

        return "/admin/category/add";

    }

    @PostMapping("/add")
    public String add(@Valid Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        if(bindingResult.hasErrors()){
            return "/admin/category/add";
        }
        

        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("message", "Category added");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model){
        try {
            Category category = categoryService.findCategoryById(id);
            model.addAttribute("category", category);
        } catch (CategoryNotFoundException e) {
            redirectAttributes.addFlashAttribute("message","category does not exist");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/category";
        }

        return "/admin/category/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            return "/admin/category/edit";
        }

        try{
            categoryService.editCategory(category);
            redirectAttributes.addFlashAttribute("message","category edited");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (CategoryNotFoundException e){
            redirectAttributes.addFlashAttribute("message","category does not exist");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/admin/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            categoryService.deleteCategoryById(id);
            redirectAttributes.addFlashAttribute("message","category deleted");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (CategoryNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        
        return "redirect:/admin/category";
    }
    
}