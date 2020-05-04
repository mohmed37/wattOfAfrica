package com.client.proxy;

import com.client.bean.comU.ComUBean;
import com.client.bean.comU.ComUResultBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MComUProxy {
    @GetMapping(value = "microservice-tests/listQuestionComU")
    List<ComUBean> listQuestionComU();

    @GetMapping(value = "microservice-tests/listResultatComU")
    List<ComUResultBean> listResultatComU();

    @GetMapping(value = "microservice-tests/questionComU/{id}")
    Optional<ComUBean> questionComU(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/resultClientComU/{id}")
    Optional<ComUResultBean> resultClientComU(@PathVariable("id") int id);
    @PostMapping(value = "microservice-tests/saveClientComU")
    ComUResultBean saveClientComU(@RequestBody ComUResultBean comUResult);

    @PutMapping(value = "microservice-tests/saveResutatComU")
    void saveResutatComU(@RequestBody ComUResultBean comUResult);
}
