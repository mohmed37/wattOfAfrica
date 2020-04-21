package com.tests.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resultatRb")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class ResultatRb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "idclient")
    Integer idclient;
    @Column(name = "question")
    Integer question;
    @Column(name = "note")
    Integer note;
    @Column(name = "action")
    Double action;
    @Column(name = "altruisme")
    Double altruisme;
    @Column(name = "flexibilite")
    Double flexibilite;
    @Column(name = "competition")
    Double competition;
    @Column(name = "strategie")
    Double strategie;
    @Column(name = "improvisation")
    Double improvisation;
    @Column(name = "rationalisme")
    Double rationalisme;
    @Column(name = "droiture")
    Double droiture;
    @Column(name = "autonomie")
    Double autonomie;
    @Column(name = "exploration")
    Double exploration;
    @Column(name = "pouvoir")
    Double Pouvoir;
    @Column(name = "professionnelle")
    Double professionnelle;
    @Column(name = "extraversion")
    Double extraversion;
    @Column(name = "stabilite")
    Double stabilite;

}
