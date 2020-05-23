package com.client.bean.orthogram;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orthographe1Bean {

    int id;
    String phrase1;
    String phrase2;
    String reponse1;
    String reponse2;
    String solution;

}
