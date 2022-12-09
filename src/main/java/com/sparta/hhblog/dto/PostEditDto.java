package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;
import lombok.Getter;

@Getter
public class PostEditDto {
    private String subject;
    private String username;
    private String contents;



    public PostEditDto(Blog blog) {
        this.subject = blog.getSubject();
        this.username = blog.getUsername();
        this.contents = blog.getContents();
    }

}