package com.sparta.hhblog.controller;

import com.sparta.hhblog.dto.PostCreateDto;
import com.sparta.hhblog.dto.PostEditDto;
import com.sparta.hhblog.dto.PostListDto;
import com.sparta.hhblog.dto.PostShowDto;
import com.sparta.hhblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BlogController {


    private final BlogService blogService;


    @GetMapping("/api/showAllPost")
    public List<PostListDto> getPost(){
        return blogService.getPost();
    }


    @PostMapping("/api/createPost/{username}/{pw}/{subject}/{contents}")
    public PostCreateDto createPost(@PathVariable String username, @PathVariable String pw, @PathVariable String subject, @PathVariable String contents){
        return blogService.createPost(username,pw,subject,contents);
    }

    @GetMapping("/api/showPost/{id}")
    public PostShowDto viewPost(@PathVariable Long id){
        return blogService.showPost(id);
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











//테스트코드
//1.사용자 생성 세명 POST
//http://localhost:8080/api/addPost/himans/song/1234/goodman
//http://localhost:8080/api/addPost/higirl/kim/5678/goodgirl
//http://localhost:8080/api/addPost/안녕하세요/park/9999/반가워요

//2.전체 글 검색 GET
//http://localhost:8080/api/allList


//3.특정 글 검색 GET
//http://localhost:8080/api/viewPost/2


//4.글수정 실패  PUT
//http://localhost:8080/api/editPost/1/수정된글/12345

//5.글수정 성공 PUT
//http://localhost:8080/api/editPost/1/수정된글/1234

//6.글삭제 실패 DELETE
//http://localhost:8080/api/deletePost/1/12345

//7.글삭제 성공 DELETE
//http://localhost:8080/api/deletePost/1/1234