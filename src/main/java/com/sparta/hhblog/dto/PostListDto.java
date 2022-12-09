package com.sparta.hhblog.dto;

import com.sparta.hhblog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostListDto {

    private String username;
    private String subject;
    private String contents;
    private LocalDateTime createdAt;



    public PostListDto(Blog blog) {
        this.username = blog.getUsername();
        this.subject = blog.getSubject();
        this.contents = blog.getContents();
        this.createdAt = blog.getCreatedAt();
    }



}