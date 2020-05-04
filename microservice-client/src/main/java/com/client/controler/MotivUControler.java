package com.client.controler;


import com.client.bean.motivU.MotivUBean;
import com.client.bean.motivU.MotivUResultBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MMotivUProxy;
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
public class MotivUControler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MMotivUProxy mMotivUProxy;

    private MotivUResultBean motivUResultBean;
    private MotivUBean question;

    @RequestMapping("/questionMotivU")
    public String questionMotivU(Model model) {
        UserBean userConnec = userService.getUserConnec();

        List<MotivUResultBean> motivUResultBeans1 = mMotivUProxy.listResultatMotivU();
        if (motivUResultBeans1.size() == 0) {
            MotivUResultBean commercialeResult = new MotivUResultBean();
            commercialeResult.setClient(userConnec.getNum());

            mMotivUProxy.saveClientMotivU(commercialeResult);
        }

        List<MotivUResultBean> motivUResultBean1 = mMotivUProxy.listResultatMotivU();
        boolean userinscrit = false;
        for (MotivUResultBean motivUResultBean : motivUResultBean1) {
            if (motivUResultBean.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                MotivUResultBean motivUResultBean = new MotivUResultBean();
                motivUResultBean.setClient(userConnec.getNum());
                mMotivUProxy.saveClientMotivU(motivUResultBean);
            }
        }

        motivUResultBean = mMotivUProxy.resultClientMotivU(userConnec.getNum()).get();
        int nQuestion = 0;
        nQuestion = motivUResultBean.getQuestion();
        question = mMotivUProxy.questionMotivU(nQuestion).get();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question", question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", motivUResultBean);


        return "questionMotivU";
    }

    @RequestMapping("/saveMotivU")
    public String aveMotivU(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionMotivU";
        }
        UserBean userConnec=userService.getUserConnec();
        double note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "autonomie":
                motivUResultBean.setAutonomie((note+ motivUResultBean.getAutonomie()));break;
            case "challenge":
                motivUResultBean.setChallenge((note+ motivUResultBean.getChallenge()));break;
            case "connaissances":
                motivUResultBean.setConnaissances((note+ motivUResultBean.getConnaissances()));break;
            case "honnetete":
                motivUResultBean.setHonnetete((note+ motivUResultBean.getHonnetete()));break;
            case "mobilite":
                motivUResultBean.setMobilite((note+ motivUResultBean.getMobilite()));break;
            case "personnel":
                motivUResultBean.setPersonnel((note+ motivUResultBean.getPersonnel()));break;
            case "rencontres":
                motivUResultBean.setRencontres((note+ motivUResultBean.getRencontres()));break;
            case "responsabilite":
                motivUResultBean.setResponsabilite((note+ motivUResultBean.getResponsabilite()));break;
            case "retribution":
                motivUResultBean.setRetribution((note+ motivUResultBean.getRetribution()));break;
            case "social":
                motivUResultBean.setSocial((note+ motivUResultBean.getSocial()));break;
            case "statut":
                motivUResultBean.setStatut((note+ motivUResultBean.getStatut()));break;
            case "utilite":
                motivUResultBean.setUtilite((note+ motivUResultBean.getUtilite()));break;


        }

        List<MotivUBean>listQuestion= mMotivUProxy.listQuestionMotivUr();
        if (listQuestion.size()== motivUResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setMotivU(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            mMotivUProxy.saveResutatMotivU(motivUResultBean);

            return "redirect:/listQuestionnaires";
        }

        motivUResultBean.setQuestion(motivUResultBean.getQuestion()+1);
        mMotivUProxy.saveResutatMotivU(motivUResultBean);
        return "redirect:/questionMotivU";
    }

    @RequestMapping(value = "/resultatMotivU")
    public String esultatMotivU(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<MotivUResultBean>resultBean= mMotivUProxy.resultClientMotivU(userConnec.getNum());

        model.addAttribute("result",resultBean.get());


        return "resultMotivU";

    }
}
