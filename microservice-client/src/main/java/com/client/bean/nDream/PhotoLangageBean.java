package com.client.bean.nDream;

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
public class PhotoLangageBean {
    int id;
    Integer client;
    Integer photo1;
    Integer photo2;
    Integer photo3;
    String mot1;
    String mot2;
    String mot3;
    Integer photo4;
    Integer photo5;
    Integer photo6;
    String mot4;
    String mot5;
    String mot6;
    Boolean test1;
}
