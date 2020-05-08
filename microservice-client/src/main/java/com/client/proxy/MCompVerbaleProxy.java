package com.client.proxy;

import com.client.bean.compVerbale.CompVerbale1Bean;
import com.client.bean.compVerbale.CompVerbale2Bean;
import com.client.bean.compVerbale.CompVerbale3Bean;
import com.client.bean.compVerbale.VerbaleResultBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MCompVerbaleProxy {

    @PostMapping(value = "microservice-tests/saveVerbale")
    CompVerbale2Bean saveVerbale(@RequestBody CompVerbale2Bean compVerbale);

    @GetMapping(value = "microservice-tests/exercice1/{id}")
    Optional<CompVerbale1Bean> exercice1(@PathVariable("id") int id);;

    @GetMapping(value = "microservice-tests/exercice2/{id}")
    Optional<CompVerbale2Bean>exercice2(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/exercice3/{id}")
    Optional<CompVerbale3Bean>exercice3(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/listVerbaleAll")
    List<VerbaleResultBean> listVerbaleAll();

    @GetMapping(value = "microservice-tests/resultatVerbaleClient/{id}")
    Optional<VerbaleResultBean>resultatVerbaleClient(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveVerbale")
    VerbaleResultBean saveVerbale(@RequestBody VerbaleResultBean verbaleResult);

    @PutMapping(value = "microservice-tests/changeVerbale")
    void changeVerbale(@RequestBody VerbaleResultBean verbaleResult);

    @GetMapping(value = "microservice-tests/exercice1All")
    List<CompVerbale1Bean>exercice1All();
    @GetMapping(value = "microservice-tests/exercice2All")
    List<CompVerbale2Bean>exercice2All();
    @GetMapping(value = "microservice-tests/exercice3All")
    List<CompVerbale3Bean>exercice3All();



}
