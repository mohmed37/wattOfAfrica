package com.client.controler;

import com.client.bean.emoU.EmoUResultBean;
import com.client.bean.emoU.EmoUbean;

import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MEmoUProxy;
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
public class EmoUControler {
    @Autowired
    MEmoUProxy mEmoUProxy;
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;

   private EmoUResultBean emoUResultBean;
   private EmoUbean question;
    @RequestMapping("/questionEmoU")
    public String questionEmoU(Model model) {
        UserBean userConnec=userService.getUserConnec();

        List<EmoUResultBean> lisClientEmoU=mEmoUProxy.listResultatEmoU();
        if (lisClientEmoU.size()==0){
            EmoUResultBean emoUResultBean=new EmoUResultBean();
            emoUResultBean.setClient(userConnec.getNum());

            mEmoUProxy.saveClientEmoU(emoUResultBean);
        }
        List<EmoUResultBean> lisClientEmoU2=mEmoUProxy.listResultatEmoU();
        boolean userinscrit = false;
        for (EmoUResultBean clientEmoU : lisClientEmoU2) {
            if (clientEmoU.getClient().compareTo(userConnec.getNum())==0) {
                userinscrit = true;
                break;
            }
        }
        {
            if(!userinscrit){
                EmoUResultBean emoUResultBean=new EmoUResultBean();
                emoUResultBean.setClient(userConnec.getNum());
                mEmoUProxy.saveClientEmoU(emoUResultBean);
            }
        }

        emoUResultBean=mEmoUProxy.resultClientEmoU(userConnec.getNum()).get();
        int nQuestion=0;
        nQuestion= emoUResultBean.getQuestion();
        question = mEmoUProxy.questionEmoU(nQuestion).get();
       Optional<QuestionnairesBean> questionnairesBean=muserProxy.questionnairesUser(userConnec.getNum());

        model.addAttribute("question",question);
        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result",emoUResultBean);


        return "questionEmoU";
    }


    @RequestMapping("/saveEmoU")
    public String saveEmoU(@Valid @ModelAttribute("questionnaire") QuestionnairesBean questionnairesBean , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/questionEmoU";
        }
        UserBean userConnec=userService.getUserConnec();
        double note =questionnairesBean.getResultatInteger();
        switch (question.getDimension()) {
            case "adaptabilite":emoUResultBean.setAdaptabilite((note+ emoUResultBean.getAdaptabilite()));break;
            case "assertivite":emoUResultBean.setAssertivite((note+ emoUResultBean.getAssertivite()));break;
            case "automotivation":emoUResultBean.setAutomotivation((note+ emoUResultBean.getAutomotivation()));break;
            case "confiance":emoUResultBean.setConfiance((note+ emoUResultBean.getConfiance()));break;
            case "empathie":emoUResultBean.setEmpathie((note+ emoUResultBean.getEmpathie()));break;
            case "connaissance":emoUResultBean.setConnaissance((note+ emoUResultBean.getConnaissance()));break;
            case "estime":emoUResultBean.setEstime((note+ emoUResultBean.getEstime()));break;
            case "influence":emoUResultBean.setInfluence((note+ emoUResultBean.getInfluence()));break;
            case "maitrise":emoUResultBean.setMaitrise((note+ emoUResultBean.getMaitrise()));break;
            case "optimisme":emoUResultBean.setOptimisme((note+ emoUResultBean.getOptimisme()));break;
            case "relationnelle":emoUResultBean.setRelationnelle((note+ emoUResultBean.getRelationnelle()));break;
            case "resilience":emoUResultBean.setResilience((note+ emoUResultBean.getResilience()));break;

        }

        List<EmoUbean>listQuestion=mEmoUProxy.listQuestionEmoU();
        if (listQuestion.size()==emoUResultBean.getQuestion()) {
            Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean1.get().setEmoU(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
           mEmoUProxy.saveResutatEmoU(emoUResultBean);

            return "redirect:/listQuestionnaires";
        }

        emoUResultBean.setQuestion(emoUResultBean.getQuestion()+1);
        mEmoUProxy.saveResutatEmoU(emoUResultBean);




        return "redirect:/questionEmoU";

    }
    @RequestMapping(value = "/resultatEmoU")
    public String resultatEmoU(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<EmoUResultBean>resultBean=mEmoUProxy.resultClientEmoU(userConnec.getNum());
        model.addAttribute("result",resultBean.get());

        return "resultatEmoU";

    }

}
