package com.microserviceuser.web.controller;


import com.microserviceuser.dao.AppUserRepository;
import com.microserviceuser.dao.QuestionnairesRepository;
import com.microserviceuser.entities.AppUser;
import com.microserviceuser.entities.Questionnaires;
import com.microserviceuser.web.exeception.QuestionNotFoundException;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private QuestionnairesRepository questionRepository;


    /**
     * Rechercher un utilisateur par son id.
     * @param id utilisateur
     * @return
     */
    @GetMapping(value = "/users")
    public Optional<AppUser> findById(@RequestParam(name = "id") Integer id) {
        Optional<AppUser> appUsers = appUserRepository.findById(id);
        return appUsers;
    }

    /**
     * Enregistrer un utilisateur
     * @param username
     * @return
     */

    @PostMapping(value = "/username")
    public AppUser findUserByUsername(@RequestParam(name = "username", defaultValue = "") String username) {
        return appUserRepository.findByUsername(username);
    }

    @GetMapping(value = "questionnairesUser")
    public Optional<Questionnaires>questionnairesUser(@RequestParam(name="id",defaultValue = " ")int id){
        Optional<Questionnaires>question=questionRepository.findByUser_Num(id);
        if (!question.isPresent())throw new QuestionNotFoundException("Vous n'avez pas de quetionnaires");
        return question;
    }

    @PostMapping(value = "saveQuestionnaires")
    public ResponseEntity<Questionnaires>saveQuestionnaires(@RequestBody Questionnaires questionnaires
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }
        questionnaires.setProfilU(false);
        Questionnaires saveQusetionnaires=questionRepository.save(questionnaires);
        return new ResponseEntity<Questionnaires>(saveQusetionnaires, HttpStatus.CREATED);
    }

    @PutMapping(value = "modifQuestionnaire")
    public void updateQuestionnaire(@RequestBody Questionnaires questionnaires){
        questionRepository.save(questionnaires);
    }



}


