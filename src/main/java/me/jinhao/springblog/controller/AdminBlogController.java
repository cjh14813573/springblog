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

import me.jinhao.springblog.exception.BlogNotFoundException;
import me.jinhao.springblog.exception.CategoryNotFoundException;
import me.jinhao.springblog.exception.TagNotFoundException;
import me.jinhao.springblog.form.BlogForm;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.service.BlogService;
import me.jinhao.springblog.service.CategoryService;

@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAllBlogs());
        return "/admin/blog/index";
    }

    @GetMapping("/add")
    public String add(BlogForm blog, Model model) {
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categories);
        return "/admin/blog/add";
    }

    @PostMapping("/add")
    public String add(@Valid BlogForm blogForm, BindingResult bindingResult, RedirectAttributes redirectAttributes,
            Model model) throws Exception {

        List<Category> categories = categoryService.findAllCategories();

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categories);
            return "/admin/blog/add";
        }

        try {
            blogService.addBlogByForm(blogForm);
        } catch (CategoryNotFoundException e) {
            bindingResult.rejectValue("categoryId", "error.user", "you must choose a valid catetgory");
            model.addAttribute("categories", categories);
            return "/admin/blog/add";
        } catch (TagNotFoundException e) {
            bindingResult.rejectValue("tagId", "error.user", "tag not found");
            model.addAttribute("categories", categories);
            return "/admin/blog/add";
        }

        redirectAttributes.addFlashAttribute("message", "Product added");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            BlogForm blogForm = new BlogForm(blogService.findBlogById(id));
            model.addAttribute("blogForm", blogForm);
            List<Category> categories = categoryService.findAllCategories();
            model.addAttribute("categories", categories);
        } catch (BlogNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/blog";
        }
        return "/admin/blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid BlogForm blogForm, BindingResult bindingResult, RedirectAttributes redirectAttributes,
            Model model) throws Exception {

        List<Category> categories = categoryService.findAllCategories();

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categories);
            return "/admin/blog/edit";
        }

        try {
            blogService.editBlogByForm(blogForm);
        } catch (CategoryNotFoundException e) {
            bindingResult.rejectValue("categoryId", "error.user", "you must choose a valid catetgory");
            model.addAttribute("categories", categories);
            return "/admin/blog/edit";
        } catch (TagNotFoundException e) {
            bindingResult.rejectValue("tagId", "error.user", "tag not found");
            model.addAttribute("categories", categories);
            return "/admin/blog/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Blog edited");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        try {
            blogService.deleteBlogById(id);
            redirectAttributes.addFlashAttribute("message", "Blog deleted");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (BlogNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Blog does not exist");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/admin/blog";
    }

}