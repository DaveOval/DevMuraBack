package com.devmura.entity;

import com.devmura.model.LanguajeProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer id;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "bio")
    private String bio;

    @Column(name = "img_user")
    private String img;

    @Column(name = "github_username")
    private String github;

    @Column(name = "linkedin_username")
    private String likedin;

    @Column(name = "background_user")
    private String background;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

//    @OneToMany(mappedBy = "profile")
//    List<LanguajeProfile> languajeProfile = new ArrayList<>();


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
