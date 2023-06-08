package com.devmura.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;


@Data
@Entity
// @ Data soluciona para no escribir todos los demás
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name",nullable = false, length = 30)
    private String name;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "age", nullable = false, length = 30)
    private Integer age;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "created_at", nullable = false, length = 150)
    private LocalDateTime createdAt;

    @Column(name = "password",nullable = false, length = 20)
    private String password;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now().withNano(0);
    }

    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Auth auth;

    // revisar relacion many to one
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Post> posts = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    public void setProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
