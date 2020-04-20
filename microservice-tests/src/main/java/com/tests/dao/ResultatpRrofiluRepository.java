package com.tests.dao;

import com.tests.entity.ProfilU;
import com.tests.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultatpRrofiluRepository extends JpaRepository<Resultat,Integer> {

Optional<Resultat> findByIdclient(int id);

}
