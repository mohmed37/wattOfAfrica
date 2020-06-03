package com.tests.dao.ndream;

import com.tests.entity.ndream.FicheMetier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheMetierRepositories extends JpaRepository<FicheMetier,Integer> {
    List<FicheMetier>findByCode(String code);
    List<FicheMetier>findByPhoto_Categirie(String categorie);

}
