package com.client.bean.orthogram;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.util.Timer;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrthographeResultBean {

    int id;
    Integer client;
    Integer question;
    Integer questionPasse;
    Boolean exerciceOrtho1;
    Integer scoreOrtho;
    Boolean exerciceGram1;
    Integer scoreGram1;




}
