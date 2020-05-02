package com.client.bean.praicoU;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResultPraicoUBean {

    int id;
    Integer qcm1;
    Integer qcm2;
    Integer qcm3;
    Integer qcm4;
    Integer client;
    Integer nombreP;
    Integer nombreR;
    Integer nombreA;
    Integer nombreI;
    Integer nombreC;
    Integer nombreO;


}
