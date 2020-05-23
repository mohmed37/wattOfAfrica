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
public class AutoPortraitResultBean {
    int id;
    Integer client;
    String qualite1;
    String qualite2;
    String qualite3;
    String qualite4;
    String qualite5;
    String qualite6;
    String defaut1;
    String defaut2;
    String defaut3;
    String defaut4;
    String defaut5;
    String defaut6;
    String reflexion;
    Boolean auto1;
    Boolean auto2;
}
