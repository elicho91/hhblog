package com.sparta.hhblog.service;

import com.sparta.hhblog.dto.PostCreateDto;
import com.sparta.hhblog.dto.PostEditDto;
import com.sparta.hhblog.dto.PostListDto;
import com.sparta.hhblog.dto.PostShowDto;
import com.sparta.hhblog.entity.Blog;
import com.sparta.hhblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;


    @Transactional
    public List<PostListDto> getPost() {

        List<Blog> blog = blogRepository.findAll();
        List<PostListDto> allPosts = new ArrayList<>();

        for (Blog blogs : blog) {

            PostListDto postListDTO = new PostListDto(blogs);
            allPosts.add(postListDTO);
        }

        return allPosts;
    }

    @Transactional
    public PostCreateDto createPost(String username, String pw, String subject, String contents) {
        Blog blog = new Blog(username, pw, subject, contents);
        blogRepository.save(blog);

        PostCreateDto postCreateDto = new PostCreateDto(blog);
        return postCreateDto;
    }

    @Transactional
    public PostShowDto showPost(Long id) {


        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        PostShowDto postShowDto = new PostShowDto(blog);

        return postShowDto;
    }

    @Transactional
    public PostEditDto editPost(Long id, String subject, String contents, String pw) {

        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );


        if (blog.getPw().equals(pw)) {

            blog.edit(subject, contents);
            PostEditDto postEditDto = new PostEditDto(blog);
            return postEditDto;
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");

        }


    }

    @Transactional
    public String deletePost(Long id, String pw) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (blog.getPw().equals(pw)) {

            blogRepository.deleteById(id);
            return "정상적으로 삭제되었습니다.";
        }

        return "비밀번호가 일치하지 않습니다.";

    }
}