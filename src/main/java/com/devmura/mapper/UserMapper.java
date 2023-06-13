package com.devmura.mapper;

import com.devmura.dto.PostDto;
import com.devmura.dto.UserDto;
import com.devmura.dto.UserDto;
import com.devmura.entity.LanguageProfile;
import com.devmura.entity.Post;
import com.devmura.entity.User;
import com.devmura.entity.UserRole;
import com.devmura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.devmura.mapper.PostMapper.mapToPostDto;


public abstract class UserMapper {



    public static UserDto mapToUserDto(User user, UserRepository userRepository) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setBirthday(user.getProfile().getBirthday());
        userDto.setAge(user.getAge());
        userDto.setBio(user.getProfile().getBio());
        userDto.setImg(user.getProfile().getImg());
        userDto.setGithub(user.getProfile().getGithub());
        userDto.setLikedin(user.getProfile().getLikedin());
        userDto.setBackground(user.getProfile().getBackground());
        userDto.setRole(user.getProfile().getRole());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setCountry(user.getCountry().getCode());
        userDto.setUsername(user.getUsername());
        userDto.setCreatedAt(user.getCreatedAt().toString());

        Set<String> languageNames = new HashSet<>();
        for (LanguageProfile languageProfile : user.getProfile().getLanguageProfiles()) {
            languageNames.add(languageProfile.getLanguage().getLanguageName());
        }
        userDto.setLanguageProfiles(new ArrayList<>(languageNames));

        List<String> roleNames = new ArrayList<>();
        for (UserRole userRole : user.getUserRoles()) {
            roleNames.add(userRole.getAuth().getName());
        }
        userDto.setUserRoles(roleNames);



        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : user.getPosts()) {
            postDtos.add(mapToPostDto(post, userRepository));
        }
        userDto.setPosts(postDtos);

        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        return user;
    }
}
