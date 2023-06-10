package com.devmura.dto;

import com.devmura.entity.Country;
import com.devmura.entity.Post;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class UserDto {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private String username;
    private LocalDateTime createdAt;
    private List<Post> posts = new ArrayList<>();
    private Country country;
}
