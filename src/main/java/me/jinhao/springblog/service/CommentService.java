package me.jinhao.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.model.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    
}