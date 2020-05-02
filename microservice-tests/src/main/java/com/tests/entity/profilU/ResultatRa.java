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
@Table(name = "resultatRa")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class ResultatRa implements Serializable {

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
    @Column(name = "authenticite")
    Double authenticite=0.0;
    @Column(name = "tenacite")
    Double tenacite=0.0;
    @Column(name = "introversion")
    Double introversion=0.0;
    @Column(name = "methode")
    Double methode=0.0;
    @Column(name = "intuition")
    Double intuition=0.0;
    @Column(name = "nonConformisme")
    Double nonConformisme=0.0;
    @Column(name = "personnelle")
    Double personnelle=0.0;
    @Column(name = "reflexion")
    Double reflexion=0.0;
    @Column(name = "directive")
    Double directive=0.0;
    @Column(name = "prudence")
    Double prudence=0.0;
    @Column(name = "gregarite")
    Double gregarite=0.0;
    @Column(name = "individualisme")
    Double individualisme=0.0;
    @Column(name = "traditionnel")
    Double traditionnel=0.0;
    @Column(name = "reactivite")
    Double reactivite=0.0;


}
