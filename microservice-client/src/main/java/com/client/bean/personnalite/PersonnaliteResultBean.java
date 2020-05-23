package com.client.bean.personnalite;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonnaliteResultBean {
    int id;
    Integer client;
    Integer question;
    Integer equilibre;
    Integer extraversion;
    Integer experience;
    Integer altruisme;
    Integer Meticulosite;

}
