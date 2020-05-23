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
public class Grammaire2Bean {

   int id;
    String phrase1;
    String phrase2;
    String phrase3;
    String phrase4;
    String solution;
}
