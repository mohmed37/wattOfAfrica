package com.client.bean.nDream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeroResultBean {
    int id;
    Integer client;
    String valeur1;
    String valeur2;
    String valeur3;
    String hero;
    Boolean choixHero;
}
