package com.devmura.model;


import com.devmura.entity.Group;
import com.devmura.entity.Post;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class GroupPost {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "post_id")
    Post post;

    @ManyToOne
    @JoinColumn (name = "group_id")
    Group group;
}
