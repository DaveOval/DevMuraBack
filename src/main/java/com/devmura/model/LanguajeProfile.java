package com.devmura.model;


import com.devmura.entity.Language;
import com.devmura.entity.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LanguajeProfile {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    Profile profile;
}
