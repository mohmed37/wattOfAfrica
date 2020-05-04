package com.client.controler;


import com.client.bean.emoU.EmoUResultBean;
import com.client.bean.emoU.EmoUbean;
import com.client.bean.entreprendre.EntreprResultBean;
import com.client.bean.entreprendre.EntrepreneurBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MEntrpProxy;
import com.client.proxy.MuserProxy;
import com.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EntrepControler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MEntrpProxy entrpProxy;

    private EntreprResultBean entreprResultBean;
    private EntrepreneurBean question;

    @RequestMapping("/questionEntrepreneur")
    public String questionEntrepreneur(Model model) {
        UserBean userConnec = userService.getUserConnec();

        List<EntreprResultBean> entreprResultBeans1 = entrpProxy.listResultatEntrepreneur();
        if (entreprResultBeans1.size() == 0) {
            EntreprResultBean entreprResultBean = new EntreprResultBean();
            entreprResultBean.setClient(userConnec.getNum());

            entrpProxy.saveClientEntrep(entreprResultBean);
        }

        List<EntreprResultBean> entreprResultBeanList = entrpProxy.listResultatEntrepreneur();
        boolean userinscrit = false;
        for (EntreprResultBean entreprResultBean : entreprResultBeanList) {
            if (entreprResultBean.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                EntreprResultBean entreprResultBean1 = new EntreprResultBean();
                entreprResultBean1.setClient(userConnec.getNum());
                entrpProxy.saveClientEntrep(entreprResultBean1);
            }
        }

        entreprResultBean = entrpProxy.resultClientEntrepr(userConnec.getNum()).get();
        int nQuestion = 0;
        nQuestion = entreprResultBean.getQuestion();
        question = entrpProxy.questionEntrepreneur(nQuestion).get();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question", question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", entreprResultBean);


        return "questionEntrepreneur";
    }

    @RequestMapping("/saveEntrepreneur")
    public String saveEntrepreneur(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionEntrepreneur";
        }
        UserBean userConnec=userService.getUserConnec();
        double note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "action":entreprResultBean.setAction((note+ entreprResultBean.getAction()));break;
            case "autonomie":entreprResultBean.setAutonomie((note+ entreprResultBean.getAutonomie()));break;
            case "confiance":entreprResultBean.setConfiance((note+ entreprResultBean.getConfiance()));break;
            case "creativite":entreprResultBean.setCreativie((note+ entreprResultBean.getCreativie()));break;
            case "defi":entreprResultBean.setDefi((note+ entreprResultBean.getDefi()));break;
            case "destin":entreprResultBean.setDestin((note+ entreprResultBean.getDestin()));break;
            case "perseverance":entreprResultBean.setPerseverance((note+ entreprResultBean.getPerseverance()));break;
            case "pouvoir":entreprResultBean.setPouvoir((note+ entreprResultBean.getPouvoir()));break;
            case "realisation":entreprResultBean.setRealisation((note+ entreprResultBean.getRealisation()));break;
            case "tolerance":entreprResultBean.setTolerance((note+ entreprResultBean.getTolerance()));break;


        }

        List<EntrepreneurBean>listQuestion=entrpProxy.listQuestionEntrepreneur();
        if (listQuestion.size()==entreprResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setEntrepreneur(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            entrpProxy.saveResutatEntrep(entreprResultBean);

            return "redirect:/listQuestionnaires";
        }

        entreprResultBean.setQuestion(entreprResultBean.getQuestion()+1);
        entrpProxy.saveResutatEntrep(entreprResultBean);
        return "redirect:/questionEntrepreneur";
    }

    @RequestMapping(value = "/resultatEntrepreneur")
    public String resultatEntrepreneur(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<EntreprResultBean>resultBean=entrpProxy.resultClientEntrepr(userConnec.getNum());

        model.addAttribute("result",resultBean.get());


        return "resultatEntrepreneur";

    }

}
