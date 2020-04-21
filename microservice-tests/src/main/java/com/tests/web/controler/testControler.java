package com.tests.web.controler;

import com.tests.dao.ProfiluRepository;
import com.tests.dao.ResultatRaRepository;
import com.tests.dao.ResultatRbRepository;
import com.tests.entity.ProfilU;
import com.tests.entity.ResultatRa;
import com.tests.entity.ResultatRb;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class testControler {
    @Autowired
    ResultatRaRepository resultatRaRepository;
    @Autowired
    ResultatRbRepository resultatRbRepository;
    @Autowired
    ProfiluRepository profiluRepository;


    /**
     * Liste de tous les livres en librairie
     */
    @GetMapping(value = "/listQuestion")
    public List<ProfilU> listDesQuestion(){
        return profiluRepository.findAll();
    }

    @GetMapping(value = "/listResultat")
    public List<ResultatRa>listResultat(){
        return resultatRaRepository.findAll();
    }


    @GetMapping(value = "/question/{id}")
    public Optional<ProfilU> question(@PathVariable("id") int id){
        Optional<ProfilU> question=profiluRepository.findById(id);
        if(!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
     }

    @GetMapping(value = "/questionClient/{id}")
    public Optional<ResultatRa> questionClient(@PathVariable("id") int id){
        Optional<ResultatRa> resultatClient= resultatRaRepository.findByIdclient(id);
        if(!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;}

    @GetMapping(value = "/questionClientRb/{id}")
    public Optional<ResultatRb> questionClientRb(@PathVariable("id") int id){
        Optional<ResultatRb> resultatClient= resultatRbRepository.findByIdclient(id);
        if(!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;

    }


    @PostMapping(value = "saveClient")
    public ResultatRa saveClient(ResultatRa resultatRa){
        return resultatRaRepository.save(resultatRa);
    }

    @PutMapping(value = "saveResutatRa")
    public void saveRa(@RequestBody ResultatRa resultatRa) {
          resultatRaRepository.save(resultatRa);
    }

    @PutMapping(value = "saveResutatRb")
    public void saveRb(@RequestBody ResultatRb resultatRb) {
        resultatRbRepository.save(resultatRb);
    }


}
