package me.jinhao.springblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.model.Tag;
import me.jinhao.springblog.model.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAllTags(){
        return tagRepository.findAll();
    }
}