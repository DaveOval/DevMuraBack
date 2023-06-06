package com.devmura.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devmura.groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer id ;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private String created;

    @Column(name ="description_group")
    private String description;

    @Column(name="user_id")
    private Integer userId;

//    @ManyToMany
//    @JoinTable(
//        name = "group_post",
//        joinColumns = @JoinColumn(name = "group_id"),
//        inverseJoinColumns = @JoinColumn(name = "post_id"))
//    private Set<Post> posts;
}
