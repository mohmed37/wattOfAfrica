package com.client.bean.emoU;

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
public class EmoUResultBean {
    int id;
    Integer client;
    Integer question;
    Double adaptabilite;
    Double connaissance;
    Double automotivation;
    Double maitrise;
    Double assertivite;
    Double  confiance;
    Double relationnelle;
    Double estime;
    Double optimisme;
    Double resilience;
    Double influence;
    Double empathie;

}
