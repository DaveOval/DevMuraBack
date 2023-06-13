package com.devmura.dto;

import com.devmura.entity.Country;
import com.devmura.entity.Post;
import com.devmura.entity.UserRole;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Component
public class UserDto {
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
    private List<PostDto> posts;
    private List<String> languageProfiles = new ArrayList<>();
    private List<String> userRoles = new ArrayList<>();
}
