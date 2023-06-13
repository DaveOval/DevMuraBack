package com.devmura.mapper;

import com.devmura.dto.PostDto;
import com.devmura.dto.ProfileDto;
import com.devmura.entity.LanguageProfile;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.entity.UserRole;
import com.devmura.repository.UserRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.devmura.mapper.PostMapper.mapToPostDto;

@Data
public abstract class ProfileMapper {

    public static ProfileDto mapToProfileDto(Profile profile, UserRepository userRepository) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setBirthday(profile.getBirthday());
        profileDto.setAge(profile.getUser().getAge());
        profileDto.setBio(profile.getBio());
        profileDto.setImg(profile.getImg());
        profileDto.setGithub(profile.getGithub());
        profileDto.setLikedin(profile.getLikedin());
        profileDto.setBackground(profile.getBackground());
        profileDto.setRole(profile.getRole());
        profileDto.setName(profile.getUser().getName());
        profileDto.setLastName(profile.getUser().getLastName());
        profileDto.setCountry(profile.getUser().getCountry().getCode());
        profileDto.setCountryName(profile.getUser().getCountry().getName());
        profileDto.setUsername(profile.getUser().getUsername());
        profileDto.setCreatedAt(profile.getUser().getCreatedAt().toString());

        List<String> languageNames = new ArrayList<>();
        for (LanguageProfile languageProfile : profile.getLanguageProfiles()) {
            languageNames.add(languageProfile.getLanguage().getLanguageName());
        }
        profileDto.setLanguageProfiles(languageNames);
        List<String> roleNames = new ArrayList<>();
        for (UserRole userRole : profile.getUser().getUserRoles()) {
            roleNames.add(userRole.getAuth().getName());
        }
        profileDto.setUserRoles(roleNames);



        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : profile.getUser().getPosts()) {
            postDtos.add(mapToPostDto(post, userRepository));
        }
        profileDto.setPosts(postDtos);


        return profileDto;
    }
}