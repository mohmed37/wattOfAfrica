package com.tests.entity.ndream;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "heroResult")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
public class HeroResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "client")
    Integer client;
    @Column(name = "valeur1")
    String valeur1;
    @Column(name = "valeur2")
    String valeur2;
    @Column(name = "valeur3")
    String valeur3;
    @Column(name = "hero")
    String hero;
    @Column(name = "choixHero")
    Boolean choixHero;

}
