package com.microserviceuser.web.controller;


import com.microserviceuser.dao.AppRoleRepository;
import com.microserviceuser.dao.AppUserRepository;
import com.microserviceuser.dao.QuestionnairesRepository;
import com.microserviceuser.entities.AppRole;
import com.microserviceuser.entities.AppUser;
import com.microserviceuser.entities.Questionnaires;
import com.microserviceuser.web.exeception.QuestionNotFoundException;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private QuestionnairesRepository questionRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;


    /**
     * Rechercher un utilisateur par son id.
     * @param id utilisateur
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public Optional<AppUser> findById(@PathVariable("id") int id) {
        Optional<AppUser> appUsers = appUserRepository.findById(id);
        return appUsers;
    }
    @GetMapping(value = "/usersAll")
    public Page<AppUser> findByAll(@RequestParam(name="page",defaultValue = "0")int page,
                                   @RequestParam(name="size",defaultValue = "3")int size,
                                   @RequestParam(name = "prenom",defaultValue ="") String prenom) {
        Page<AppUser> appUsers = appUserRepository.findByPrenomContains(prenom,PageRequest.of(page,size));
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

    @PostMapping(value = "saveUser")
    public AppUser saveUser(@RequestBody AppUser appUser
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }
        appUser.setActive(true);
       appUser.setRoles(Arrays.asList(appRoleRepository.findByRole("ROLE_USER")));

        return appUserRepository.save(appUser);
    }
    @PutMapping(value = "modifUser/{id}")
    public AppUser modifUser(@RequestBody AppUser appUser
            , BindingResult bindingResult,@PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return null;
        }
        Optional<AppUser> user=appUserRepository.findById(id);
        user.get().setPhone(appUser.getPhone());
        user.get().setEmail(appUser.getEmail());
        user.get().setPrenom(appUser.getPrenom());
        user.get().setNom(appUser.getNom());
        return appUserRepository.save(user.get());
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public  void delete(@PathVariable("id") int id){

       appUserRepository.deleteById(id);

    }



}


