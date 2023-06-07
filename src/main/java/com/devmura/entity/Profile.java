package com.devmura.entity;

import com.devmura.model.LanguajeProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


//    @OneToMany(mappedBy = "profile")
//    List<LanguajeProfile> languajeProfile = new ArrayList<>();


    public Profile() {
    }

    public Profile(Integer id, Date birthday, String bio, String img, String github, String likedin, String background, Level level, User user) {
        this.id = id;
        this.birthday = birthday;
        this.bio = bio;
        this.img = img;
        this.github = github;
        this.likedin = likedin;
        this.background = background;
        this.level = level;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLikedin() {
        return likedin;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
