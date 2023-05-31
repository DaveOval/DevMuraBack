package com.devmura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Languages {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name= "language_id")
    private Integer id;

    @Column(name="language_name")
    private String language_name;

   
}