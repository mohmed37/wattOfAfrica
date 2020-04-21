package com.client.controler;



import com.client.bean.ProfiluBean;
import com.client.bean.ResultRaBean;
import com.client.bean.ResultRbBean;
import com.client.proxy.MtestsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ClientController {

    @Autowired
    MtestsProxy mtestsProxy;




    @Value("${dir.images}")
    private String imageDir;






    @RequestMapping("/")
    public String accueil(Model model){
        List<ProfiluBean>questionsList=mtestsProxy.listDesQuestion();
        model.addAttribute("listQuestion",questionsList);

        return "profil";
    }

    private ResultRaBean resultRaBean;
    private ResultRbBean resultRbBean;
    private ProfiluBean question;
    @RequestMapping("/question")
    public String question(Model model) {
        resultRaBean =mtestsProxy.questionClient(1).get();
        int nQuestion=0;
              nQuestion= resultRaBean.getQuestion()+1;
        question = mtestsProxy.question(nQuestion).get();

        model.addAttribute("pageQuestion",question);
        model.addAttribute("resultat", resultRaBean);

                   return "question";
    }

   @RequestMapping("/save")
   public String save(@Valid @ModelAttribute("resultat") ResultRaBean resultRaBean1){

       double dimension = resultRaBean1.getNote();

       switch (question.getDimention()) {
           case "authenticite":resultRaBean.setAuthenticite((dimension+ resultRaBean.getAuthenticite()));break;
           case "strategie":resultRbBean.setStrategie((dimension+ resultRbBean.getStrategie()));break;
           case "tenacite":resultRaBean.setTenacite((dimension+ resultRaBean.getTenacite()));break;
           case "flexibilite":resultRbBean.setFlexibilite((dimension+ resultRbBean.getFlexibilite()));break;
           case "reactivite":resultRaBean.setReactivite((dimension+ resultRaBean.getReactivite()));break;
           case "stabilite":resultRbBean.setStabilite((dimension+ resultRbBean.getStabilite()));break;
           case "introversion":resultRaBean.setIntroversion((dimension+ resultRaBean.getIntroversion()));break;
           case "extraversion":resultRbBean.setExploration((dimension+ resultRbBean.getExtraversion()));break;
           case "methode":resultRaBean.setMethode((dimension+ resultRaBean.getMethode()));break;
           case "improvisation":resultRbBean.setImprovisation((dimension+ resultRbBean.getImprovisation()));break;
           case "intuition":resultRaBean.setIntuition((dimension+ resultRaBean.getIntuition()));break;
           case "rationalisme":resultRbBean.setRationalisme((dimension+ resultRbBean.getRationalisme()));break;
           case "nonConformisme":resultRaBean.setNonConformisme((dimension+ resultRaBean.getNonConformisme()));break;
           case "droiture":resultRbBean.setDroiture((dimension+ resultRbBean.getDroiture()));break;
           case "personnelle":resultRaBean.setPersonnelle((dimension+ resultRaBean.getPersonnelle()));break;
           case "professionnelle":resultRbBean.setProfessionnelle((dimension+ resultRbBean.getProfessionnelle()));break;
           case "directive":resultRaBean.setDirective((dimension+ resultRaBean.getDirective()));break;
           case "Pouvoir":resultRbBean.setPouvoir((dimension+ resultRbBean.getPouvoir()));break;
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
           return "redirect:/resultatTestProfilU";

       }
       resultRaBean1.setQuestion(question.getId()+1);
       mtestsProxy.saveRa(resultRaBean);
       mtestsProxy.saveRb(resultRbBean);
      return "redirect:/question";
    }

    @RequestMapping("/resultatTestProfilU")
    public String resultatTestProfilU(Model model) {

        double ra1 = 5 - (resultRaBean.getAuthenticite() / 5);
        double rb1 = resultRbBean.getStrategie() / 5;
        resultRaBean.setAuthenticite(ra1 + rb1);
        resultRbBean.setStrategie(10 - (ra1 + rb1));
        model.addAttribute("Authenticite",resultRaBean.getAuthenticite());
        model.addAttribute("Strategie",resultRbBean.getStrategie());

        double ra2 = 5 - (resultRaBean.getTenacite() / 5);
        double rb2 = resultRbBean.getFlexibilite() / 5;
        resultRaBean.setTenacite(ra2 + rb2);
        resultRbBean.setFlexibilite(10 - (ra2 + rb2));
        model.addAttribute("Tenacite",resultRaBean.getTenacite());
        model.addAttribute("Flexibilite",resultRbBean.getFlexibilite());

        double ra3 = 5 - (resultRaBean.getReactivite()/ 5);
        double rb3 = resultRbBean.getStabilite()/ 5;
        resultRaBean.setReactivite(ra3 + rb3);
        resultRbBean.setStabilite(10 - (ra3 + rb3));
        model.addAttribute("Reactivite",resultRaBean.getReactivite());
        model.addAttribute("Stabilite",resultRbBean.getStabilite());

        double ra4 = 5 - (resultRaBean.getIntroversion()/ 5);
        double rb4 = resultRbBean.getExtraversion()/ 5;
        resultRaBean.setIntroversion(ra4 + rb4);
        resultRbBean.setExtraversion(10 - (ra4 + rb4));
        model.addAttribute("Introversion",resultRaBean.getIntroversion());
        model.addAttribute("Extraversion",resultRbBean.getExtraversion());

        double ra5 = 5 - (resultRaBean.getMethode()/ 5);
        double rb5 = resultRbBean.getImprovisation()/ 5;
        resultRaBean.setMethode(ra5 + rb5);
        resultRbBean.setImprovisation(10 - (ra5 + rb5));
        model.addAttribute("Methode",resultRaBean.getMethode());
        model.addAttribute("Improvisation",resultRbBean.getImprovisation());

        double ra6 = 5 - (resultRaBean.getIntuition()/ 5);
        double rb6 = resultRbBean.getRationalisme()/ 5;
        resultRaBean.setIntuition(ra6 + rb6);
        resultRbBean.setRationalisme(10 - (ra6 + rb6));
        model.addAttribute("Intuition",resultRaBean.getIntuition());
        model.addAttribute("Rationalisme",resultRbBean.getRationalisme());

        double ra7 = 5 - (resultRaBean.getNonConformisme()/ 5);
        double rb7 = resultRbBean.getDroiture()/ 5;
        resultRaBean.setNonConformisme(ra7 + rb7);
        resultRbBean.setDroiture(10 - (ra7 + rb7));
        model.addAttribute("NonConformisme",resultRaBean.getNonConformisme());
        model.addAttribute("Droiture",resultRbBean.getDroiture());

        double ra8 = 5 - (resultRaBean.getPersonnelle()/ 5);
        double rb8 = resultRbBean.getProfessionnelle()/ 5;
        resultRaBean.setPersonnelle(ra8 + rb8);
        resultRbBean.setProfessionnelle(10 - (ra8 + rb8));
        model.addAttribute("Personnelle",resultRaBean.getPersonnelle());
        model.addAttribute("Professionnelle",resultRbBean.getProfessionnelle());

        double ra9 = 5 - (resultRaBean.getDirective()/ 5);
        double rb9 = resultRbBean.getPouvoir()/ 5;
        resultRaBean.setDirective(ra9 + rb9);
        resultRbBean.setPouvoir(10 - (ra9 + rb9));
        model.addAttribute("Directive",resultRaBean.getDirective());
        model.addAttribute("Pouvoir",resultRbBean.getPouvoir());

        double ra10 = 5 - (resultRaBean.getPrudence()/ 5);
        double rb10 = resultRbBean.getCompetition()/ 5;
        resultRaBean.setPrudence(ra10 + rb10);
        resultRbBean.setCompetition(10 - (ra10 + rb10));
        model.addAttribute("Prudence",resultRaBean.getPrudence());
        model.addAttribute("Competition",resultRbBean.getCompetition());

        double ra11 = 5 - (resultRaBean.getGregarite()/ 5);
        double rb11 = resultRbBean.getAutonomie()/ 5;
        resultRaBean.setGregarite(ra11 + rb11);
        resultRbBean.setAutonomie(10 - (ra11 + rb11));
        model.addAttribute("Gregarite",resultRaBean.getGregarite());
        model.addAttribute("Autonomie",resultRbBean.getAutonomie());

        double ra12 = 5 - (resultRaBean.getIndividualisme()/ 5);
        double rb12 = resultRbBean.getAltruisme()/ 5;
        resultRaBean.setIndividualisme(ra12 + rb12);
        resultRbBean.setAltruisme(10 - (ra12 + rb12));
        model.addAttribute("Gregarite",resultRaBean.getIndividualisme());
        model.addAttribute("Autonomie",resultRbBean.getAltruisme());

        double ra13 = 5 - (resultRaBean.getTraditionnel()/ 5);
        double rb13 = resultRbBean.getExploration()/ 5;
        resultRaBean.setTraditionnel(ra13 + rb13);
        resultRbBean.setExploration(10 - (ra13 + rb13));
        model.addAttribute("Traditionnel",resultRaBean.getTraditionnel());
        model.addAttribute("Exploration",resultRbBean.getExploration());

        return "resultatTestProfilU";
    }
    }
