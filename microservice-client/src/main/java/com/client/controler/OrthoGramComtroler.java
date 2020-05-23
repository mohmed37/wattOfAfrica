package com.client.controler;



import com.client.bean.orthogram.*;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MOrthoGramProxy;
import com.client.proxy.MuserProxy;
import com.client.service.CustomTimer;
import com.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class OrthoGramComtroler {
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MOrthoGramProxy mOrthoGramProxy;

    private OrthographeResultBean orthographeResultBean;
    private Orthographe1Bean question1;
    private Orthographe2Bean question2;
    private Grammaire1Bean question3;
    private Grammaire2Bean question4;





    @RequestMapping("/questionOrthoGram")
    public String questionOrtho(Model model) throws InterruptedException {
        UserBean userConnec = userService.getUserConnec();

        List<OrthographeResultBean> orthoResultBeans1 = mOrthoGramProxy.listResultatOrtho();
        if (orthoResultBeans1.size() == 0) {
            OrthographeResultBean orthoResult = new OrthographeResultBean();
            orthoResult.setClient(userConnec.getNum());
            mOrthoGramProxy.saveClientPerso(orthoResult);
        }

        List<OrthographeResultBean> orthoResultBean1 = mOrthoGramProxy.listResultatOrtho();
        boolean userinscrit = false;
        for (OrthographeResultBean orthographeResultBean : orthoResultBean1) {
            if (orthographeResultBean.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                OrthographeResultBean orthoResult = new OrthographeResultBean();
                orthoResult.setClient(userConnec.getNum());
                mOrthoGramProxy.saveClientPerso(orthoResult);
            }
        }

        orthographeResultBean = mOrthoGramProxy.resultClientOrtho(userConnec.getNum()).get();
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());

        int nQuestion = 0;
        nQuestion = orthographeResultBean.getQuestion();
        orthographeResultBean.setQuestionPasse(orthographeResultBean.getQuestionPasse()+1);
        mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);

        if (!questionnairesBean.get().getOrtho()){
        question1 = mOrthoGramProxy.questionOrtho1(nQuestion).get();
         model.addAttribute("question1", question1);
         List<Orthographe1Bean> listQuestionOrtho1 = mOrthoGramProxy.listQuestionOrtho1();
         model.addAttribute("questionMax",listQuestionOrtho1.size());

        if(orthographeResultBean.getExerciceOrtho1()){
        question2 = mOrthoGramProxy.questionOrtho2(nQuestion).get();
        model.addAttribute("question2", question2);
       List<Orthographe2Bean> listQuestionOrtho2 = mOrthoGramProxy.listQuestionOrtho2();
            model.addAttribute("questionMax",listQuestionOrtho2.size());
        }
       }

        if (questionnairesBean.get().getOrtho()){
            question3=mOrthoGramProxy.questionGram1(nQuestion).get();
            model.addAttribute("question3", question3);
            List<Grammaire1Bean> listQuestionGram1 = mOrthoGramProxy.listQuestionGram1();
            model.addAttribute("questionMax",listQuestionGram1.size());


        if (orthographeResultBean.getExerciceGram1()){
            question4=mOrthoGramProxy.questionGram2(nQuestion).get();
            model.addAttribute("question4", question4);
            List<Grammaire2Bean> listQuestionGram2 = mOrthoGramProxy.listQuestionGram2();
            model.addAttribute("questionMax",listQuestionGram2.size());
        }}

        model.addAttribute("questionnaire", questionnairesBean.get());
        model.addAttribute("result", orthographeResultBean);


        return "questionOrthoGram";
    }

    @RequestMapping("/saveOrthoGram/{reponse}")
    public String saveOrthoGram(@PathVariable("reponse") String reponse){

        UserBean userConnec=userService.getUserConnec();
        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
if (!questionnairesBean1.get().getOrtho()) {
    List<Orthographe1Bean> listQuestionOrtho1 = mOrthoGramProxy.listQuestionOrtho1();
    if (!orthographeResultBean.getExerciceOrtho1()) {
        if (question1.getSolution().equals(reponse)) {
            orthographeResultBean.setScoreOrtho(orthographeResultBean.getScoreOrtho() + 1);
        }

    }
    if (orthographeResultBean.getExerciceOrtho1()) {
        if (question2.getSolution().equals(reponse)) {
            orthographeResultBean.setScoreOrtho(orthographeResultBean.getScoreOrtho() + 1);
        }
    }
    if (listQuestionOrtho1.size() == orthographeResultBean.getQuestion()) {
        orthographeResultBean.setExerciceOrtho1(true);
        orthographeResultBean.setQuestion(1);
        orthographeResultBean.setQuestionPasse(0);
        mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);
        return "redirect:/questionOrthoGram";
    }

    List<Orthographe2Bean> listQuestionOrtho2 = mOrthoGramProxy.listQuestionOrtho2();
    if (listQuestionOrtho2.size() == orthographeResultBean.getQuestion() & orthographeResultBean.getExerciceOrtho1()) {
        questionnairesBean1.get().setOrtho(true);
        muserProxy.updateQuestionnaire(questionnairesBean1.get());
        orthographeResultBean.setQuestion(1);
        orthographeResultBean.setQuestionPasse(0);
        mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);

        return "redirect:/questionOrthoGram";
    }
}

       if (questionnairesBean1.get().getOrtho()) {

           List<Grammaire1Bean> listQuestionGram1 = mOrthoGramProxy.listQuestionGram1();

           if (!orthographeResultBean.getExerciceGram1()) {
               if (question3.getSolution().equals(reponse)) {
                   orthographeResultBean.setScoreGram1(orthographeResultBean.getScoreGram1() + 1);
               }

           }
           if (orthographeResultBean.getExerciceGram1()) {
               if (question4.getSolution().equals(reponse)) {
                   orthographeResultBean.setScoreGram1(orthographeResultBean.getScoreGram1() + 1);
               }
           }

           if (listQuestionGram1.size() == orthographeResultBean.getQuestion()) {
               orthographeResultBean.setExerciceGram1(true);
               orthographeResultBean.setQuestion(1);
               orthographeResultBean.setQuestionPasse(0);
               mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);
               return "redirect:/questionOrthoGram";
           }


           List<Grammaire2Bean> listQuestionGram2 = mOrthoGramProxy.listQuestionGram2();
           if (listQuestionGram2.size() == orthographeResultBean.getQuestion() & orthographeResultBean.getExerciceGram1()) {
               questionnairesBean1.get().setGrammaire(true);
               muserProxy.updateQuestionnaire(questionnairesBean1.get());
               orthographeResultBean.setQuestion(1);
               orthographeResultBean.setQuestionPasse(0);
               mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);

               return "redirect:/resultatOrthoGram";
           }

       }

        if (!orthographeResultBean.getQuestion().equals(orthographeResultBean.getQuestionPasse())){
            orthographeResultBean.setQuestionPasse(orthographeResultBean.getQuestionPasse()-1);
        }
        orthographeResultBean.setQuestion(orthographeResultBean.getQuestion()+1);
        mOrthoGramProxy.saveResutatOrtho(orthographeResultBean);

        return "redirect:/questionOrthoGram";
    }

    @RequestMapping(value = "/resultatOrthoGram")
    public String resultatOrtho(Model model) {

        UserBean userConnec = userService.getUserConnec();
        Optional<OrthographeResultBean>resultBean= mOrthoGramProxy.resultClientOrtho(userConnec.getNum());
        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("result",resultBean.get());

        model.addAttribute("questionnaires",questionnairesBean1.get());

        return "resultOrthoGram";}




}
