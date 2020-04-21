package com.tests.dao;

import com.tests.entity.ResultatRa;
import com.tests.entity.ResultatRb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultatRbRepository extends JpaRepository<ResultatRb,Integer> {
    Optional<ResultatRb> findByIdclient(int id);
}
