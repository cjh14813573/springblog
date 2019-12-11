package me.jinhao.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.service.PageService;

@Controller
@RequestMapping("/page")
public class OldPageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/{id}")
    public String page(@PathVariable Integer id,Model model){
        Page page = pageService.findPageById(id);
        if(page == null){
            return "redirect:/";
        }else{
            model.addAttribute("page", page);
            return "/page";
        }
    }

    
}