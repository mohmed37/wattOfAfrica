package com.client.proxy;

import com.client.bean.personnalite.PersonnaliteBean;
import com.client.bean.personnalite.PersonnaliteResultBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MPersoProxy {
    @GetMapping(value = "microservice-tests/listQuestionPerso")
    List<PersonnaliteBean> listQuestionPerso();

    @GetMapping(value = "microservice-tests/listResultatPerso")
   List<PersonnaliteResultBean> listResultatPerso();

    @GetMapping(value = "microservice-tests/questionPerso/{id}")
    Optional<PersonnaliteBean> questionPerso(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/resultClientPerso/{id}")
    Optional<PersonnaliteResultBean> resultClientPerso(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveClientPerso")
    PersonnaliteResultBean saveClientPerso(@RequestBody PersonnaliteResultBean personnaliteResult);

    @PutMapping(value = "microservice-tests/saveResutatPerso")
    void saveResutatPerso(@RequestBody PersonnaliteResultBean entreprResult );
}
