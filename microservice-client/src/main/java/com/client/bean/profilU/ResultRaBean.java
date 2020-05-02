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

public class ResultRaBean {
    int id;
    Integer idclient;
    Integer question;
    @NotNull
    Integer note;
    Double authenticite;
    Double tenacite;
    Double introversion;
    Double methode;
    Double intuition;
    Double nonConformisme;
    Double personnelle;
    Double directive;
    Double prudence;
    Double gregarite;
    Double individualisme;
    Double traditionnel;
    Double reactivite;
    Double reflexion;




}
