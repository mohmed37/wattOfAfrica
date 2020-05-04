package com.client.controler;

import com.client.bean.comU.ComUBean;
import com.client.bean.comU.ComUResultBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MComUProxy;
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
public class ComUControler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MComUProxy mComUProxy;

    private ComUResultBean comUResultBean;
    private ComUBean question;
    @RequestMapping("/questionComU")
    public String questionComU(Model model) {
        UserBean userConnec=userService.getUserConnec();

        List<ComUResultBean> listResultatEmoU=mComUProxy.listResultatComU();
        if (listResultatEmoU.size()==0){
            ComUResultBean comUResultBean=new ComUResultBean();
            comUResultBean.setClient(userConnec.getNum());

            mComUProxy.saveClientComU(comUResultBean);
        }
        List<ComUResultBean> lisClientComU2=mComUProxy.listResultatComU();
        boolean userinscrit = false;
        for (ComUResultBean clientEmoU : lisClientComU2) {
            if (clientEmoU.getClient().compareTo(userConnec.getNum())==0) {
                userinscrit = true;
                break;
            }
        }
        {
            if(!userinscrit){
                ComUResultBean comUResultBean=new ComUResultBean();
                comUResultBean.setClient(userConnec.getNum());
                mComUProxy.saveClientComU(comUResultBean);
            }
        }

        comUResultBean=mComUProxy.resultClientComU(userConnec.getNum()).get();
        int nQuestion=0;
        nQuestion= comUResultBean.getQuestion();
        question = mComUProxy.questionComU(nQuestion).get();
        Optional<QuestionnairesBean> questionnairesBean=muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question",question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result",comUResultBean);


        return "questionComU";
    }


    @RequestMapping("/saveComU")
    public String saveComU(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionComU";
        }
        UserBean userConnec=userService.getUserConnec();
        double note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "autorite":comUResultBean.setAutorite((note+ comUResultBean.getAutorite()));break;
            case "ecoute":comUResultBean.setEcoute((note+ comUResultBean.getEcoute()));break;
            case "encensement":comUResultBean.setEncensement((note+ comUResultBean.getEncensement()));break;
            case "expression":comUResultBean.setExpression((note+ comUResultBean.getExpression()));break;
            case "nonverbal":comUResultBean.setNonverbal((note+ comUResultBean.getNonverbal()));break;
            case "observation":comUResultBean.setObservation((note+ comUResultBean.getObservation()));break;
            case "persuasion":comUResultBean.setPersuasion((note+ comUResultBean.getPersuasion()));break;
            case "pression":comUResultBean.setPression((note+ comUResultBean.getPression()));break;
            case "rationalite":comUResultBean.setRationalite((note+ comUResultBean.getRationalite()));break;
            case "redactionnelle":comUResultBean.setRedactionnelle((note+ comUResultBean.getRedactionnelle()));break;
            case "reserve":comUResultBean.setReserve((note+ comUResultBean.getReserve()));break;
            case "sympathie":comUResultBean.setSympathie((note+ comUResultBean.getSympathie()));break;

        }

        List<ComUBean>listQuestion=mComUProxy.listQuestionComU();
        if (listQuestion.size()==comUResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setComU(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            mComUProxy.saveResutatComU(comUResultBean);

            return "redirect:/listQuestionnaires";
        }

        comUResultBean.setQuestion(comUResultBean.getQuestion()+1);
        mComUProxy.saveResutatComU(comUResultBean);




        return "redirect:/questionComU";

    }
    @RequestMapping(value = "/resultatComU")
    public String resultatComU(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<ComUResultBean>resultBean=mComUProxy.resultClientComU(userConnec.getNum());
        model.addAttribute("result",resultBean.get());

        return "resultatComU";

    }


}
