package com.sparta.hhblog.entity;

import com.sparta.hhblog.dto.PostCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String contents;

    public Blog(String username, String pw, String subject, String contents) {
        this.username = username;
        this.pw = pw;
        this.subject = subject;
        this.contents = contents;
    }

//    public Blog(PostCreateDto postCreateDto) {
//        this.username = username;
//        this.pw = pw;
//        this.subject = subject;
//        this.contents = contents;
//    }

    public void edit(String subject, String contents) {

        this.subject = subject;
        this.contents = contents;
    }
}