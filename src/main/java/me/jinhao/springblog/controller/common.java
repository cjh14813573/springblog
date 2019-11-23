package me.jinhao.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.Tag;
import me.jinhao.springblog.service.CategoryService;
import me.jinhao.springblog.service.TagService;

@ControllerAdvice
public class common {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @ModelAttribute
    public void widgetsData(Model model) {
        List<Category> wCategories = categoryService.findAllCategories();
        model.addAttribute("wCategories", wCategories);

        List<Tag> wTags = tagService.findAllTags();
        model.addAttribute("wTags", wTags);
    }

}