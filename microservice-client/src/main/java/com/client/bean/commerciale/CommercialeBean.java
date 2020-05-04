package com.client.bean.commerciale;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialeBean {

    int id;
    String pole;
    String dimension;
    String question;
    String a;
    String b;
    String c;
    Boolean inverse;

}

