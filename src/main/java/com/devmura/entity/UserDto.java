package com.devmura.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String name;
    private final String lastName;
    private final Integer age;
}