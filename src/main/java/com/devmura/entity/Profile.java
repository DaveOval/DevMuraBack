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
    @Column(name = "profile_id", nullable = false)
    private Integer id;

    @Column(name = "birthday", nullable = true)
    private Date birthday;

    @Column(name = "bio", length = 250)
    private String bio;

    @Column(name = "img_user", length = 300)
    private String img;

    @Column(name = "github_username", length = 50)
    private String github;

    @Column(name = "linkedin_username", length = 100)
    private String likedin;

    @Column(name = "background_user", length = 300)
    private String background;

    @Column(name = "role", length = 100)
    private String role;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
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
