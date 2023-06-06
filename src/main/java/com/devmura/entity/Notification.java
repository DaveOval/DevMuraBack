package com.devmura.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer id ;

    @Column(name = "is_readed")
    private boolean isReaded;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "receptor_id")
    private Integer receptorId;

    @Column(name = "sender_id")
    private Integer senderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notification notification = (Notification) o;
        return id != null && Objects.equals(id, notification.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
