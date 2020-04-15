package com.client.controler;



import com.client.bean.ProfiluBean;
import com.client.proxy.MtestsProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ClientController {

    @Autowired
    MtestsProxy mtestsProxy;

    @Value("${dir.images}")
    private String imageDir;

    Logger log = LoggerFactory.getLogger(this.getClass());
    private Model model;


    @RequestMapping("/")
    public String accueil(Model model){
        List<ProfiluBean>questionsList=mtestsProxy.listDesQuestion();
        model.addAttribute("listQuestion",questionsList);

        return "profil";
    }


}
