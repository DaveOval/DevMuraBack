package com.devmura.service;

import com.devmura.entity.Auth;

import java.util.List;
import java.util.Optional;


public interface AuthService extends CRUDService<Auth>{
    Optional<Auth> findAuthById(Integer id);
}
