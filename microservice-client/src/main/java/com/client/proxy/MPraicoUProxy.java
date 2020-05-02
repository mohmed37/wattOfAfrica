package com.client.proxy;

import com.client.bean.praicoU.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MPraicoUProxy {

    @GetMapping(value = "microservice-tests/praicoAll")
    List<ResultPraicoUBean>praicoALL();

    @PutMapping(value = "microservice-tests/modifResultPraicoU")
    void modifResultPraicoU(@RequestBody ResultPraicoUBean resultPraicoU);

    @PostMapping(value = "microservice-tests/saveResultPraicoU")
    ResultPraicoUBean saveResultPraicoU(@RequestBody ResultPraicoUBean resultPraicoU);

    @GetMapping(value = "microservice-tests/praicoIdClient/{id}")
    Optional<ResultPraicoUBean> praicoIdClient(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionnaire1/{id}")
    Optional<Qcm1Bean> questionnnaire1(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionnaire2/{id}")
    Optional<Qcm2Bean> questionnnaire2(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionnaire3/{id}")
   Optional<Qcm3Bean> questionnnaire3(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionnaire4")
    List<Qcm4Bean> questionnnaire4();


}
