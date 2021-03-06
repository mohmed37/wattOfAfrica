package com.tests.web.controler;

import com.tests.dao.bnbecome.HandiWattRepositories;
import com.tests.dao.bnbecome.ListCompetencesClientRepositories;
import com.tests.dao.bnbecome.ListCompetencesRepositories;
import com.tests.entity.bnbecome.HandiWatt;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/watt")
public class TestBnBecome {
    @Autowired
    ListCompetencesRepositories listCompetencesRepositories;
    @Autowired
    ListCompetencesClientRepositories clientRepositories;
    @Autowired
    HandiWattRepositories handiWattRepositories;

    /**
     * Rechercher la list des compétence
     * @return
     */

    @GetMapping(value = "/listCompetences")
    public List<ListCompetences> listCompetences() {

        return listCompetencesRepositories.findAll();
    }

    /**
     * Rechercher d'une compétence  par son id
     * @param id
     * @return
     */

    @GetMapping(value = "getCompetenceById/{id}")
    public Optional<ListCompetences> getCompetenceById(@PathVariable("id") Integer id) {
        Optional<ListCompetences> competence = listCompetencesRepositories.findById(id);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }

    /**
     * Rechercher d'une compétence  par son competence
     * @param competenceNew
     * @return
     */

    @GetMapping(value = "getCompetenceByCompetence/{competence}")
    public Optional<ListCompetences> getCompetenceByCompetence(@PathVariable("competence") String competenceNew) {
        Optional<ListCompetences> competence = listCompetencesRepositories.findByCompetence(competenceNew);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }

    /**
     * Enregistrer la list des compétences
     * @return
     */
    @PostMapping(value = "/saveListCompetences")
    public ListCompetences saveListCompetences(@RequestBody ListCompetences listCompetences, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;        }
        return  listCompetencesRepositories.save(listCompetences);
    }

    /**
     * Enregistrer la list des compétences client
     * @return
     */
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

    /**
     * Rechercher d'une compétence client  par id user
     * @param id
     * @return
     */
    @GetMapping(value = "getCompetenceClientByIdClient/{id}")
    public Optional<ListCompetencesClient> getCompetenceClientByIdClient(@PathVariable("id") Integer id) {
        Optional<ListCompetencesClient> competence = clientRepositories.findByIdclient(id);
        if (!competence.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return competence;
    }

    //HandiWatt
    /**
     * Enregistrer  handiwatt
     * * @return
     */
    @PostMapping(value = "/saveHandiWatt")
    public HandiWatt saveHandiWatt(@RequestBody HandiWatt handiWatt, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;        }
        List<HandiWatt> list=handiWattRepositories.findAll();
        for( HandiWatt handiWattClient : list ) {
            if (handiWattClient.getIdclient()==handiWatt.getIdclient()){
                handiWattClient.setMister(handiWatt.getMister());
                handiWattClient.setPotentiel(handiWatt.getPotentiel());
                return  handiWattRepositories.save(handiWattClient);
            }
        }
        return  handiWattRepositories.save(handiWatt);
    }

    /**
     * Rechercher  handiwatt client  par id user
     * @param id
     * @return
     */
    @GetMapping(value = "getHandiWattByIdClient/{id}")
    public HandiWatt getHandiWattByIdClient(@PathVariable("id") int id) {
        return handiWattRepositories.findByIdclient(id);
    }


}
