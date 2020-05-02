package com.tests.entity.profilU;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    Integer question=1;
    @Column(name = "note")
    @NotNull
    Integer note=0;
    @Column(name = "strategie")
    Double strategie=0.0;
    @Column(name = "flexibilite")
    Double flexibilite=0.0;
    @Column(name = "stabilite")
    Double stabilite=0.0;
    @Column(name = "extraversion")
    Double extraversion=0.0;
    @Column(name = "improvisation")
    Double improvisation=0.0;
    @Column(name = "rationalisme")
    Double rationalisme=0.0;
    @Column(name = "droiture")
    Double droiture=0.0;
    @Column(name = "professionnelle")
    Double professionnelle=0.0;
    @Column(name = "pouvoir")
    Double Pouvoir=0.0;
    @Column(name = "action")
    Double action=0.0;
    @Column(name = "competition")
    Double competition=0.0;
    @Column(name = "autonomie")
    Double autonomie=0.0;
    @Column(name = "altruisme")
    Double altruisme=0.0;
    @Column(name = "exploration")
    Double exploration=0.0;















}
