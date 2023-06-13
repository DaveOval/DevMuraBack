package com.devmura.mapper;

import com.devmura.dto.LanguageProfileDto;
import com.devmura.dto.PostDto;
import com.devmura.dto.ProfileDto;
import com.devmura.entity.LanguageProfile;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.repository.UserRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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

        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : profile.getUser().getPosts()) {
            postDtos.add(mapToPostDto(post, userRepository));
        }
        profileDto.setPosts(postDtos);

        List<String> languages = new ArrayList<>();
        for (LanguageProfile languageProfile : profile.getLanguageProfiles()) {
            languages.add(languageProfile.getLanguage().getLanguageName());
        }
        profileDto.setLanguages(languages);

        return profileDto;
    }
}