package com.devmura.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GroupDto {
    private Integer id;
    private String title;
    private String description;
    private Integer userId;
    private List<PostDto> posts = new ArrayList<>();
}
