package com.client.proxy;

import com.client.bean.commerciale.CommercialeBean;
import com.client.bean.commerciale.CommercialeResultBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MCommerProxy {

    @GetMapping(value = "microservice-tests/listQuestionCommercial")
    List<CommercialeBean> listQuestionCommercial();

    @GetMapping(value = "microservice-tests/listResultatCommercial")
    List<CommercialeResultBean> listResultatCommercial();

    @GetMapping(value = "microservice-tests/questionCommercial/{id}")
    Optional<CommercialeBean> questionCommercial(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/resultClientCom/{id}")
    Optional<CommercialeResultBean> resultClientCom(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveClientCom")
    CommercialeResultBean saveClientCom(@RequestBody CommercialeResultBean commercialeResultBean);

    @PutMapping(value = "microservice-tests/saveResutatCom")
    void saveResutatCom(@RequestBody CommercialeResultBean commercialeResultBean );
}
