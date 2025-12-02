package com.blog.app.repository;

import com.blog.app.model.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BlogRepository {
    private final Map<Long, Blog> blogs = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Blog> findAll() {
        return new ArrayList<>(blogs.values());
    }

    public Optional<Blog> findById(Long id) {
        return Optional.ofNullable(blogs.get(id));
    }

    public Blog save(Blog blog) {
        if (blog.getId() == null) {
            blog.setId(idGenerator.getAndIncrement());
            blog.setCreatedDate(LocalDateTime.now());
        }
        blog.setModifyDate(LocalDateTime.now());
        blogs.put(blog.getId(), blog);
        return blog;
    }

    public void deleteById(Long id) {
        blogs.remove(id);
    }

    public boolean existsById(Long id) {
        return blogs.containsKey(id);
    }
}