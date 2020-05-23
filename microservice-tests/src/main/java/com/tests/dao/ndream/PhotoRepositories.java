package com.tests.dao.ndream;

import com.tests.entity.ndream.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepositories extends JpaRepository<Photo,Integer> {


    Page<Photo> findAll(Pageable pageable);
}
