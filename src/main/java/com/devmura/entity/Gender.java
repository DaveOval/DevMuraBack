package com.devmura.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id", nullable = false)
    private Integer id;

<<<<<<< HEAD
    @Column(name = "gender_name", length = 25, unique = true)
=======
    @Column(name = "gender_name", nullable = false, length = 25, unique = true)
>>>>>>> e0637010370540c35e60b57348e35a3d7f65fa08
    private String genderName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Gender gender = (Gender) o;
        return id != null && Objects.equals(id, gender.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
