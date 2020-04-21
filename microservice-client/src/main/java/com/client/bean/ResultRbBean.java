package com.client.bean;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ResultRbBean {
    int id;
    Integer idclient;
    Integer question;
    Integer note;
    Double action;
    Double altruisme;
    Double flexibilite;
    Double competition;
    Double strategie;
    Double improvisation;
    Double rationalisme;
    Double droiture;
    Double autonomie;
    Double exploration;
    Double Pouvoir;
    Double professionnelle;
    Double extraversion;
    Double stabilite;


}
