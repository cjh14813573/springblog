package me.jinhao.springblog.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.service.PageService;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/{id}")
    public Page page(@PathVariable Integer id){
        Page page = pageService.findPageById(id);
        return page;
    }

    
}