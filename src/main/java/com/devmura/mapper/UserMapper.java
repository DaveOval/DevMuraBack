package com.devmura.mapper;

import com.devmura.dto.UserDto;
import com.devmura.entity.User;
import com.devmura.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setPosts(user.getPosts());
        userDto.setCountry(user.getCountry());
        List<String> roleNames = new ArrayList<>();
        for (UserRole userRole : user.getUserRoles()) {
            roleNames.add(userRole.getAuth().getName());
        }
        userDto.setUserRoles(roleNames);

        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setCreatedAt(userDto.getCreatedAt());
        return user;
    }
}
