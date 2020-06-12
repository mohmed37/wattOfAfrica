package com.microserviceuser.dao;

import com.microserviceuser.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRole(String role);
}
