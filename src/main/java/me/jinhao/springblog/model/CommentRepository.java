package me.jinhao.springblog.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment,Integer>{

    List<Comment> findByBlogIdOrderByCreatedTimeDesc(Integer blogId);

    List<Comment> findAllByOrderByCreatedTimeDesc();
    
}