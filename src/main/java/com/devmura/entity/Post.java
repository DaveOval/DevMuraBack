package com.devmura.entity;

import com.devmura.model.GroupPost;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "post_body",nullable = false, length = 250)
    private String postBody;

    @Column(name = "created_at", nullable = false, length = 250)
    private Date createdAt;

    @Column (name = "img_source", nullable = false, length = 250)
    private String imgSource;

    @Column(name = "counter", nullable = false, length = 250)
    private String counter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

//    @OneToMany(mappedBy = "post")
//    List<GroupPost> groupPosts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
