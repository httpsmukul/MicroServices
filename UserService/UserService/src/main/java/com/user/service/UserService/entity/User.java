package com.user.service.UserService.entity;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME",length = 20)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String  about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();



}
