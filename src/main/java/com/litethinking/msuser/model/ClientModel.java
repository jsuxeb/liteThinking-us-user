package com.litethinking.msuser.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class ClientModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3)
    private String documentType;
    @Column(length = 8)
    private Integer numberDocument;
    @Column(length = 100)
    private String firstName;
    @Column(length = 100)
    private String secondName;
    @Column(length = 12)
    private String numberPhone;
    @Column(length = 160)
    private String address;
    @Column(length = 60)
    private String city;



}
