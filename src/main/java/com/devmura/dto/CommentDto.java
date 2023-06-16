package com.devmura.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Integer id;
    private String content;
    private String name;
    private String lastName;
    private String username;
    private String img;
}
