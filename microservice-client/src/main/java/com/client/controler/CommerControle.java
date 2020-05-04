package com.client.controler;

import com.client.bean.commerciale.CommercialeBean;
import com.client.bean.commerciale.CommercialeResultBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MCommerProxy;
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
public class CommerControle {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MCommerProxy mCommerProxy;

    private CommercialeResultBean commercialeResultBean;
    private CommercialeBean question;

    @RequestMapping("/questionCommercial")
    public String questionEntrepreneur(Model model) {
        UserBean userConnec = userService.getUserConnec();

        List<CommercialeResultBean> entreprResultBeans1 = mCommerProxy.listResultatCommercial();
        if (entreprResultBeans1.size() == 0) {
            CommercialeResultBean commercialeResult = new CommercialeResultBean();
            commercialeResult.setClient(userConnec.getNum());

            mCommerProxy.saveClientCom(commercialeResult);
        }

        List<CommercialeResultBean> commercialeResultBeans = mCommerProxy.listResultatCommercial();
        boolean userinscrit = false;
        for (CommercialeResultBean commercialeResultBean : commercialeResultBeans) {
            if (commercialeResultBean.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                CommercialeResultBean commercialeResultBean1 = new CommercialeResultBean();
                commercialeResultBean1.setClient(userConnec.getNum());
                mCommerProxy.saveClientCom(commercialeResultBean1);
            }
        }

        commercialeResultBean = mCommerProxy.resultClientCom(userConnec.getNum()).get();
        int nQuestion = 0;
        nQuestion = commercialeResultBean.getQuestion();
        question = mCommerProxy.questionCommercial(nQuestion).get();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question", question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", commercialeResultBean);


        return "questionCommercial";
    }

    @RequestMapping("/saveCommercial")
    public String saveCommercial(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionCommercial";
        }
        UserBean userConnec=userService.getUserConnec();
        double note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "affirmation":
                commercialeResultBean.setAffirmation((note+ commercialeResultBean.getAffirmation()));break;
            case "approche":
                commercialeResultBean.setApproche((note+ commercialeResultBean.getApproche()));break;
            case "argumentations":
                commercialeResultBean.setArgumentations((note+ commercialeResultBean.getArgumentations()));break;
            case "combativite":
                commercialeResultBean.setCombativite((note+ commercialeResultBean.getCombativite()));break;
            case "comprehension":
                commercialeResultBean.setComprehension((note+ commercialeResultBean.getComprehension()));break;
            case "controle":
                commercialeResultBean.setControle((note+ commercialeResultBean.getControle()));break;
            case "jeu":
                commercialeResultBean.setJeu((note+ commercialeResultBean.getJeu()));break;
            case "prospection":
                commercialeResultBean.setProspection((note+ commercialeResultBean.getProspection()));break;
            case "reseau":
                commercialeResultBean.setReseau((note+ commercialeResultBean.getReseau()));break;
            case "satisfaction":
                commercialeResultBean.setSatisfaction((note+ commercialeResultBean.getSatisfaction()));break;
            case "strategiques":
                commercialeResultBean.setStrategiques((note+ commercialeResultBean.getStrategiques()));break;

        }

        List<CommercialeBean>listQuestion= mCommerProxy.listQuestionCommercial();
        if (listQuestion.size()== commercialeResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setCommercial(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            mCommerProxy.saveResutatCom(commercialeResultBean);

            return "redirect:/listQuestionnaires";
        }

        commercialeResultBean.setQuestion(commercialeResultBean.getQuestion()+1);
        mCommerProxy.saveResutatCom(commercialeResultBean);
        return "redirect:/questionCommercial";
    }

    @RequestMapping(value = "/resultatCommercial")
    public String resultatCommercial(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<CommercialeResultBean>resultBean= mCommerProxy.resultClientCom(userConnec.getNum());

        model.addAttribute("result",resultBean.get());


        return "resultatCommercial";

    }
}
