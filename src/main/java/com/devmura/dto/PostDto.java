package com.devmura.dto;


import com.devmura.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

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
}
