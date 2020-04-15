package com.tests.web.controler;

import com.tests.dao.ProfiluRepository;
import com.tests.entity.ProfilU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testControler {
    @Autowired
    ProfiluRepository profiluRepository;

    /**
     * Liste de tous les livres en librairie
     */
    @GetMapping(value = "/listQuestion")
    public List<ProfilU> listDesQuestion(){
        return profiluRepository.findAll();

    }


}
