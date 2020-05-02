package com.client.bean.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.ManyToOne;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionnairesBean {
    Long id;
    Boolean profilU;
    Boolean qcm1;
    Boolean qcm2;
    Boolean qcm3;
    Boolean qcm4;
    Boolean emoU;
    Boolean entrepreneur;
    String resultatString;
    Integer resultatInteger;
    @ManyToOne
    UserBean user;
}
