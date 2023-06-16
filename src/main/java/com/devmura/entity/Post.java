package com.devmura.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
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
    @Column(name = "post_id", nullable = false)
    private Integer id;

    @Column(name = "post_body",nullable = false, length = 250)
    private String postBody;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

<<<<<<< HEAD
    @Column (name = "img_source", length = 300)
=======
    @Column (name = "img_source", nullable = false, length = 300)
>>>>>>> e0637010370540c35e60b57348e35a3d7f65fa08
    private String imgSource;

    @Column(name = "counter", nullable = false)
    private Integer counter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
    private List<Heart> hearts = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now().withNano(0);
    }

//    @OneToMany(mappedBy = "post")
//    List<GroupPost> groupPosts = new ArrayList<>();


    public String getCreatedAt() {
        return createdAt.toString();
    }

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
