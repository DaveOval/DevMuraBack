package com.devmura.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "hearts")
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
