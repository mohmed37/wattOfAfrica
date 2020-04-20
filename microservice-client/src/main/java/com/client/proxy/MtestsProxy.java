package com.client.proxy;

import com.client.bean.ProfiluBean;
import com.client.bean.ResultProfiluBean;
import com.client.controler.ProfilReponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MtestsProxy {

    @GetMapping(value = "/microservice-tests/listQuestion")
    List<ProfiluBean> listDesQuestion();

    @GetMapping(value = "/microservice-tests/question/{id}")
    Optional<ProfiluBean> question(@PathVariable("id") int id);

    @GetMapping(value = "/microservice-tests/saveResutatProfilU")
    ResultProfiluBean save(@PathVariable("idQ") int idQ,@PathVariable("idClient") int iCclient
            ,@PathVariable("note")int note);

    @GetMapping(value = "/microservice-tests/questionClient/{id}")
    Optional<ResultProfiluBean> questionClient(@PathVariable("id") int id);

    @GetMapping(value = "/microservice-tests/listResultat")
    List<ResultProfiluBean>listResultat();

    @GetMapping(value = "/microservice-tests/saveClient")
    ResultProfiluBean saveClient(ResultProfiluBean resultatProfilU);

}
