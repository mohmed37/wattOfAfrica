package com.microserviceuser.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questionnaire")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Questionnaires implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    AppUser user;

}
