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
  @Column(name = "friend_id")
  private Integer id;

  @Column(name="accepted", length = 50)
  private Boolean accepted;

  @OneToOne
  @JoinColumn(name="receiver_id")
  private User user;

  @OneToOne
  @JoinColumn(name="sender_id")
  private User friendUser;


 
}