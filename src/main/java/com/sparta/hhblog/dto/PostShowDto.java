package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostShowDto {

    private String subject;
    private String username;
    private LocalDateTime createdAt;
    private String contents;


    public PostShowDto(Blog blog) {
        this.subject = blog.getSubject();
        this.username = blog.getUsername();
        this.createdAt = blog.getCreatedAt();
        this.contents = blog.getContents();
    }


}