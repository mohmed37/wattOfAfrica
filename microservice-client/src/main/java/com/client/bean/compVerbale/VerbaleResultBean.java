package com.client.bean.compVerbale;

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
public class VerbaleResultBean {
    int id;
    Integer client;
    Integer question;
    Boolean exercice1;
    Boolean exercice2;
    Integer resultat;
}
