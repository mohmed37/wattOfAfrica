package com.client.proxy;

import com.client.bean.ProfiluBean;
import com.client.bean.ResultRaBean;
import com.client.bean.ResultRbBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MtestsProxy {

    @GetMapping(value = "/microservice-tests/listQuestion")
    List<ProfiluBean> listDesQuestion();

    @GetMapping(value = "/microservice-tests/question/{id}")
    Optional<ProfiluBean> question(@PathVariable("id") int id);

    @PutMapping(value = "/microservice-tests/saveResutatRa")
    void saveRa(@RequestBody ResultRaBean resultRaBean);

    @PutMapping(value = "/microservice-tests/saveResutatRb")
    void saveRb(@RequestBody ResultRbBean resultatRb);

    @GetMapping(value = "/microservice-tests/questionClient/{id}")
    Optional<ResultRaBean> questionClient(@PathVariable("id") int id);

    @GetMapping(value = "/microservice-tests/questionClientRb/{id}")
    Optional<ResultRbBean> questionClientRb(@PathVariable("id") int id);

    @GetMapping(value = "/microservice-tests/listResultat")
    List<ResultRaBean>listResultat();

    @GetMapping(value = "/microservice-tests/saveClient")
    ResultRaBean saveClient(ResultRaBean resultatProfilU);

}
