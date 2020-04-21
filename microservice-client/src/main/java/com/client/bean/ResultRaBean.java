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

public class ResultRaBean {
    int id;
    Integer idclient;
    Integer question;
    Integer note;
    Double authenticite;
    Double tenacite;
    Double reflexion;
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


}
