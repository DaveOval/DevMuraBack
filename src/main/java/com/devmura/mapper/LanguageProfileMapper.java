package com.devmura.mapper;

import com.devmura.dto.LanguageProfileDto;
import com.devmura.entity.Language;
import com.devmura.entity.LanguageProfile;
import com.devmura.entity.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public abstract class LanguageProfileMapper {
    public static List<LanguageProfileDto> mapToLanguageProfileDtoList(Set<LanguageProfile> languageProfiles) {
        List<LanguageProfileDto> languageProfileDtos = new ArrayList<>();
        for (LanguageProfile languageProfile : languageProfiles) {
            LanguageProfileDto languageProfileDto = new LanguageProfileDto();
            languageProfileDto.setUserId(languageProfile.getProfile().getId());
            languageProfileDto.setLanguage(languageProfile.getLanguage().getLanguageName());
            languageProfileDtos.add(languageProfileDto);
        }
        return languageProfileDtos;
    }
}
