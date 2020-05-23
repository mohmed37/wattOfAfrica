package com.tests.web.controler;

import com.tests.dao.profilU.ProfiluRepository;
import com.tests.dao.profilU.RestititutionRepository;
import com.tests.dao.profilU.ResultatRaRepository;
import com.tests.dao.profilU.ResultatRbRepository;
import com.tests.entity.profilU.ProfilU;
import com.tests.entity.profilU.RestitutionProfilU;
import com.tests.entity.profilU.ResultatRa;
import com.tests.entity.profilU.ResultatRb;
import com.tests.proxy.MuserProxy;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.MapUtils;

import java.util.List;
import java.util.Optional;

@RestController
public class TestProfilUControler {
    @Autowired
    ResultatRaRepository resultatRaRepository;
    @Autowired
    ResultatRbRepository resultatRbRepository;
    @Autowired
    ProfiluRepository profiluRepository;
    @Autowired
    RestititutionRepository restititutionRepository;
    @Autowired
    MuserProxy muserProxy;




    @GetMapping(value = "/listQuestion")
    public List<ProfilU> listDesQuestion() {
        return profiluRepository.findAll();
    }

    @GetMapping(value = "/listResultat")
    public List<ResultatRa> listResultat() {
        return resultatRaRepository.findAll();
    }


    @GetMapping(value = "/question/{id}")
    public Optional<ProfilU> question(@PathVariable("id") int id) {
        Optional<ProfilU> question = profiluRepository.findById(id);
        if (!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
    }

    @GetMapping(value = "/questionClient/{id}")
    public Optional<ResultatRa> questionClient(@PathVariable("id") int id) {
        Optional<ResultatRa> resultatClient = resultatRaRepository.findByIdclient(id);
        if (!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;
    }

    @GetMapping(value = "/questionClientRb/{id}")
    public Optional<ResultatRb> questionClientRb(@PathVariable("id") int id) {
        Optional<ResultatRb> resultatClient = resultatRbRepository.findByIdclient(id);
        if (!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;

    }


    @PostMapping(value = "saveClientRa")
    public ResultatRa saveClientRa(@RequestBody ResultatRa resultatRa) {
        resultatRa.setAuthenticite(0.0);
        resultatRa.setDirective(0.0);
        resultatRa.setGregarite(0.0);
        resultatRa.setIndividualisme(0.0);
        resultatRa.setIntroversion(0.0);
        resultatRa.setIntuition(0.0);
        resultatRa.setMethode(0.0);
        resultatRa.setNonConformisme(0.0);
        resultatRa.setNote(0);
        resultatRa.setPersonnelle(0.0);
        resultatRa.setPrudence(0.0);
        resultatRa.setReactivite(0.0);
        resultatRa.setTenacite(0.0);
        resultatRa.setTraditionnel(0.0);
        resultatRa.setQuestion(1);
        resultatRa.setReflexion(0.0);
        return resultatRaRepository.save(resultatRa);
    }

    @PostMapping(value = "saveClientRb")
    public ResultatRb saveClientRb(@RequestBody ResultatRb resultatRb) {
        resultatRb.setAltruisme(0.0);
        resultatRb.setAutonomie(0.0);
        resultatRb.setCompetition(0.0);
        resultatRb.setDroiture(0.0);
        resultatRb.setExploration(0.0);
        resultatRb.setExtraversion(0.0);
        resultatRb.setFlexibilite(0.0);
        resultatRb.setImprovisation(0.0);
        resultatRb.setNote(0);
        resultatRb.setPouvoir(0.0);
        resultatRb.setProfessionnelle(0.0);
        resultatRb.setQuestion(1);
        resultatRb.setRationalisme(0.0);
        resultatRb.setStabilite(0.0);
        resultatRb.setStrategie(0.0);
        resultatRb.setAction(0.0);
        return resultatRbRepository.save(resultatRb);
    }


    @PutMapping(value = "saveResutatRa")
    public void saveRa(@RequestBody ResultatRa resultatRa) {
        resultatRaRepository.save(resultatRa);
    }

    @PutMapping(value = "saveResutatRb")
    public void saveRb(@RequestBody ResultatRb resultatRb) {
        resultatRbRepository.save(resultatRb);
    }

    @PostMapping(value = "saveRestitution")
    public RestitutionProfilU saveRestitution(@RequestBody RestitutionProfilU restitution) {
        return restititutionRepository.save(restitution);
    }
    @GetMapping(value = "restitusionFindId/{id}")
    public Optional<RestitutionProfilU>findById(@PathVariable("id") int id){
        return restititutionRepository.findById(id);
    }

    @GetMapping(value = "restitusionAll")
    public List<RestitutionProfilU>findByAll(){
        return restititutionRepository.findAll();
    }

}
