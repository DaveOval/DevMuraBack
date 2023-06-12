package com.devmura.mapper;

import com.devmura.dto.PostDto;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class PostMapper {

    public static PostDto mapToPostDto(Post post, UserRepository userRepository) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setPostBody(post.getPostBody());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setImgSource(post.getImgSource());
        postDto.setCounter(post.getCounter());

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

        return postDto;
    }

}
