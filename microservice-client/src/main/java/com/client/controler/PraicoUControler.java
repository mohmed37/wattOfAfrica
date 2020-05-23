package com.client.controler;

import com.client.bean.praicoU.*;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MPraicoUProxy;
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
public class PraicoUControler {
    @Autowired
    MPraicoUProxy praicoUProxy;
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;


    private ResultPraicoUBean resultPraicoUBean;



    @RequestMapping(value = "/resultPraicoU")
    public String resultPraicoU(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<ResultPraicoUBean>resultRaBean=praicoUProxy.praicoIdClient(userConnec.getNum());
        model.addAttribute("result",resultRaBean.get());
        return "resultatPraicoU";

    }


    @RequestMapping(value = "/Qcm1")
    public String praicoU1(Model model) {

        UserBean userConnec = userService.getUserConnec();
        List<ResultPraicoUBean> listPraico = praicoUProxy.praicoALL();
        if (listPraico.size() == 0) {
            ResultPraicoUBean resultPraicoUBean = new ResultPraicoUBean();
            resultPraicoUBean.setClient(userConnec.getNum());
            praicoUProxy.saveResultPraicoU(resultPraicoUBean);
        }

        boolean userinscrit = false;

        for (ResultPraicoUBean praico:listPraico) {
            if (praico.getClient().compareTo(userConnec.getNum())==0) {
                userinscrit = true;
                break;
            }
        }
            if (!userinscrit) {
                ResultPraicoUBean resultPraicoUBean = new ResultPraicoUBean();
                resultPraicoUBean.setClient(userConnec.getNum());
                praicoUProxy.saveResultPraicoU(resultPraicoUBean);
        }

        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("questionnaire", questionnairesBean.get());
        resultPraicoUBean = praicoUProxy.praicoIdClient(userConnec.getNum()).get();
        int question = resultPraicoUBean.getQcm1();
        Optional<Qcm1Bean> qcm1Bean = praicoUProxy.questionnnaire1(question);
        model.addAttribute("qcm1", qcm1Bean);
        int question2 = resultPraicoUBean.getQcm2();
        Optional<Qcm2Bean> qcm2Bean = praicoUProxy.questionnnaire2(question2);
        model.addAttribute("qcm2", qcm2Bean);
        int question3 = resultPraicoUBean.getQcm3();
        Optional<Qcm3Bean> qcm3Bean = praicoUProxy.questionnnaire3(question3);
        model.addAttribute("qcm3", qcm3Bean);
        List<Qcm4Bean> qcm4Bean = praicoUProxy.questionnnaire4();
        model.addAttribute("qcm4", qcm4Bean);

        return "questionPraicoU";

    }
    @RequestMapping("/saveQcm4")
    public String saveQcm4(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean1, BindingResult bindingResult){

        if ( questionnairesBean1.getResultatString().length()<18){

            return "redirect:/Qcm1";
        }

        if (bindingResult.hasErrors()){
            return "redirect:/Qcm1";
        }

        UserBean userConnec = userService.getUserConnec();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
        questionnairesBean.get().setResultatString(questionnairesBean1.getResultatString());


        if (questionnairesBean.get().getResultatString().contains("a")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'a');
            resultPraicoUBean.setNombreA(resultPraicoUBean.getNombreA()+i);
        }
        if (questionnairesBean.get().getResultatString().contains("i")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'i');
            resultPraicoUBean.setNombreI(resultPraicoUBean.getNombreI()+i);
        }
        if (questionnairesBean.get().getResultatString().contains("c")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'c');
            resultPraicoUBean.setNombreC(resultPraicoUBean.getNombreC()+i);
        }
        if (questionnairesBean.get().getResultatString().contains("o")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'o');
            resultPraicoUBean.setNombreO(resultPraicoUBean.getNombreO()+i);
        }
        if (questionnairesBean.get().getResultatString().contains("p")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'p');
            resultPraicoUBean.setNombreP(resultPraicoUBean.getNombreP()+i);
        }
        if (questionnairesBean.get().getResultatString().contains("r")){
            int i=compteurChar(questionnairesBean1.getResultatString(), 'r');
            resultPraicoUBean.setNombreR(resultPraicoUBean.getNombreR()+i);
        }

        questionnairesBean.get().setQcm4(true);
        muserProxy.updateQuestionnaire(questionnairesBean.get());
        praicoUProxy.modifResultPraicoU(resultPraicoUBean);
        return "redirect:/listQuestionnaires";

    }


    @RequestMapping("/saveQcm1")

    public String saveQcm1(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean1, BindingResult bindingResult){



        UserBean userConnec = userService.getUserConnec();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
       questionnairesBean.get().setResultatString(questionnairesBean1.getResultatString());

        if (bindingResult.hasErrors()){
            return "redirect:/Qcm1";
        }

        if (questionnairesBean.get().getResultatString().contains("a")){
            resultPraicoUBean.setNombreA(resultPraicoUBean.getNombreA()+1);
        }
        if (questionnairesBean.get().getResultatString().contains("i")){
            resultPraicoUBean.setNombreI(resultPraicoUBean.getNombreI()+1);
        }
        if (questionnairesBean.get().getResultatString().contains("c")){
            resultPraicoUBean.setNombreC(resultPraicoUBean.getNombreC()+1);
        }
        if (questionnairesBean.get().getResultatString().contains("o")){
            resultPraicoUBean.setNombreO(resultPraicoUBean.getNombreO()+1);
        }
        if (questionnairesBean.get().getResultatString().contains("p")){
            resultPraicoUBean.setNombreP(resultPraicoUBean.getNombreP()+1);
        }
        if (questionnairesBean.get().getResultatString().contains("r")){
            resultPraicoUBean.setNombreR(resultPraicoUBean.getNombreR()+1);
        }

        if (resultPraicoUBean.getQcm1()==30 && !questionnairesBean.get().getQcm1()){
            questionnairesBean.get().setQcm1(true);
            muserProxy.updateQuestionnaire(questionnairesBean.get());
            praicoUProxy.modifResultPraicoU(resultPraicoUBean);
            return "redirect:/Qcm1";
        }else if (resultPraicoUBean.getQcm1()!=30){
        resultPraicoUBean.setQcm1(resultPraicoUBean.getQcm1()+1);
       }

        if (resultPraicoUBean.getQcm2()==60 && !questionnairesBean.get().getQcm2()){
            questionnairesBean.get().setQcm2(true);
            muserProxy.updateQuestionnaire(questionnairesBean.get());
            praicoUProxy.modifResultPraicoU(resultPraicoUBean);
            return "redirect:/Qcm1";
        }else if (resultPraicoUBean.getQcm2()!=60 && questionnairesBean.get().getQcm1()){
            resultPraicoUBean.setQcm2(resultPraicoUBean.getQcm2()+1);
        }

        if (resultPraicoUBean.getQcm3()==60 && !questionnairesBean.get().getQcm3()){
            questionnairesBean.get().setQcm3(true);
            muserProxy.updateQuestionnaire(questionnairesBean.get());
            praicoUProxy.modifResultPraicoU(resultPraicoUBean);
            return "redirect:/Qcm1";
        }else if (resultPraicoUBean.getQcm3()!=60 && questionnairesBean.get().getQcm2()){
            resultPraicoUBean.setQcm3(resultPraicoUBean.getQcm3()+1);
        }


        praicoUProxy.modifResultPraicoU(resultPraicoUBean);
        return "redirect:/Qcm1";
    }

    private int compteurChar(String str, char ch) {

        int compteur = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                compteur++;
        return compteur;
    }


}
