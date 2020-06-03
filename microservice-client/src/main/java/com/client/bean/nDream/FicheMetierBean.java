package com.client.bean.nDream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FicheMetierBean {

    int id;
    String metier;
    String texte;
    String competence;
    String qualite;
    String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "photo_id")
    PhotoFicheMetierBean photo;
}
