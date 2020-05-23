package com.tests.entity.praicoU;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "questionnaire4")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Qcm4 implements Serializable {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "metier")
    String metier;
    @Column(name = "code")
    String code;

}