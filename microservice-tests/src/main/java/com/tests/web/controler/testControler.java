package com.tests.web.controler;

import com.tests.dao.ProfiluRepository;
import com.tests.dao.ResultatpRrofiluRepository;
import com.tests.entity.ProfilU;
import com.tests.entity.Resultat;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class testControler {
    @Autowired
    ResultatpRrofiluRepository resultatpRrofiluRepository;
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
    public List<Resultat>listResultat(){
        return resultatpRrofiluRepository.findAll();
    }


    @GetMapping(value = "/question/{id}")
    public Optional<ProfilU> question(@PathVariable("id") int id){
        Optional<ProfilU> question=profiluRepository.findById(id);
        if(!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
     }

//    @GetMapping(value = "/questionClient/{id}")
//    public Optional<Resultat> questionClient(@PathVariable("id") int id){
//        Optional<Resultat> resultatClient= resultatpRrofiluRepository.findByIdclient(id);
//        if(!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
//        return resultatClient;}


    @GetMapping(value = "saveClient")
    public Resultat saveClient(Resultat resultat){
        return resultatpRrofiluRepository.save(resultat);
    }

    @GetMapping(value = "saveResutatProfilU")
    public Resultat save(@PathVariable("idQ") int idQ, @PathVariable("idClient")
            int iCclient, @PathVariable("note")int note) {
        ProfilU question = profiluRepository.findById(idQ).get();
        Resultat resultat = resultatpRrofiluRepository.findByIdclient(iCclient).get();

        double ra2 = 1;
        double rb1 = 1;

        if (question.getCode().equals("ra")) {
            double ra1 = note / 5;
            ra2 = 5 - ra1;
        } else {
            rb1 = note / 5;
        }
        double dimension = (ra2 + rb1);


        resultat.setIdclient(1);
        resultat.setQuestion(idQ);

        switch (question.getDimention()) {
            case "Authenticité":resultat.setAuthenticite((dimension+resultat.getAuthenticite())/140);break;
            case "Ténacité":resultat.setTenacite((dimension+resultat.getTenacite())/140);break;
            case "Réactivité":resultat.setReactivite((dimension+resultat.getReactivite())/140);break;
           case "Introversion":resultat.setIntroversion((dimension+resultat.getIntroversion())/140);break;
            case "Méthode":resultat.setMethode((dimension+resultat.getMethode())/140);break;
           case "Intuition":resultat.setIntuition((dimension+resultat.getIntuition())/140);break;
            case "Non conformisme":resultat.setNonConformisme((dimension+resultat.getNonConformisme())/140);break;
            case "Equilibre":resultat.setEquilibre((dimension+resultat.getEquilibre())/140);break;
            case "Directive":resultat.setDirective((dimension+resultat.getDirective())/140);break;
            case "Prudence":resultat.setPrudence((dimension+resultat.getPrudence())/140);break;
            case "Grégarité":resultat.setGregarite((dimension+resultat.getGregarite())/140);break;
            case "Individualisme":resultat.setIndividualisme((dimension+resultat.getIndividualisme())/140);break;
            case "Traditionnel":resultat.setTraditionnel((dimension+resultat.getTraditionnel())/140);break;
        }
        return resultatpRrofiluRepository.save(resultat);
    }


}
