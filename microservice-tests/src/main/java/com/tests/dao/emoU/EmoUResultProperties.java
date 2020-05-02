package com.tests.dao.emoU;

import com.tests.entity.emoU.EmoUResult;
import com.tests.entity.profilU.ResultatRb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmoUResultProperties extends JpaRepository<EmoUResult,Integer> {
    Optional<EmoUResult> findByClient(int id);

}
