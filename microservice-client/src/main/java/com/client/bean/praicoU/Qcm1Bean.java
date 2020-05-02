package com.client.bean.praicoU;

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
public class Qcm1Bean {

    int id;
    String question;
    String reponse1;
    String reponse2;
    String code1;
    String code2;

}
