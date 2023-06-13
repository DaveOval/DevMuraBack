package com.devmura.dto;

import com.devmura.entity.Profile;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link Profile} entity
 */
@Data
public class ProfileDto {
    private Integer id;
    private Date birthday;
    private Integer age;
    private String bio;
    private String img;
    private String github;
    private String likedin;
    private String createdAt;
    private String background;
    private String role;
    private String name;
    private String lastName;
    private String country;
    private String username;
    private String countryName;
    private List<PostDto> posts;
    private List<String> languages;
}