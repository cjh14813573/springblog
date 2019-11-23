package me.jinhao.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.model.PageRepository;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;


    public Page findPageBySlug(String slug){
        return pageRepository.findBySlug(slug);
    }
}