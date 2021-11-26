package com.sparta.dangdang.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = true)
    private String user_id;
    @Column(nullable = true)
    private String user_profile_img;

    @OneToMany(mappedBy = "writer")
    private List<Post> written_posts = new ArrayList<>();

    public User(String user_id) {
        this.user_id = user_id;
    }

    public User(String user_id, String user_profile_img) {
        this.user_id = user_id;
        this.user_profile_img = user_profile_img;
    }

    public void addWritePost(Post post) {
        this.written_posts.add(post);

        if(post.getWriter() != this) {
            post.setWriter(this);
        }
    }
}
