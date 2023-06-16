package com.devmura.entity;


import jakarta.persistence.*;

import lombok.*;


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
  @Column(name = "friend_id", nullable = false)
  private Integer id;

  @Column(name="accepted", nullable = false)
  private Boolean accepted;

  @OneToOne
  @JoinColumn(name="receiver_id", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name="sender_id", nullable = false)
  private User friendUser;
 
}