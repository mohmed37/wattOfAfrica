package com.client.controler;



import com.client.bean.ProfiluBean;
import com.client.bean.ResultProfiluBean;
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

    @RequestMapping("/question")
    public String question(Model model) {
        List<ResultProfiluBean>resulutatsList=mtestsProxy.listResultat();
        ResultProfiluBean resultProfiluBean=mtestsProxy.questionClient(1).get();

        for (ResultProfiluBean resultatClient:resulutatsList){
            if (resultatClient.getIdclient()!=resultProfiluBean.getIdclient()){
                ResultProfiluBean resultProfiluBean1=new ResultProfiluBean();
                resultProfiluBean1.setIdclient(1);
                resultProfiluBean1.setQuestion(1);
                mtestsProxy.saveClient(resultProfiluBean1);
            }
        }


        int nQuestion=resultProfiluBean.getQuestion()+1;
        model.addAttribute("nQuestion",nQuestion);
        ProfiluBean question = mtestsProxy.question(nQuestion).get();
        model.addAttribute("pageQuestion", question);

        mtestsProxy.save(nQuestion,1,5);

           return "question";
    }



}
