package com.client.bean.entreprendre;

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
public class EntreprResultBean {
    int id;
    Integer client;
    Integer question;
    Double realisation;
    Double defi;
    Double autonomie;
    Double pouvoir;
    Double confiance;
    Double perseverance;
    Double tolerance;
    Double creativie;
    Double destin;
    Double action;

}
