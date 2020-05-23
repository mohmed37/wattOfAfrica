package com.client.controler;

import com.client.bean.personnalite.PersonnaliteBean;
import com.client.bean.personnalite.PersonnaliteResultBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MPersoProxy;
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
public class PersoControler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MPersoProxy persoProxy;

    private PersonnaliteResultBean personnaliteResultBean;
    private PersonnaliteBean question;

    @RequestMapping("/questionPerso")
    public String questionEntrepreneur(Model model) {
        UserBean userConnec = userService.getUserConnec();

        List<PersonnaliteResultBean> PersoResultBeans1 = persoProxy.listResultatPerso();
        if (PersoResultBeans1.size() == 0) {
            PersonnaliteResultBean persoResult = new PersonnaliteResultBean();
            persoResult.setClient(userConnec.getNum());

            persoProxy.saveClientPerso(persoResult);
        }

        List<PersonnaliteResultBean> personnaliteResultBeans = persoProxy.listResultatPerso();
        boolean userinscrit = false;
        for (PersonnaliteResultBean personnaliteResultBean : personnaliteResultBeans) {
            if (personnaliteResultBean.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                PersonnaliteResultBean personnaliteResultBean1 = new PersonnaliteResultBean();
                personnaliteResultBean1.setClient(userConnec.getNum());
                persoProxy.saveClientPerso(personnaliteResultBean1);
            }
        }

        personnaliteResultBean = persoProxy.resultClientPerso(userConnec.getNum()).get();
        int nQuestion = 0;
        nQuestion = personnaliteResultBean.getQuestion();
        question = persoProxy.questionPerso(nQuestion).get();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question", question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", personnaliteResultBean);


        return "questionPerso";
    }

    @RequestMapping("/savePerso")
    public String savePerso(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionPerso";
        }
        UserBean userConnec=userService.getUserConnec();
        int note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "altruisme":
                personnaliteResultBean.setAltruisme((note+ personnaliteResultBean.getAltruisme()));break;
            case "emotionnel":
                personnaliteResultBean.setEquilibre((note+ personnaliteResultBean.getEquilibre()));break;
            case "experience":
                personnaliteResultBean.setExperience((note+ personnaliteResultBean.getExperience()));break;
            case "extraversion":
                personnaliteResultBean.setExtraversion((note+ personnaliteResultBean.getExtraversion()));break;
            case "meticulosite":
                personnaliteResultBean.setMeticulosite((note+ personnaliteResultBean.getMeticulosite()));break;
        }

        List<PersonnaliteBean>listQuestion= persoProxy.listQuestionPerso();
        if (listQuestion.size()== personnaliteResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setPerso(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            persoProxy.saveResutatPerso(personnaliteResultBean);

            return "redirect:/listQuestionnaires";
        }

        personnaliteResultBean.setQuestion(personnaliteResultBean.getQuestion()+1);
        persoProxy.saveResutatPerso(personnaliteResultBean);
        return "redirect:/questionPerso";
    }

    @RequestMapping(value = "/resultatPerso")
    public String resultatPerso(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<PersonnaliteResultBean>resultBean= persoProxy.resultClientPerso(userConnec.getNum());

        model.addAttribute("result",resultBean.get());


        return "resultPerso";

    }

}
