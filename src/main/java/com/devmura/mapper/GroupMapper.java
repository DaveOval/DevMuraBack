package com.devmura.mapper;

import com.devmura.dto.GroupDto;
import com.devmura.dto.PostDto;
import com.devmura.entity.Group;
import com.devmura.entity.Post;
import com.devmura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.devmura.mapper.PostMapper.mapToPostDto;

public abstract class GroupMapper {

    public static GroupDto mapToGroupDto(Group group, UserRepository userRepository) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setTitle(group.getTitle());
        groupDto.setDescription(group.getDescription());
        groupDto.setUserId(group.getUser().getId());

        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : group.getPosts()) {
            postDtos.add(mapToPostDto(post,userRepository));
        }
        groupDto.setPosts(postDtos);
        return groupDto;
    }
}
