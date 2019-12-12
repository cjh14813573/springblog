package me.jinhao.springblog.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.exception.BlogNotFoundException;
import me.jinhao.springblog.exception.CategoryNotFoundException;
import me.jinhao.springblog.exception.TagNotFoundException;
import me.jinhao.springblog.form.BlogForm;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.BlogRepository;
import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.CategoryRepository;
import me.jinhao.springblog.model.Tag;
import me.jinhao.springblog.model.TagRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    public Blog findBlogById(Integer id) {
        Optional<Blog> blog = blogRepository.findById(id);

        if (!blog.isPresent()) {

            throw new BlogNotFoundException("The blog does not exist");
        }

        return blog.get();
    }

    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog addBlogByForm(BlogForm blogForm) {
        Blog blog = new Blog();

        Optional<Category> optionalCategory = categoryRepository.findById(blogForm.getCategoryId());

        if (!optionalCategory.isPresent()) {
            throw new CategoryNotFoundException();
        }

        List<Tag> tagList = new ArrayList<Tag>();

        if (blogForm.getTagIdList() != null) {
            for (Integer tagId : blogForm.getTagIdList()) {
                Optional<Tag> optionalTag = tagRepository.findById(tagId);
                if (!optionalTag.isPresent()) {
                    throw new TagNotFoundException();
                } else {
                    tagList.add(optionalTag.get());
                }
            }
        }

        blog.setTitle(blogForm.getTitle());
        blog.setBrief(blogForm.getBrief());
        blog.setContent(blogForm.getContent());
        blog.setCategory(optionalCategory.get());
        blog.setTagList(tagList);

        return blogRepository.save(blog);
    }

    public Blog editBlogByForm(BlogForm blogForm) {

        Optional<Category> optionalCategory = categoryRepository.findById(blogForm.getCategoryId());

        if (!optionalCategory.isPresent()) {
            throw new CategoryNotFoundException();
        }

        List<Tag> tagList = new ArrayList<Tag>();

        if (blogForm.getTagIdList() != null) {
            for (Integer tagId : blogForm.getTagIdList()) {
                Optional<Tag> optionalTag = tagRepository.findById(tagId);
                if (!optionalTag.isPresent()) {
                    throw new TagNotFoundException();
                } else {
                    tagList.add(optionalTag.get());
                }
            }
        }

        Optional<Blog> optionalBlog = blogRepository.findById(blogForm.getId());
        if(!optionalBlog.isPresent()){
            throw new BlogNotFoundException("Blog does not exist");
        }
        Blog blog = optionalBlog.get();

        blog.setTitle(blogForm.getTitle());
        blog.setBrief(blogForm.getBrief());
        blog.setContent(blogForm.getContent());
        blog.setCategory(optionalCategory.get());
        blog.setTagList(tagList);

        return blogRepository.save(blog);
    }

    public void deleteBlogById(Integer id){
        if(blogRepository.findById(id).isPresent()){
            blogRepository.deleteById(id);
        }else{
            throw new BlogNotFoundException();
        }
    }

	public Page<Blog> findAllBlogsByPage(Integer page) {
        Pageable pageable = PageRequest.of(page,2,Sort.Direction.DESC,"createdTime");
        Page<Blog> blogs= blogRepository.findAll(pageable);
		return blogs;
	}
}