package com.tests.web.controler;

import com.tests.dao.cgu.CguProperties;
import com.tests.entity.cgu.Cgu;
import com.tests.entity.ndream.FicheMetier;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cgu")
public class cguControler {

    @Autowired
    CguProperties cguProperties;

    @PostMapping(value = "/saveCgu")
    public ResponseEntity<Cgu> saveFicheMetier(@RequestBody Cgu cgu, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }
        Cgu saveCgu = cguProperties.save(cgu);
        return new ResponseEntity<Cgu>(saveCgu, HttpStatus.CREATED);}

    @GetMapping(value = "getCgu")
    public Optional<Cgu> getCgu() {
        return cguProperties.findById(0);
    }
}
