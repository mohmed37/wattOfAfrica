package com.tests.entity.ndream;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "ficheMetier")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class FicheMetier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "metier")
    String metier;
    @Column(name = "photo")
    String photo;
    @Column(name = "texte")
    String texte;
    @Column(name = "competence")
    String competence;
    @Column(name = "qualite")
    String qualite;
    @Column(name = "code")
    String code;

}
