package com.devmura.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.*;

@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name= "language_id", nullable = false)
    private Integer id;

    @Column(name="language_name", nullable = false, length =100, unique = true)
    private String languageName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LanguageProfile> languageProfiles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Language language = (Language) o;
        return id != null && Objects.equals(id, language.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}