package com.microserviceuser.dao;

import com.microserviceuser.entities.Questionnaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.file.OpenOption;
import java.util.Optional;
@CrossOrigin("*")
public interface QuestionnairesRepository extends JpaRepository<Questionnaires,Integer> {

    Optional<Questionnaires>findByUser_Num(Integer id);
}
