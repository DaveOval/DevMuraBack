package com.devmura.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.devmura.entity.LanguageProfile} entity
 */
@Data
public class LanguageProfileDto implements Serializable {
    private Integer userId;
    private String language;
}