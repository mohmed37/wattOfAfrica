package com.client.proxy;


import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-utilisateur")
public interface MuserProxy {

    @GetMapping(value = "/microservice-utilisateur/users")
    Optional<UserBean> findById(@RequestParam(name = "id") int id);

    @PostMapping(value ="/microservice-utilisateur/username")
    UserBean findUserByUsername(@RequestParam(name = "username", defaultValue = "") String username);

    @GetMapping(value = "/microservice-utilisateur/questionnairesUser")
    Optional<QuestionnairesBean>questionnairesUser(@RequestParam(name="id",defaultValue = " ")int id);

    @PostMapping(value = "/microservice-utilisateur/saveQuestionnaires")
    ResponseEntity<QuestionnairesBean> saveQuestionnaires(@RequestBody QuestionnairesBean questionnaires);

    @PutMapping(value = "/microservice-utilisateur/modifQuestionnaire")
    void updateQuestionnaire(@RequestBody QuestionnairesBean questionnaires);
}
