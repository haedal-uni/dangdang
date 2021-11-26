package com.sparta.dangdang.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = true)
    private String user_id;
    @Column(nullable = true)
    private String update_date;
    @Column(nullable = true)
    private String main_image_path;
    @Column(nullable = false)
    private String content;

    public Post(String user_id, String update_date, String main_image_path, String content) {
        this.user_id = user_id;
        this.update_date = update_date;
        this.main_image_path = main_image_path;
        this.content = content;
    }
}
