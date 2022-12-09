package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;
import lombok.Getter;

@Getter
public class PostEditDto {
    private String username;
    private String subject;
    private String contents;



    public PostEditDto(Blog blog) {

        this.username = blog.getUsername();
        this.subject = blog.getSubject();
        this.contents = blog.getContents();
    }

}