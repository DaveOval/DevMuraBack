package com.devmura.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "friend_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "friend_user_id")
  private User friendUser;

}
