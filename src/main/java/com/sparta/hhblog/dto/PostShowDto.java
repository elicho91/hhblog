package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostShowDto {

    private String username;
    private String subject;
    private String contents;
    private LocalDateTime createdAt;


    public PostShowDto(Blog blog) {
        this.username = blog.getUsername();
        this.createdAt = blog.getCreatedAt();
        this.subject = blog.getSubject();
        this.contents = blog.getContents();
    }


}