package me.jinhao.springblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.exception.BlogNotFoundException;
import me.jinhao.springblog.form.CommentForm;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.BlogRepository;
import me.jinhao.springblog.model.Comment;
import me.jinhao.springblog.model.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    public void addCommentByForm(CommentForm commentForm){
        Optional<Blog> optionalBlog = blogRepository.findById(commentForm.getBlogId());
        if(!optionalBlog.isPresent()){
            throw new BlogNotFoundException();
        }else{
            Comment comment = new Comment();
            comment.setBlog(optionalBlog.get());
            comment.setName(commentForm.getName());
            comment.setEmail(commentForm.getEmail());
            comment.setWebsite(commentForm.getWebsite());
            comment.setContent(commentForm.getContent());
            commentRepository.save(comment);
        }

    }

    public List<Comment> findCommentsByBlogIdOrderByCreatedTimeDesc(Integer blogId){

        return commentRepository.findByBlogIdOrderByCreatedTimeDesc(blogId);

    }

    public List<Comment> findAllComments(){
        return commentRepository.findAll();
    }

    public List<Comment> findAllCommentsByOrderByCreatedTimeDesc(){
        return commentRepository.findAllByOrderByCreatedTimeDesc();
    }

	public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
	}

    
}