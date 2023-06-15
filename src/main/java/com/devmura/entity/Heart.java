package com.devmura.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "hearts")
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Integer id;

    @Column(name = "created_at", nullable = false, length = 150)
    private LocalDateTime createdAt;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now().withNano(0);


    }


}
