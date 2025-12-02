package com.blog.app.model;

import java.time.LocalDateTime;

public class Blog {
    private Long id;
    private String title;
    private String shortDescription;
    private String fullDesc;
    private String blogImage;
    private String category;
    private LocalDateTime createdDate;
    private LocalDateTime modifyDate;
    private String createdBy;

    public Blog() {}

    public Blog(Long id, String title, String shortDescription, String fullDesc, 
                String blogImage, String category, String createdBy) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDesc = fullDesc;
        this.blogImage = blogImage;
        this.category = category;
        this.createdBy = createdBy;
        this.createdDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getFullDesc() { return fullDesc; }
    public void setFullDesc(String fullDesc) { this.fullDesc = fullDesc; }

    public String getBlogImage() { return blogImage; }
    public void setBlogImage(String blogImage) { this.blogImage = blogImage; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getModifyDate() { return modifyDate; }
    public void setModifyDate(LocalDateTime modifyDate) { this.modifyDate = modifyDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}