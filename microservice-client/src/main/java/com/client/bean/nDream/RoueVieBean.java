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
public class RoueVieBean {
    int id;
    Integer client;
    Integer social1;
    Integer personnelle1;
    Integer sante1;
    Integer famille1;
    Integer professionnel1;
    Integer social2;
    Integer personnelle2;
    Integer sante2;
    Integer famille2;
    Integer professionnel2;
    String qcm1;
    String qcm2;
    String qcm3;
    Boolean roueVie2;
    Boolean roueVie1;
}
