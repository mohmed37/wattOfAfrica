package com.tests.web.controler;

import com.tests.dao.profilU.ProfiluRepository;
import com.tests.dao.profilU.RestititutionRepository;
import com.tests.dao.profilU.ResultatRaRepository;
import com.tests.entity.profilU.ProfilU;
import com.tests.entity.profilU.RestitutionProfilU;
import com.tests.entity.profilU.ResultatRa;
import com.tests.proxy.MuserProxy;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestProfilUControler {
    @Autowired
    ResultatRaRepository resultatRaRepository;
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


    @PostMapping(value = "saveClientRa")
    public ResultatRa saveClientRa(@RequestBody ResultatRa resultatRa) {
        resultatRa.setAuthenticite(Math.round(resultatRa.getAuthenticite()));
        resultatRa.setDirective(Math.round(resultatRa.getDirective()));
        resultatRa.setGregarite(Math.round(resultatRa.getGregarite()));
        resultatRa.setIndividualisme(Math.round(resultatRa.getIndividualisme()));
        resultatRa.setIntroversion(Math.round(resultatRa.getIntroversion()));
        resultatRa.setIntuition(Math.round(resultatRa.getIntuition()));
        resultatRa.setMethode(Math.round(resultatRa.getMethode()));
        resultatRa.setNonConformisme(Math.round(resultatRa.getNonConformisme()));
        resultatRa.setPersonnelle(Math.round(resultatRa.getPersonnelle()));
        resultatRa.setPrudence(Math.round(resultatRa.getPrudence()));
        resultatRa.setReactivite(Math.round(resultatRa.getReactivite()));
        resultatRa.setReflexion(Math.round(resultatRa.getReflexion()));
        resultatRa.setTenacite(Math.round(resultatRa.getTenacite()));
        resultatRa.setTraditionnel(Math.round(resultatRa.getTraditionnel()));
        return resultatRaRepository.save(resultatRa);
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
