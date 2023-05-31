package com.devmura.entity; 
 import jakarta.persistence.*; 
  
   @Entity 

   @Table(name = "auths") 
   public class Auth {
     @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY) 
      @Column(name = "auth_id") 
      private Integer id ; 
   }