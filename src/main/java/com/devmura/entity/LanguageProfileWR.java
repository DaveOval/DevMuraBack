package com.devmura.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "language_profile")
public class LanguageProfileWR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_language_id")
    private Integer id;

    @Column(name = "profile_id")
    private Integer idProfile;

    @Column(name = "language_id")
    private  Integer idLanguage;
}
