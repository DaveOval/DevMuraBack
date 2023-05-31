package com.devmura.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "countries")
public class Countries {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "country_name")
    private String name;
}
