package com.devmura.dto;


import com.devmura.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PostDto {
    private Integer id;
    private String postBody;
    private String createdAt;
    private String imgSource;
    private String counter;
    private String name;
    private String lastName;
    private String username;
    private String role;
    private String img;
    private Integer userId;
    private Set<HeartDto> hearts = new HashSet<>();
}
