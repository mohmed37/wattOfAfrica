package com.tests.web.controler;

import com.tests.dao.bnbecome.ListCompetencesClientRepositories;
import com.tests.dao.bnbecome.ListCompetencesRepositories;
import com.tests.entity.bnbecome.ListCompetences;
import com.tests.entity.bnbecome.ListCompetencesClient;
import com.tests.entity.bnbecome.ListMetierClient;
import com.tests.entity.commercial.Commercial;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestBnBecome {
    @Autowired
    ListCompetencesRepositories listCompetencesRepositories;
    @Autowired
    ListCompetencesClientRepositories clientRepositories;

    @GetMapping(value = "/listCompetences")
    public List<ListCompetences> listCompetences() {

        return listCompetencesRepositories.findAll();
    }

    @GetMapping(value = "getCompetenceById/{id}")
    public Optional<ListCompetences> getCompetenceById(@PathVariable("id") Integer id) {
        Optional<ListCompetences> competence = listCompetencesRepositories.findById(id);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }
    @GetMapping(value = "getCompetenceByCompetence/{competence}")
    public Optional<ListCompetences> getCompetenceByCompetence(@PathVariable("competence") String competenceNew) {
        Optional<ListCompetences> competence = listCompetencesRepositories.findByCompetence(competenceNew);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }


    @PostMapping(value = "/saveListCompetences")
    public ListCompetences saveListCompetences(@RequestBody ListCompetences listCompetences, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;        }
        return  listCompetencesRepositories.save(listCompetences);
    }

    @PostMapping(value = "/saveListCompetencesClient")
    public ListCompetencesClient saveListCompetencesClient(@RequestBody ListCompetencesClient listCompetences, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;        }
        List<ListCompetencesClient>list=clientRepositories.findAll();
        for (ListCompetencesClient listClient:list){
            if (listClient.getIdclient().equals(listCompetences.getIdclient())){
                listClient.setListCompetence(listCompetences.getListCompetence());
                return  clientRepositories.save(listClient);
            }
        }

        return  clientRepositories.save(listCompetences);
    }
    @GetMapping(value = "getCompetenceClientByIdClient/{id}")
    public Optional<ListCompetencesClient> getCompetenceClientByIdClient(@PathVariable("id") Integer id) {
        Optional<ListCompetencesClient> competence = clientRepositories.findByIdclient(id);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }


}
