package com.client.proxy;

import com.client.bean.entreprendre.EntreprResultBean;
import com.client.bean.entreprendre.EntrepreneurBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MEntrpProxy {


    @GetMapping(value = "microservice-tests/listQuestionEntrepreneur")
    List<EntrepreneurBean> listQuestionEntrepreneur();

    @GetMapping(value = "microservice-tests/listResultatEntrepreneur")
    List<EntreprResultBean> listResultatEntrepreneur();

    @GetMapping(value = "microservice-tests/questionEntrepreneur/{id}")
    Optional<EntrepreneurBean> questionEntrepreneur(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/resultClientEntrepr/{id}")
    Optional<EntreprResultBean> resultClientEntrepr(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveClientEntrep")
    EntreprResultBean saveClientEntrep(@RequestBody EntreprResultBean entreprResult);

    @PutMapping(value = "microservice-tests/saveResutatEntrep")
    void saveResutatEntrep(@RequestBody EntreprResultBean entreprResult );
}
