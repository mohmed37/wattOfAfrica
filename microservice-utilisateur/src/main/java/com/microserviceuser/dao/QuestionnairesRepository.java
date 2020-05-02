package com.microserviceuser.dao;

import com.microserviceuser.entities.Questionnaires;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.OpenOption;
import java.util.Optional;

public interface QuestionnairesRepository extends JpaRepository<Questionnaires,Integer> {

    Optional<Questionnaires>findByUser_Num(Integer id);
}
