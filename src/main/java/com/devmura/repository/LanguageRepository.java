package com.devmura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmura.entity.Language;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
   
} 
