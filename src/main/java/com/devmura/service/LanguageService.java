package com.devmura.service;

import com.devmura.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    void save(Language language);
    void delete(Integer id);
    Optional<Language> findById(Integer id);
    List<Language> getAll();
}
