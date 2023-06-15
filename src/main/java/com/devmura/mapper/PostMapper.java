package com.devmura.mapper;

import com.devmura.dto.HeartDto;
import com.devmura.dto.PostDto;
import com.devmura.entity.Heart;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public abstract class PostMapper {

    public static PostDto mapToPostDto(Post post, UserRepository userRepository) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setPostBody(post.getPostBody());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setImgSource(post.getImgSource());
        postDto.setCounter(post.getCounter());
        postDto.setUserId(post.getUser().getId());

        Optional<User> user = userRepository.findById(post.getUser().getId());

        if (user.isPresent()) {
            postDto.setName(user.get().getName());
            postDto.setLastName(user.get().getLastName());
            postDto.setUsername(user.get().getUsername());

            Profile profile = user.get().getProfile();
            if (profile != null) {
                postDto.setRole(profile.getRole());
                postDto.setImg(profile.getImg());
            }
        }

        Set<HeartDto> heartDtos = new HashSet<>();
        for (Heart heart : post.getHearts()) {
            HeartDto heartDto = HeartMapper.mapToHeartDto(heart);
            heartDtos.add(heartDto);
        }
        postDto.setHearts(heartDtos);

        return postDto;
    }

}
