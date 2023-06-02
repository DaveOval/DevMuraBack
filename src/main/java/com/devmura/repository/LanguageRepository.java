package com.devmura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmura.entity.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
   
} 
