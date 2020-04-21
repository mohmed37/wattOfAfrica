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
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;


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
        resultRbBean =mtestsProxy.questionClientRb(1).get();
        if (resultRaBean.getQuestion()==140){
            resultatTestProfilU();
            return "redirect:/restitutionProfilU";
        }

        int nQuestion=0;
              nQuestion= resultRaBean.getQuestion();
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
           case "pouvoir":resultRbBean.setPouvoir((dimension+ resultRbBean.getPouvoir()));break;
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
           return "redirect:/CalculTestProfilU";

       }

       resultRaBean.setQuestion(question.getId()+1);
       resultRbBean.setQuestion(question.getId()+1);
       mtestsProxy.saveRa(resultRaBean);
       mtestsProxy.saveRb(resultRbBean);
      return "redirect:/question";
    }

    @RequestMapping("/restitutionProfilU")
    public String restitutionProfilU(Model model){

        Optional<ResultRbBean> resultRbBean=mtestsProxy.questionClientRb(1);
        Optional<ResultRaBean> resultRaBean=mtestsProxy.questionClient(1);
        model.addAttribute("Authenticite",arrondi(resultRaBean.get().getAuthenticite()));
        model.addAttribute("Strategie",arrondi(resultRbBean.get().getStrategie()));
        model.addAttribute("Tenacite",arrondi(resultRaBean.get().getTenacite()));
        model.addAttribute("Flexibilite",arrondi(resultRbBean.get().getFlexibilite()));
        model.addAttribute("Reactivite",arrondi(resultRaBean.get().getReactivite()));
        model.addAttribute("Stabilite",arrondi(resultRbBean.get().getStabilite()));
        model.addAttribute("Introversion",arrondi(resultRaBean.get().getIntroversion()));
        model.addAttribute("Extraversion",arrondi(resultRbBean.get().getExtraversion()));
        model.addAttribute("Methode",arrondi(resultRaBean.get().getMethode()));
        model.addAttribute("Improvisation",arrondi(resultRbBean.get().getImprovisation()));
        model.addAttribute("Intuition",arrondi(resultRaBean.get().getIntuition()));
        model.addAttribute("Rationalisme",arrondi(resultRbBean.get().getRationalisme()));
        model.addAttribute("NonConformisme",arrondi(resultRaBean.get().getNonConformisme()));
        model.addAttribute("Droiture",arrondi(resultRbBean.get().getDroiture()));
        model.addAttribute("Personnelle",arrondi(resultRaBean.get().getPersonnelle()));
        model.addAttribute("Professionnelle",arrondi(resultRbBean.get().getProfessionnelle()));
        model.addAttribute("Directive",arrondi(resultRaBean.get().getDirective()));
        model.addAttribute("Pouvoir",arrondi(resultRbBean.get().getPouvoir()));
        model.addAttribute("Prudence",arrondi(resultRaBean.get().getPrudence()));
        model.addAttribute("Competition",arrondi(resultRbBean.get().getCompetition()));
        model.addAttribute("Gregarite",arrondi(resultRaBean.get().getGregarite()));
        model.addAttribute("Autonomie",arrondi(resultRbBean.get().getAutonomie()));
        model.addAttribute("Gregarite",arrondi(resultRaBean.get().getIndividualisme()));
        model.addAttribute("Autonomie",arrondi(resultRbBean.get().getAltruisme()));
        model.addAttribute("Traditionnel",arrondi(resultRaBean.get().getTraditionnel()));
        model.addAttribute("Exploration",arrondi(resultRbBean.get().getExploration()));

        return "resultatTestProfilU";

    }

    private double arrondi(double val) {
        return (Math.floor(val*100+0.5))/100;}



        private void resultatTestProfilU() {

        double ra1 = 5 - (resultRaBean.getAuthenticite() / 5);
        double rb1 = resultRbBean.getStrategie() / 5;
       resultRaBean.setAuthenticite(ra1 + rb1);
       resultRbBean.setStrategie(10 - (ra1 + rb1));



        double ra2 = 5 - (resultRaBean.getTenacite() / 5);
        double rb2 = resultRbBean.getFlexibilite() / 5;
        resultRaBean.setTenacite(ra2 + rb2);
        resultRbBean.setFlexibilite(10 - (ra2 + rb2));


        double ra3 = 5 - (resultRaBean.getReactivite()/ 5);
        double rb3 = resultRbBean.getStabilite()/ 5;
        resultRaBean.setReactivite(ra3 + rb3);
        resultRbBean.setStabilite(10 - (ra3 + rb3));


        double ra4 = 5 - (resultRaBean.getIntroversion()/ 5);
        double rb4 = resultRbBean.getExtraversion()/ 5;
        resultRaBean.setIntroversion(ra4 + rb4);
        resultRbBean.setExtraversion(10 - (ra4 + rb4));


        double ra5 = 5 - (resultRaBean.getMethode()/ 5);
        double rb5 = resultRbBean.getImprovisation()/ 5;
        resultRaBean.setMethode(ra5 + rb5);
        resultRbBean.setImprovisation(10 - (ra5 + rb5));


        double ra6 = 5 - (resultRaBean.getIntuition()/ 5);
        double rb6 = resultRbBean.getRationalisme()/ 5;
        resultRaBean.setIntuition(ra6 + rb6);
        resultRbBean.setRationalisme(10 - (ra6 + rb6));


        double ra7 = 5 - (resultRaBean.getNonConformisme()/ 5);
        double rb7 = resultRbBean.getDroiture()/ 5;
        resultRaBean.setNonConformisme(ra7 + rb7);
        resultRbBean.setDroiture(10 - (ra7 + rb7));

        double ra8 = 5 - (resultRaBean.getPersonnelle()/ 5);
        double rb8 = resultRbBean.getProfessionnelle()/ 5;
        resultRaBean.setPersonnelle(ra8 + rb8);
        resultRbBean.setProfessionnelle(10 - (ra8 + rb8));


        double ra9 = 5 - (resultRaBean.getDirective()/ 5);
        double rb9 = resultRbBean.getPouvoir()/ 5;
        resultRaBean.setDirective(ra9 + rb9);
        resultRbBean.setPouvoir(10 - (ra9 + rb9));


        double ra10 = 5 - (resultRaBean.getPrudence()/ 5);
        double rb10 = resultRbBean.getCompetition()/ 5;
        resultRaBean.setPrudence(ra10 + rb10);
        resultRbBean.setCompetition(10 - (ra10 + rb10));


        double ra11 = 5 - (resultRaBean.getGregarite()/ 5);
        double rb11 = resultRbBean.getAutonomie()/ 5;
        resultRaBean.setGregarite(ra11 + rb11);
        resultRbBean.setAutonomie(10 - (ra11 + rb11));


        double ra12 = 5 - (resultRaBean.getIndividualisme()/ 5);
        double rb12 = resultRbBean.getAltruisme()/ 5;
        resultRaBean.setIndividualisme(ra12 + rb12);
        resultRbBean.setAltruisme(10 - (ra12 + rb12));

        double ra13 = 5 - (resultRaBean.getTraditionnel()/ 5);
        double rb13 = resultRbBean.getExploration()/ 5;
        resultRaBean.setTraditionnel(ra13 + rb13);
        resultRbBean.setExploration(10 - (ra13 + rb13));

        mtestsProxy.saveRa(resultRaBean);
        mtestsProxy.saveRb(resultRbBean);

    }
    }
