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
    @Column(name = "authenticite")
    Integer authenticite;
    @Column(name = "tenacite")
    Integer tenacite;
    @Column(name = "reactivite")
    Integer reactivite;
    @Column(name = "introversion")
    Integer introversion;
    @Column(name = "methode")
    Integer methode;
    @Column(name = "intuition")
    Integer intuition;
    @Column(name = "nonConformisme")
    Integer nonConformisme;
    @Column(name = "personnelle")
    Integer personnelle;
    @Column(name = "directive")
    Integer directive;
    @Column(name = "prudence")
    Integer prudence;
    @Column(name = "gregarite")
    Integer gregarite;
    @Column(name = "individualisme")
    Integer individualisme;
    @Column(name = "traditionnel")
    Integer traditionnel;
    @Column(name = "reflexion")
    Integer reflexion;


}
