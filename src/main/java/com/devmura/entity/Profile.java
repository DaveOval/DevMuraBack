package com.devmura.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer id;

    @Column(name = "birthday", nullable = true, length = 100)
    private Date birthday;

    @Column(name = "bio", nullable = true, length = 100)
    private String bio;

    @Column(name = "img_user", nullable = true, length = 250)
    private String img;

    @Column(name = "github_username", nullable = true, length = 150)
    private String github;

    @Column(name = "linkedin_username", nullable = true, length = 150)
    private String likedin;

    @Column(name = "background_user",nullable = true, length = 150)
    private String background;

    @Column(name = "role", nullable = true, length = 50)
    private String role;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", fetch = FetchType.EAGER)
    private List<LanguageProfile> languageProfiles = new ArrayList<>();


    public void setLikedin(String likedin) {
        this.likedin = likedin;
    }



    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", bio='" + bio + '\'' +
                ", img='" + img + '\'' +
                ", github='" + github + '\'' +
                ", likedin='" + likedin + '\'' +
                ", background='" + background + '\'' +
                ", level=" + level +
                '}';
    }
}
