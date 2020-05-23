package com.tests.entity.ndream;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "autoportraitResult")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class AutoportraitResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "client")
    Integer client;
    @Column(name = "qualite1")
    String qualite1;
    @Column(name = "qualite2")
    String qualite2;
    @Column(name = "qualite3")
    String qualite3;
    @Column(name = "qualite4")
    String qualite4;
    @Column(name = "qualite5")
    String qualite5;
    @Column(name = "qualite6")
    String qualite6;
    @Column(name = "defaut1")
    String defaut1;
    @Column(name = "defaut2")
    String defaut2;
    @Column(name = "defaut3")
    String defaut3;
    @Column(name = "defaut4")
    String defaut4;
    @Column(name = "defaut5")
    String defaut5;
    @Column(name = "defaut6")
    String defaut6;
    @Column(name = "reflexion")
    String reflexion;
    @Column(name = "auto2")
    Boolean auto2;
    @Column(name = "auto1")
    Boolean auto1;

}
