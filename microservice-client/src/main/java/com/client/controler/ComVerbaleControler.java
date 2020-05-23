package com.client.controler;


import com.client.bean.compVerbale.CompVerbale1Bean;
import com.client.bean.compVerbale.CompVerbale2Bean;
import com.client.bean.compVerbale.CompVerbale3Bean;
import com.client.bean.compVerbale.VerbaleResultBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MCompVerbaleProxy;
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
public class ComVerbaleControler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MCompVerbaleProxy mCompVerbaleProxy;

    private VerbaleResultBean verbaleResultBean;
    private CompVerbale1Bean question1;
    private CompVerbale2Bean question2;
    private CompVerbale3Bean question3;
    @RequestMapping("/questionVerbale")
    public String questionComU(Model model) {
        UserBean userConnec = userService.getUserConnec();

        List<VerbaleResultBean> listResultatVerbale = mCompVerbaleProxy.listVerbaleAll();
        if (listResultatVerbale.size() == 0) {
            VerbaleResultBean comUResultBean = new VerbaleResultBean();
            comUResultBean.setClient(userConnec.getNum());

            mCompVerbaleProxy.saveVerbale(comUResultBean);
        }
        List<VerbaleResultBean> lisClientComU2 = mCompVerbaleProxy.listVerbaleAll();
        boolean userinscrit = false;
        for (VerbaleResultBean clientEmoU : lisClientComU2) {
            if (clientEmoU.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                VerbaleResultBean comUResultBean = new VerbaleResultBean();
                comUResultBean.setClient(userConnec.getNum());
                mCompVerbaleProxy.saveVerbale(comUResultBean);
            }
        }

        verbaleResultBean = mCompVerbaleProxy.resultatVerbaleClient(userConnec.getNum()).get();
        int nQuestion = 0;
        nQuestion = verbaleResultBean.getQuestion();

        if (!verbaleResultBean.getExercice1()){
        question1 = mCompVerbaleProxy.exercice1(nQuestion).get();
        model.addAttribute("question1", question1);}

        if (verbaleResultBean.getExercice1()&!verbaleResultBean.getExercice2()){
            question2 = mCompVerbaleProxy.exercice2(nQuestion).get();
            model.addAttribute("question2", question2);
        }
       if (verbaleResultBean.getExercice2()){
           question3 = mCompVerbaleProxy.exercice3(nQuestion).get();
           model.addAttribute("question3", question3);
       }


        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", verbaleResultBean);
        return "questionVerbale";
    }

    @RequestMapping("/saveVerbale")
    public String saveComU(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionComU";
        }
        UserBean userConnec=userService.getUserConnec();
        String reponse =questionnairesBean.getResultatString();

        if (!verbaleResultBean.getExercice1()){
        if (question1.getSolution().equals(reponse)){
            verbaleResultBean.setResultat(verbaleResultBean.getResultat()+1);
           }}
        if (verbaleResultBean.getExercice1()&!verbaleResultBean.getExercice2()){
            if (question2.getSolution().equals(reponse)){
                verbaleResultBean.setResultat(verbaleResultBean.getResultat()+1);
                }
        }
        if (verbaleResultBean.getExercice2()){
            if (question3.getSolution().equals(reponse)){
                verbaleResultBean.setResultat(verbaleResultBean.getResultat()+1);
                }
        }



        if (mCompVerbaleProxy.exercice1All().size()==verbaleResultBean.getQuestion()) {
            verbaleResultBean.setExercice1(true);
            verbaleResultBean.setQuestion(1);
            mCompVerbaleProxy.changeVerbale(verbaleResultBean);

            return "redirect:/questionVerbale";
        }
        if (mCompVerbaleProxy.exercice2All().size()==verbaleResultBean.getQuestion() & verbaleResultBean.getExercice1()) {
            verbaleResultBean.setExercice2(true);
            verbaleResultBean.setQuestion(1);
            mCompVerbaleProxy.changeVerbale(verbaleResultBean);
            return "redirect:/questionVerbale";
        }

        if (mCompVerbaleProxy.exercice3All().size()==verbaleResultBean.getQuestion()& verbaleResultBean.getExercice2()) {
            mCompVerbaleProxy.changeVerbale(verbaleResultBean);
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setCompVerbale(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            return "redirect:/listQuestionnaires";
        }

        verbaleResultBean.setQuestion(verbaleResultBean.getQuestion()+1);
        mCompVerbaleProxy.changeVerbale(verbaleResultBean);
        return "redirect:/questionVerbale";

    }

    @RequestMapping(value = "/resultatVerbale")
    public String resultatVerbale(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<VerbaleResultBean>resultVerbale=mCompVerbaleProxy.resultatVerbaleClient(userConnec.getNum());
        model.addAttribute("resultVerbale",resultVerbale.get());
        return "resultVerbale";

    }

}
