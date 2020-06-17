package com.microserviceuser.dao;

import com.microserviceuser.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
 AppUser findByUsername(String username);
 Page<AppUser>findByPrenomContains(@Param("prenom") String prenon,Pageable pageable);
  Optional<AppUser> findByEmailAndPassword(String email,String password);


}
