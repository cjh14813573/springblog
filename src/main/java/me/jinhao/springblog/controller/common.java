package me.jinhao.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.model.Tag;
import me.jinhao.springblog.service.CategoryService;
import me.jinhao.springblog.service.PageService;
import me.jinhao.springblog.service.TagService;

@ControllerAdvice
public class common {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PageService pageService;

    @ModelAttribute
    public void widgetsData(Model model) {
        List<Category> wCategories = categoryService.findAllCategories();
        model.addAttribute("wCategories", wCategories);

        List<Tag> wTags = tagService.findAllTags();
        model.addAttribute("wTags", wTags);
    }

    @ModelAttribute
    public void navData(Model model) {
        List<Page> nPages = pageService.findAllPages();
        model.addAttribute("nPages", nPages);
    }
}