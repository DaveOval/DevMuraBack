package com.devmura.mapper;

import com.devmura.dto.HeartDto;
import com.devmura.entity.Heart;

public abstract class HeartMapper {

    public static HeartDto mapToHeartDto(Heart heart) {
        HeartDto heartDto = new HeartDto();
        heartDto.setId(heart.getId());
        heartDto.setUserName(heart.getUser().getName());
        heartDto.setUserLastName(heart.getUser().getLastName());
        heartDto.setUserImg(heart.getUser().getProfile().getImg());
        heartDto.setUserId(heart.getUser().getId());
        heartDto.setStatus(heart.getStatus());
        return heartDto;
    }
}