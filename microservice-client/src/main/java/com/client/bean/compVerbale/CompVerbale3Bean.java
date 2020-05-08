package com.client.bean.compVerbale;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompVerbale3Bean {

    int id;
    String numero;
    String texte;
    String reponse1;
    String reponse2;
    String reponse3;
    String reponse4;
    String solution;
}
