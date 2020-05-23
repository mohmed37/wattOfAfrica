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
public class Orthographe2Bean {

    int id;
    String mot1;
    String mot2;
    String mot3;
    String mot4;
    String mot5;
    String solution;
}
