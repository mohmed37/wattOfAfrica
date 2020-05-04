package com.client.bean.commerciale;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialeResultBean {
    int id;
    Integer client;
    Integer question;
    Double approche;
    Double combativite;
    Double prospection;
    Double reseau;
    Double satisfaction;
    Double strategiques;
    Double argumentations;
    Double comprehension;
    Double affirmation;
    Double controle;
    Double jeu;
}
