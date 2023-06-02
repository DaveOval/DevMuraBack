package com.devmura.entity;

import com.devmura.model.GroupPost;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "languages")
public class Language {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name= "language_id")
    private Integer id;

    @Column(name="language_name")
    private String languageName;

    @OneToMany(mappedBy = "post")
    List<GroupPost> groupPosts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Language language = (Language) o;
        return id != null && Objects.equals(id, language.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}