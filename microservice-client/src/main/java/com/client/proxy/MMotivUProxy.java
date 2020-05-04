package com.client.proxy;

import com.client.bean.motivU.MotivUBean;
import com.client.bean.motivU.MotivUResultBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MMotivUProxy {

    @GetMapping(value = "microservice-tests/listQuestionMotivU")
   List<MotivUBean> listQuestionMotivUr();

    @GetMapping(value = "microservice-tests//listResultatMotivU")
    List<MotivUResultBean> listResultatMotivU();


    @GetMapping(value = "microservice-tests//questionMotivU/{id}")
    Optional<MotivUBean> questionMotivU(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests//resultClientMotivU/{id}")
    Optional<MotivUResultBean> resultClientMotivU(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests//saveClientMotivU")
    MotivUResultBean saveClientMotivU(@RequestBody MotivUResultBean motivUResult);

    @PutMapping(value = "microservice-tests/saveResutatMotiv")
    void saveResutatMotivU(@RequestBody MotivUResultBean motivUResult );
}
