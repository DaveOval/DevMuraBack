package com.devmura.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auths")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id", nullable = false)
    private Integer id ;

    @Column(name = "auth_name", nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auth", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Auth auth = (Auth) o;
        return id != null && Objects.equals(id, auth.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}