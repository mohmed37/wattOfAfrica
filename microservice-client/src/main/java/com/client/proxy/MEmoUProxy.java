package com.client.proxy;

import com.client.bean.emoU.EmoUResultBean;
import com.client.bean.emoU.EmoUbean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MEmoUProxy {

    @GetMapping(value = "microservice-tests/listQuestionEmoU")
    List<EmoUbean> listQuestionEmoU();

    @GetMapping(value = "microservice-tests/listResultatEmoU")
    List<EmoUResultBean> listResultatEmoU();

    @GetMapping(value = "microservice-tests/questionEmoU/{id}")
    Optional<EmoUbean> questionEmoU(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/resultClientEmoU/{id}")
    Optional<EmoUResultBean> resultClientEmoU(@PathVariable("id") int id);
    @PostMapping(value = "microservice-tests/saveClientEmoU")
    EmoUResultBean saveClientEmoU(@RequestBody EmoUResultBean emoUResult);

    @PutMapping(value = "microservice-tests/saveResutatEmoU")
    void saveResutatEmoU(@RequestBody EmoUResultBean emoUResult);


}
