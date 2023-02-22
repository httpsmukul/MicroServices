package com.hotels.service.HotelsService.entites;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Location")
    private String location;
    @Column(name = "ABOUT")
    private String about;
}
