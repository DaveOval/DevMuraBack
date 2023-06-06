package com.devmura.service.impl;

import com.devmura.entity.Language;
import com.devmura.repository.LanguageRepository;
import com.devmura.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public void save(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Optional<Language> findById(Integer id) {
        return languageRepository.findById(id);
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
}
