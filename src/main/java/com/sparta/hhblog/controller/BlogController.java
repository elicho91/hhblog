package com.sparta.hhblog.controller;

import com.sparta.hhblog.dto.PostCreateDto;
import com.sparta.hhblog.dto.PostEditDto;
import com.sparta.hhblog.dto.PostListDto;
import com.sparta.hhblog.dto.PostShowDto;
import com.sparta.hhblog.entity.Blog;
import com.sparta.hhblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


//    @PostMapping("/api/blogs")
//    public Blog createPost(@RequestBody PostCreateDto postCreateDto){
//        return blogService.createPost(postCreateDto);
//    }
    // RequestBody를 사용해서 postman으로 값을 넘기는게 어렵습니다 ㅠㅠ

    @PostMapping("/api/createPost/{username}/{pw}/{subject}/{contents}")
    public PostCreateDto createPost(@PathVariable String username, @PathVariable String pw, @PathVariable String subject, @PathVariable String contents){
        return blogService.createPost(username,pw,subject,contents);
    }

    @GetMapping("/api/showPost/{id}")
    public PostShowDto showPost(@PathVariable Long id){
        return blogService.showPost(id);
    }

    @GetMapping("/api/showAllPost")
    public List<PostListDto> getPosts(){
        return blogService.getPosts();
    }


    @PutMapping("/api/editPost/{id}/{pw}/{subject}/{contents}")
    public PostEditDto editPost(@PathVariable Long id, @PathVariable String pw, @PathVariable String subject, @PathVariable String contents){

        return blogService.editPost(id, pw, subject, contents);
    }

    @DeleteMapping("/api/deletePost/{id}/{pw}")
    public String deletePost(@PathVariable Long id,@PathVariable String pw){
        return blogService.deletePost(id,pw);
    }






}











