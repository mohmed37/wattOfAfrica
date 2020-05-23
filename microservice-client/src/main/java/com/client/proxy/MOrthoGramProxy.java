package com.client.proxy;

import com.client.bean.orthogram.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")

public interface MOrthoGramProxy {

    @GetMapping(value = "microservice-tests/listQuestionOrtho1")
    List<Orthographe1Bean> listQuestionOrtho1();

    @GetMapping(value = "microservice-tests/listQuestionOrtho2")
   List<Orthographe2Bean> listQuestionOrtho2();

    @GetMapping(value = "microservice-tests/questionOrtho1/{id}")
    Optional<Orthographe1Bean> questionOrtho1(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionOrtho2/{id}")
    Optional<Orthographe2Bean> questionOrtho2(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/listQuestionGram1")
    List<Grammaire1Bean> listQuestionGram1();

    @GetMapping(value = "microservice-tests/listQuestionGram2")
    List<Grammaire2Bean> listQuestionGram2();

    @GetMapping(value = "microservice-tests/questionGram1/{id}")
    Optional<Grammaire1Bean> questionGram1(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/questionGram2/{id}")
    Optional<Grammaire2Bean> questionGram2(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/listResultatOrtho")
    List<OrthographeResultBean> listResultatOrtho();

    @GetMapping(value = "microservice-tests/resultClientOrtho/{id}")
   Optional<OrthographeResultBean> resultClientOrtho(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveClientOrtho")
    OrthographeResultBean saveClientPerso(@RequestBody OrthographeResultBean orthographeResult);

    @PutMapping(value = "microservice-tests/saveResutatOrtho")
    void saveResutatOrtho(@RequestBody OrthographeResultBean orthographeResult );
}
