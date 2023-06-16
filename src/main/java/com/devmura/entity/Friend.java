package com.devmura.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

  @Column(name="accepted", nullable = false, length = 50)
  private Integer accepted;

  @Column(name="is_activated", nullable = false, length = 50)
  private Integer isActivated;

  @OneToOne
  @JoinColumn(name="receiver_id")
  @JsonIgnore
  private User user;

  @OneToOne
  @JoinColumn(name="sender_id")
  @JsonIgnore
  private User friendUser;


 
}