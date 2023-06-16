package com.devmura.repository;

import com.devmura.entity.LanguageProfileWR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageProfileRepository extends JpaRepository<LanguageProfileWR,Integer> {

}
