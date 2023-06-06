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
@Table(name = "friends")
public class Friend {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "friend_id")
  private Integer id;

  @Column(name="accepted")
  private Boolean accepted;
  
  @OneToOne
  @JoinColumn(name="user_id")
  private User user;

  @OneToOne
  @JoinColumn(name="user_id")
  private User friendUser;


 
}