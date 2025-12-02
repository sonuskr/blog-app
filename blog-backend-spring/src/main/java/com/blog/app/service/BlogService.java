package com.blog.app.service;

import com.blog.app.model.Blog;
import com.blog.app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blogDetails) {
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isPresent()) {
            Blog blog = existingBlog.get();
            blog.setTitle(blogDetails.getTitle());
            blog.setShortDescription(blogDetails.getShortDescription());
            blog.setFullDesc(blogDetails.getFullDesc());
            blog.setBlogImage(blogDetails.getBlogImage());
            blog.setCategory(blogDetails.getCategory());
            blog.setCreatedBy(blogDetails.getCreatedBy());
            return blogRepository.save(blog);
        }
        return null;
    }

    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}