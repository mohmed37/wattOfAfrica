package com.client.controler;

import com.client.bean.profilU.*;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MProfilUProxy;
import com.client.proxy.MuserProxy;
import com.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfilUControler {
    @Autowired
    MProfilUProxy mtestsProxy;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IUserService userService;
    @Value("${dir.images}")
    private String imageDir;


    private ResultRaBean resultRaBean;
    private ResultRbBean resultRbBean;
    private ProfiluBean question;
    @RequestMapping("/question")
    public String question(Model model) {
        UserBean userConnec=userService.getUserConnec();

        List<ResultRaBean> lisClient=mtestsProxy.listResultat();
        if (lisClient.size()==0){
            EnregistrmentUserQuestionnaire(userConnec);

        }
        boolean userinscrit = false;
        List<ResultRaBean>lisClient1=mtestsProxy.listResultat();
        for (ResultRaBean lisClientRa:lisClient1) {
            if (lisClientRa.getIdclient().compareTo(userConnec.getNum())==0) {
                userinscrit = true;
                break;
            }
        }
        {
            if(!userinscrit){
                EnregistrmentUserQuestionnaire(userConnec);
            }
        }
        resultRaBean =mtestsProxy.questionClient(userConnec.getNum()).get();
        resultRbBean =mtestsProxy.questionClientRb(userConnec.getNum()).get();

        int nQuestion=0;
        nQuestion= resultRaBean.getQuestion();
        question = mtestsProxy.question(nQuestion).get();

        model.addAttribute("pageQuestion",question);
        model.addAttribute("resultat", resultRaBean);

        return "question";
    }

    private void EnregistrmentUserQuestionnaire(UserBean userConnec) {
        ResultRaBean clientRa=new ResultRaBean();
        ResultRbBean clientRb=new ResultRbBean();
        clientRa.setIdclient(userConnec.getNum());
        clientRb.setIdclient(userConnec.getNum());
        mtestsProxy.saveClientRa(clientRa);
        mtestsProxy.saveClientRb(clientRb);

    }

    @RequestMapping("/save")
    public String save(@Valid @ModelAttribute("resultat") ResultRaBean resultRaBean1 , BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "redirect:/question";
        }

        double dimension = resultRaBean1.getNote();
        switch (question.getDimention()) {
            case "authenticite":resultRaBean.setAuthenticite((dimension+ resultRaBean.getAuthenticite()));break;
            case "strategie":resultRbBean.setStrategie((dimension+ resultRbBean.getStrategie()));break;
            case "tenacite":resultRaBean.setTenacite((dimension+ resultRaBean.getTenacite()));break;
            case "flexibilite":resultRbBean.setFlexibilite((dimension+ resultRbBean.getFlexibilite()));break;
            case "reactivite":resultRaBean.setReactivite((dimension+ resultRaBean.getReactivite()));break;
            case "stabilite":resultRbBean.setStabilite((dimension+ resultRbBean.getStabilite()));break;
            case "introversion":resultRaBean.setIntroversion((dimension+ resultRaBean.getIntroversion()));break;
            case "extraversion":resultRbBean.setExtraversion((dimension+ resultRbBean.getExtraversion()));break;
            case "methode":resultRaBean.setMethode((dimension+ resultRaBean.getMethode()));break;
            case "improvisation":resultRbBean.setImprovisation((dimension+ resultRbBean.getImprovisation()));break;
            case "intuition":resultRaBean.setIntuition((dimension+ resultRaBean.getIntuition()));break;
            case "rationalisme":resultRbBean.setRationalisme((dimension+ resultRbBean.getRationalisme()));break;
            case "nonConformisme":resultRaBean.setNonConformisme((dimension+ resultRaBean.getNonConformisme()));break;
            case "droiture":resultRbBean.setDroiture((dimension+ resultRbBean.getDroiture()));break;
            case "personnelle":resultRaBean.setPersonnelle((dimension+ resultRaBean.getPersonnelle()));break;
            case "professionnelle":resultRbBean.setProfessionnelle((dimension+ resultRbBean.getProfessionnelle()));break;
            case "directive":resultRaBean.setDirective((dimension+ resultRaBean.getDirective()));break;
            case "pouvoir":resultRbBean.setPouvoir((dimension+ resultRbBean.getPouvoir()));break;
            case "reflexion":resultRaBean.setReflexion((dimension+ resultRaBean.getReflexion()));break;
            case "action":resultRbBean.setAction((dimension+ resultRbBean.getAction()));break;
            case "prudence":resultRaBean.setPrudence((dimension+ resultRaBean.getPrudence()));break;
            case "competition":resultRbBean.setCompetition((dimension+ resultRbBean.getCompetition()));break;
            case "gregarite":resultRaBean.setGregarite((dimension+ resultRaBean.getGregarite()));break;
            case "autonomie":resultRbBean.setAutonomie((dimension+ resultRbBean.getAutonomie()));break;
            case "individualisme":resultRaBean.setIndividualisme((dimension+ resultRaBean.getIndividualisme()));break;
            case "altruisme":resultRbBean.setAltruisme((dimension+ resultRbBean.getAltruisme()));break;
            case "traditionnel":resultRaBean.setTraditionnel((dimension+ resultRaBean.getTraditionnel()));break;
            case "exploration":resultRbBean.setExploration((dimension+ resultRbBean.getExploration()));break;

        }

        List<ProfiluBean>listQuestion=mtestsProxy.listDesQuestion();

        if (listQuestion.size()==resultRaBean.getQuestion()||listQuestion.size()==resultRbBean.getQuestion()) {
            mtestsProxy.saveRa(resultRaBean);
            mtestsProxy.saveRb(resultRbBean);
            resultatTestProfilU();
            UserBean userConnec=userService.getUserConnec();
            Optional<QuestionnairesBean> questionnairesBean=muserProxy.questionnairesUser(userConnec.getNum());
            questionnairesBean.get().setProfilU(true);
            muserProxy.updateQuestionnaire(questionnairesBean.get());
            return "redirect:/restitutionProfilU";

        }

        resultRaBean.setQuestion(question.getId()+1);
        resultRbBean.setQuestion(question.getId()+1);
        mtestsProxy.saveRa(resultRaBean);
        mtestsProxy.saveRb(resultRbBean);
        return "redirect:/question";
    }

    @RequestMapping("/restitutionProfilU")
    public String restitutionProfilU(Model model){
        UserBean userConnec=userService.getUserConnec();
        Optional<ResultRbBean> resultRbBean=mtestsProxy.questionClientRb(userConnec.getNum());
        Optional<ResultRaBean> resultRaBean=mtestsProxy.questionClient(userConnec.getNum());
        model.addAttribute("Methode",Math.round(resultRaBean.get().getMethode()));
        model.addAttribute("Authenticite",Math.round(resultRaBean.get().getAuthenticite()));
        model.addAttribute("reactivite",Math.round(resultRaBean.get().getReactivite()));
        model.addAttribute("Intuition",Math.round(resultRaBean.get().getIntuition()));
        model.addAttribute("Introversion",Math.round(resultRaBean.get().getIntroversion()));
        model.addAttribute("Tenacite",Math.round(resultRaBean.get().getTenacite()));
        model.addAttribute("Flexibilite",Math.round(resultRbBean.get().getFlexibilite()));
        model.addAttribute("NonConformisme",Math.round(resultRaBean.get().getNonConformisme()));
        model.addAttribute("Personnelle",Math.round(resultRaBean.get().getPersonnelle()));
        model.addAttribute("Directive",Math.round(resultRaBean.get().getDirective()));
        model.addAttribute("reflexion",Math.round(resultRaBean.get().getReflexion()));
        model.addAttribute("Prudence",Math.round(resultRaBean.get().getPrudence()));
        model.addAttribute("Gregarite",Math.round(resultRaBean.get().getGregarite()));
        model.addAttribute("individualisme",Math.round(resultRaBean.get().getIndividualisme()));
        model.addAttribute("Traditionnel",Math.round(resultRaBean.get().getTraditionnel()));
        model.addAttribute("listRestit",mtestsProxy.findByAll());

        return "resultatTestProfilU";

    }
    @RequestMapping("/restitusion/{id}")
    public String restitusion(Model model,@PathVariable("id") int id){
        model.addAttribute("restitusion",mtestsProxy.findById(id).get());
        return "redirect:/restitutionProfilU";
    }


    private double arrondi(double val) {
        return (Math.floor(val*100+0.5))/100;}



    private void resultatTestProfilU() {

        double ra1 = resultRaBean.getAuthenticite() / 5;
        double rb1 =5-(resultRbBean.getStrategie() / 5);
        resultRaBean.setAuthenticite(ra1 + rb1);
        resultRbBean.setStrategie(10 - (ra1 + rb1));



        double ra2 =  resultRaBean.getTenacite() / 5;
        double rb2 =5 -(resultRbBean.getFlexibilite() / 5);
        resultRaBean.setTenacite(ra2 + rb2);
        resultRbBean.setFlexibilite(10 - (ra2 + rb2));


        double ra3 = resultRaBean.getReactivite()/ 5;
        double rb3 = 5 - (resultRbBean.getStabilite()/ 5);
        resultRaBean.setReactivite(ra3 + rb3);
        resultRbBean.setStabilite(10 - (ra3 + rb3));


        double ra4 = resultRaBean.getIntroversion()/ 5;
        double rb4 = 5 - (resultRbBean.getExtraversion()/ 5);
        resultRaBean.setIntroversion(ra4 + rb4);
        resultRbBean.setExtraversion(10 - (ra4 + rb4));


        double ra5 = resultRaBean.getMethode()/ 5;
        double rb5 = 5 - (resultRbBean.getImprovisation()/ 5);
        resultRaBean.setMethode(ra5 + rb5);
        resultRbBean.setImprovisation(10 - (ra5 + rb5));


        double ra6 = resultRaBean.getIntuition()/ 5;
        double rb6 = 5 - (resultRbBean.getRationalisme()/ 5);
        resultRaBean.setIntuition(ra6 + rb6);
        resultRbBean.setRationalisme(10 - (ra6 + rb6));


        double ra7 =resultRaBean.getNonConformisme()/ 5;
        double rb7 = 5 - (resultRbBean.getDroiture()/ 5);
        resultRaBean.setNonConformisme(ra7 + rb7);
        resultRbBean.setDroiture(10 - (ra7 + rb7));

        double ra8 = resultRaBean.getPersonnelle()/ 5;
        double rb8 = 5 - (resultRbBean.getProfessionnelle()/ 5);
        resultRaBean.setPersonnelle(ra8 + rb8);
        resultRbBean.setProfessionnelle(10 - (ra8 + rb8));


        double ra9 =resultRaBean.getDirective()/ 5;
        double rb9 = 5 - (resultRbBean.getPouvoir()/ 5);
        resultRaBean.setDirective(ra9 + rb9);
        resultRbBean.setPouvoir(10 - (ra9 + rb9));


        double ra10 = resultRaBean.getPrudence()/ 5;
        double rb10 = 5 - (resultRbBean.getCompetition()/ 5);
        resultRaBean.setPrudence(ra10 + rb10);
        resultRbBean.setCompetition(10 - (ra10 + rb10));


        double ra11 = resultRaBean.getGregarite()/ 5;
        double rb11 = 5 - (resultRbBean.getAutonomie()/ 5);
        resultRaBean.setGregarite(ra11 + rb11);
        resultRbBean.setAutonomie(10 - (ra11 + rb11));


        double ra12 = resultRaBean.getIndividualisme()/ 5;
        double rb12 = 5 - (resultRbBean.getAltruisme()/ 5);
        resultRaBean.setIndividualisme(ra12 + rb12);
        resultRbBean.setAltruisme(10 - (ra12 + rb12));

        double ra13 = resultRaBean.getTraditionnel()/ 5;
        double rb13 = 5 - (resultRbBean.getExploration()/ 5);
        resultRaBean.setTraditionnel(ra13 + rb13);
        resultRbBean.setExploration(10 - (ra13 + rb13));

        double ra14 = resultRaBean.getReflexion()/ 5;
        double rb14 = 5 - (resultRbBean.getAction()/ 5);
        resultRaBean.setReflexion(ra14 + rb14);
        resultRbBean.setAction(10 - (ra14 + rb14));

        mtestsProxy.saveRa(resultRaBean);
        mtestsProxy.saveRb(resultRbBean);

    }


}
