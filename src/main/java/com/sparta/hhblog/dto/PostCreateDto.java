package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;

public class PostCreateDto {

    private String contents;

    public PostCreateDto(Blog blog) {
        this.contents = blog.getContents();
    }
}