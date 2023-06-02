package com.devmura.entity;

import com.devmura.model.GroupPost;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private String created;

    @Column(name ="description_group")
    private String description;

    @Column(name="user_id")
    private Integer userId;

    @OneToMany(mappedBy = "group")
    List<GroupPost> groupPosts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Group group = (Group) o;
        return id != null && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}