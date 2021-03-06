package com.tests.web.controler;

import com.tests.dao.orthogram.*;
import com.tests.entity.orthoGram.*;
import com.tests.proxy.MuserProxy;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/watt")
public class TestOrthoGramControler {
    @Autowired
    MuserProxy proxy;
    @Autowired
    Ortho1Repositories ortho1Repositories;
    @Autowired
    Ortho2Repositorie ortho2Repositorie;
    @Autowired
    Gram1Repositories gram1Repositories;
    @Autowired
    Gram2Repositories gram2Repositories;
    @Autowired
    OrthoResultRepositories orthoResultRepositories;

    /**
     * List des questions du test de orthographe 1
     @return
     */
    @GetMapping(value = "/listQuestionOrtho1")
    public List<Orthographe1> listQuestionOrtho1() {
        return ortho1Repositories.findAll();
    }

    /**
     * List des questions du test de orthographe 2
     @return
     */
    @GetMapping(value = "/listQuestionOrtho2")
    public List<Orthographe2> listQuestionOrtho2() {
        return ortho2Repositorie.findAll();
    }


    /**
     * recherche d'une  question du test orthographe 1 par son id
     * @param id
     * @return
     */

    @GetMapping(value = "/questionOrtho1/{id}")
    public Optional<Orthographe1> questionOrtho1(@PathVariable("id") int id) {
        Optional<Orthographe1> question = ortho1Repositories.findById(id);
        if (!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
    }

    /**
     * recherche d'une  question du test orthographe 2 par son id
     * @param id
     * @return
     */

    @GetMapping(value = "/questionOrtho2/{id}")
    public Optional<Orthographe2> questionOrtho2(@PathVariable("id") int id) {
        Optional<Orthographe2> question = ortho2Repositorie.findById(id);
        if (!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
    }

    /**
     * List des questions du test de grammaire 1
     @return
     */
    @GetMapping(value = "/listQuestionGram1")
    public List<Grammaire1> listQuestionGram1() {
        return gram1Repositories.findAll();
    }

    /**
     * List des questions du test de grammaire 2
     @return
     */
    @GetMapping(value = "/listQuestionGram2")
    public List<Grammaire2> listQuestionGram2() {
        return gram2Repositories.findAll();
    }

    /**
     * Listdes resultats orthographe
     @return
     */
    @GetMapping(value = "/listResultatOrtho")
    public List<OrthoGramResult> listResultatOrtho() {
        return orthoResultRepositories.findAll();
    }

    /**
     * recherche d'une  question du test orthographe  par id client
     * @param id
     * @return
     */

    @GetMapping(value = "/resultClientOrtho/{id}")
    public Optional<OrthoGramResult> resultClientOrtho(@PathVariable("id") int id) {
        Optional<OrthoGramResult> resultatClient = orthoResultRepositories.findByClient(id);
        if (!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;
    }

    /**
     * enregistere le resultat client orthographe
     * @return
     */
    @PostMapping(value = "/saveClientOrtho")
    public OrthoGramResult saveClientPerso(@RequestBody OrthoGramResult orthographeResult) {
        orthographeResult.setScoreOrtho(0);
        orthographeResult.setScoreGram1(0);
        orthographeResult.setQuestion(1);
        orthographeResult.setQuestionPasse(0);
        orthographeResult.setExerciceOrtho1(false);
        orthographeResult.setExerciceGram1(false);
        return orthoResultRepositories.save(orthographeResult);
    }

    /**
     * modifier le resultat client orthographe
     * @return
     */

    @PutMapping(value = "/saveResutatOrtho")
    public void saveResutatOrtho(@RequestBody OrthoGramResult orthographeResult ) {
        orthoResultRepositories.save(orthographeResult);}


    /**
     * recherche d'une  question du test grammaire 1 par son id
     * @param id
     * @return
     */
    @GetMapping(value = "/questionGram1/{id}")
    public Optional<Grammaire1> questionGram1(@PathVariable("id") int id) {
        Optional<Grammaire1> question = gram1Repositories.findById(id);
        if (!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
    }

    /**
     * recherche d'une  question du test grammaire 2 par son id
     * @param id
     * @return
     */
    @GetMapping(value = "/questionGram2/{id}")
    public Optional<Grammaire2> questionGram2(@PathVariable("id") int id) {
        Optional<Grammaire2> question = gram2Repositories.findById(id);
        if (!question.isPresent()) throw new QuestioneNotFoundException("Cette question n'existe pas");
        return question;
    }



}
