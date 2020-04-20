package com.tests.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resultat")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Resultat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "idclient")
    Integer idclient;
    @Column(name = "question")
    Integer question;
    @Column(name = "authenticite")
    Double authenticite;
    @Column(name = "tenacite")
    Double tenacite;
    @Column(name = "reactivite")
    Double reactivite;
    @Column(name = "introversion")
    Double introversion;
    @Column(name = "methode")
    Double methode;
    @Column(name = "intuition")
    Double intuition;
    @Column(name = "nonConformisme")
    Double nonConformisme;
    @Column(name = "equilibre")
    Double equilibre;
    @Column(name = "directive")
    Double directive;
    @Column(name = "prudence")
    Double prudence;
    @Column(name = "gregarite")
    Double gregarite;
    @Column(name = "individualisme")
    Double individualisme;
    @Column(name = "traditionnel")
    Double traditionnel;

}
