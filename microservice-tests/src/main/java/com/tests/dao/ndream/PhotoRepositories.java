package com.tests.dao.ndream;

import com.tests.entity.ndream.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepositories extends JpaRepository<Photo,Integer> {
}
