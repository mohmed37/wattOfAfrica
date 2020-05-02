package com.client.bean.profilU;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ResultRbBean {
    int id;
    Integer idclient;
    Integer question;
    @NotNull
    Integer note;
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
    Double action;


}
