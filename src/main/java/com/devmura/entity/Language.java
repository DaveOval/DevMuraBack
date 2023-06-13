package com.devmura.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name= "language_id")
    private Integer id;

    @Column(name="language_name", nullable = false, length =50)
    private String languageName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language", fetch = FetchType.LAZY)
    private Set<LanguageProfile> languageProfiles = new HashSet<>();

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