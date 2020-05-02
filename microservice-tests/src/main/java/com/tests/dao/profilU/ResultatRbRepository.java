package com.tests.dao.profilU;

import com.tests.entity.profilU.ResultatRb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultatRbRepository extends JpaRepository<ResultatRb,Integer> {
    Optional<ResultatRb> findByIdclient(int id);
}
