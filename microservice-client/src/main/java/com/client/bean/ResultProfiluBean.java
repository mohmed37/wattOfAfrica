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

public class ResultProfiluBean {
    int id;
    Integer idclient;
    Integer question;
    double authenticite;
    double tenacite;
    double reactivite;
    double introversion;
    double methode;
    double intuition;
    double nonConformisme;
    double equilibre;
    double directive;
    double prudence;
    double gregarite;
    double individualisme;
    double traditionnel;


}
