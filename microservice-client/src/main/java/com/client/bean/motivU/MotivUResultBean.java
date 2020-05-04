package com.client.bean.motivU;

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
public class MotivUResultBean {
    int id;
    Integer client;
    Integer question;
    Double social;
    Double rencontres;
    Double challenge;
    Double honnetete;
    Double responsabilite;
    Double  statut;
    Double utilite;
    Double retribution;
    Double personnel;
    Double autonomie;
    Double mobilite;
    Double connaissances;
}
