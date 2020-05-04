package com.client.bean.comU;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComUResultBean {

    int id;
    Integer client;
    Integer question;
    Double expression;
    Double nonverbal;
    Double ecoute;
    Double redactionnelle;
    Double observation;
    Double  persuasion;
    Double sympathie;
    Double autorite;
    Double encensement;
    Double rationalite;
    Double pression;
    Double reserve;
}
