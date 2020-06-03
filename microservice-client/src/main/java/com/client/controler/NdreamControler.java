package com.client.controler;


import com.client.bean.motivU.MotivUResultBean;
import com.client.bean.nDream.*;
import com.client.bean.praicoU.ResultPraicoUBean;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MPraicoUProxy;
import com.client.proxy.MndreamProxy;
import com.client.proxy.MuserProxy;
import com.client.service.IUserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class NdreamControler {
    @Autowired
    MndreamProxy mndream;
    @Value("${dir.images}")
    private String imageDir;
    @Autowired
    IUserService userService;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MPraicoUProxy praicoUProxy;


    @RequestMapping("/photos")
    public String formLivre(Model model){
        PhotoBean photo =new PhotoBean();
        model.addAttribute("photo",photo);
        return "photos";
    }

   @RequestMapping("/savePhoto")
    public String saveLivre(@Valid @ModelAttribute("photo") PhotoBean photo,
                            @RequestParam(name = "picture") MultipartFile file, BindingResult bindingResult) throws IOException {
       if (bindingResult.hasErrors()) {
           return "photos";
       }

       List<PhotoBean> listPhoto = mndream.listPhotosAll();
       photo.setId(listPhoto.size() + 1);

       if (!(file.isEmpty())) {
           photo.setPhoto(file.getOriginalFilename());
           file.transferTo(new File(imageDir + (photo.getId())));
       }
       mndream.savePhoto(photo);
       return "redirect:/photos";

   }

       @RequestMapping("/photosFicheMetier")
       public String photosFicheMetier(Model model){
           PhotoFicheMetierBean photo =new PhotoFicheMetierBean();
           model.addAttribute("photo",photo);
           return "photoFicheMetier";
       }



    @RequestMapping("/savePhotoFicheMetier")
    public String savePhotoFicheMetier(@Valid @ModelAttribute("photo")  PhotoFicheMetierBean photo,
                            @RequestParam(name = "picture") MultipartFile file, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            return "photoFicheMetier";
        }

        List<PhotoFicheMetierBean>listPhoto=mndream.getPhotoFicheMetierAll();
        photo.setId(listPhoto.size()+81);

        if(!(file.isEmpty())){
            photo.setPhoto(file.getOriginalFilename());
            file.transferTo(new File(imageDir+(photo.getId())));
        }
        mndream.photoFicheMetier(photo);
        return "redirect:/photoFicheMetier";

    }




    @RequestMapping(value = "bnDream")
    public String bnDream(Model model,@RequestParam(name="page",defaultValue = "0")int page,
                          @RequestParam(name="size",defaultValue = "4")int size){
        UserBean userConnec = userService.getUserConnec();

        List<PhotoLangageBean> nbdreamBeanList = mndream.getNbdreamAll();
        if (nbdreamBeanList.size() == 0) {
            savebnDream(userConnec);

        }
        List<PhotoLangageBean> lisNbdream2 = mndream.getNbdreamAll();
        boolean userinscrit = false;
        for (PhotoLangageBean clientNbdream : lisNbdream2) {
            if (clientNbdream.getClient().compareTo(userConnec.getNum()) == 0) {
                userinscrit = true;
                break;
            }
        }
        {
            if (!userinscrit) {
                savebnDream(userConnec);
            }
        }

       ProfilReponse pagePhoto=mndream.listPhotos(page,size);
        int pagesCount1=pagePhoto.getContent().size();
        int[]pages=new int[pagesCount1];
        for (int j=0;j<pagesCount1;j++) pages[j]=j;
        model.addAttribute("pages",pages);
        model.addAttribute("pagePhoto", pagePhoto.getContent());
        model.addAttribute("pageCourant",page);
        Optional<RoueVieBean>roueVieBean=mndream.getRoueVieClient(userConnec.getNum());
        model.addAttribute("roueVieBean",roueVieBean.get());
        Optional<PhotoLangageBean>nbdreamBean=mndream.getNbdream(userConnec.getNum());
        model.addAttribute("nbdreamBean",nbdreamBean.get());
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("questionnairesBean1",questionnairesBean.get());
        List<AutoPortraitBean>portraitBeanList=mndream.listAutoportrait();
        model.addAttribute("portraitBeanList",portraitBeanList);
        Optional<AutoPortraitResultBean>autoPortraitBean=mndream.getResulAutoportrait(userConnec.getNum());
        model.addAttribute("autoPortraitBean",autoPortraitBean.get());
        Optional<HeroResultBean>heroResultBean=mndream.getResultHeroClient(userConnec.getNum());
        model.addAttribute("heroResultBean",heroResultBean.get());
        List<HeroBean>listValeur=mndream.listvaleurHero();
        model.addAttribute("listValeur",listValeur);
        return "bnDream";
    }

    private void savebnDream(UserBean userConnec) {
        PhotoLangageBean resultNbdreamBean = new PhotoLangageBean();
        resultNbdreamBean.setClient(userConnec.getNum());
        mndream.saveResultClient(resultNbdreamBean);
        RoueVieBean roueVieBean=new RoueVieBean();
        roueVieBean.setClient(userConnec.getNum());
        mndream.saveRoueVieClient(roueVieBean);
        AutoPortraitResultBean resultBean=new AutoPortraitResultBean();
        resultBean.setClient(userConnec.getNum());
        mndream.saveAutoPortraitClient(resultBean);
        HeroResultBean heroResultBean=new HeroResultBean();
        heroResultBean.setClient(userConnec.getNum());
        mndream.saveHeroClient(heroResultBean);
    }


    @RequestMapping(value = "/getPhoto",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(String id) throws IOException {
        File f=new File(imageDir+id);
        return IOUtils.toByteArray(new FileInputStream(f));

    }

    @RequestMapping(value = "saveMotsClient")
    public String saveMotsClient(@Valid @ModelAttribute("photoLangageBean")PhotoLangageBean photoLangageBean,BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            return "bnDream";
        }
        UserBean userConnec = userService.getUserConnec();
        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());

        Optional<PhotoLangageBean> client=mndream.getNbdream(userConnec.getNum());
        if (client.get().getTest1()){
            client.get().setMot4(photoLangageBean.getMot4());
            client.get().setMot5(photoLangageBean.getMot5());
            client.get().setMot6(photoLangageBean.getMot6());

            questionnairesBean1.get().setPhotoLangage(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            mndream.modifResultNbdream(client.get());

            return "redirect:/bnDream";
        }
        client.get().setMot1(photoLangageBean.getMot1());
        client.get().setMot2(photoLangageBean.getMot2());
        client.get().setMot3(photoLangageBean.getMot3());
        client.get().setTest1(true);
        mndream.modifResultNbdream(client.get());

        return "redirect:/bnDream";
    }



    @RequestMapping(value = "savePhotosClient/{id}/{page}")
    public String savePhotosClient(@PathVariable("id") int id, @PathVariable("page") int page){
        UserBean userConnec = userService.getUserConnec();



       Optional<PhotoLangageBean> client=mndream.getNbdream(userConnec.getNum());
        if(client.get().getPhoto1().equals(id)||client.get().getPhoto2().equals(id)||client.get().getPhoto3().equals(id)){
             return "redirect:/bnDream?page="+page;
        }

        if (client.get().getPhoto1()==0){
            client.get().setPhoto1(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;
        }

        if (client.get().getPhoto2()==0){
            client.get().setPhoto2(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;
        }

        if (client.get().getPhoto3()==0){
            client.get().setPhoto3(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;}

        if (client.get().getPhoto4()==0){
            client.get().setPhoto4(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;}

        if (client.get().getPhoto5()==0){
            client.get().setPhoto5(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;}

        if (client.get().getPhoto6()==0){
            client.get().setPhoto6(id);
            mndream.modifResultNbdream(client.get());
            return "redirect:/bnDream?page="+page;}

        return "redirect:/bnDream?page="+page;}


    @RequestMapping(value = "deletePhoto/{id}/{page}")
    public String deletePhoto(@PathVariable("id") int id, @PathVariable("page") int page){
        UserBean userConnec = userService.getUserConnec();
        mndream.deletePhoto(id,userConnec.getNum());
        return "redirect:/bnDream?page="+page;
    }

    @RequestMapping(value = "/resultatNbdream")
    public String resultatNbdream(Model model) {
        UserBean userConnec = userService.getUserConnec();
        Optional<PhotoLangageBean>photoLangageBean= mndream.getNbdream(userConnec.getNum());
        model.addAttribute("photoLangage",photoLangageBean.get());
        Optional<RoueVieBean>roueVieBean=mndream.getRoueVieClient(userConnec.getNum());
        model.addAttribute("roueVieBean",roueVieBean.get());
        Optional<AutoPortraitResultBean>autoPortraitBean=mndream.getResulAutoportrait(userConnec.getNum());
        model.addAttribute("autoPortraitBean",autoPortraitBean.get());
        Optional<ResultPraicoUBean>resultRaBean=praicoUProxy.praicoIdClient(userConnec.getNum());
        model.addAttribute("result",resultRaBean.get());
        Optional<QuestionnairesBean> questionnairesBean = muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("questionnairesBean1",questionnairesBean.get());
        Optional<HeroResultBean>heroResultBean=mndream.getResultHeroClient(userConnec.getNum());
        model.addAttribute("heroResultBean",heroResultBean.get());
        return "bnDreamResult";

    }

    @RequestMapping(value = "saveRoueVieClient")
    public String saveRoueVieClient(@Valid @ModelAttribute("roueVieBean") RoueVieBean roueVieBean,BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            return "bnDream";
        }
        UserBean userConnec = userService.getUserConnec();
        Optional<RoueVieBean>roueVieBean1=mndream.getRoueVieClient(userConnec.getNum());
        if (!roueVieBean1.get().getRoueVie1()){
        roueVieBean1.get().setFamille1(roueVieBean.getFamille1());
        roueVieBean1.get().setPersonnelle1(roueVieBean.getPersonnelle1());
        roueVieBean1.get().setProfessionnel1(roueVieBean.getProfessionnel1());
        roueVieBean1.get().setSante1(roueVieBean.getSante1());
        roueVieBean1.get().setSocial1(roueVieBean.getSocial1());
        roueVieBean1.get().setRoueVie1(true);
        mndream.modifRoueVieClient(roueVieBean1.get());
        return "redirect:/bnDream";}

        roueVieBean1.get();
        if(!roueVieBean1.get().getRoueVie2()){
        roueVieBean1.get().setFamille2(roueVieBean.getFamille2());
        roueVieBean1.get().setPersonnelle2(roueVieBean.getPersonnelle2());
        roueVieBean1.get().setProfessionnel2(roueVieBean.getProfessionnel2());
        roueVieBean1.get().setSante2(roueVieBean.getSante2());
        roueVieBean1.get().setSocial2(roueVieBean.getSocial2());
        roueVieBean1.get().setRoueVie2(true);
        mndream.modifRoueVieClient(roueVieBean1.get());
        return "redirect:/bnDream";}

        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());
        questionnairesBean1.get().setRoueVie(true);
        muserProxy.updateQuestionnaire(questionnairesBean1.get());
        roueVieBean1.get().setQcm1(roueVieBean.getQcm1());
        roueVieBean1.get().setQcm2(roueVieBean.getQcm2());
        roueVieBean1.get().setQcm3(roueVieBean.getQcm3());
        mndream.modifRoueVieClient(roueVieBean1.get());
        return "redirect:/bnDream";
    }

    @RequestMapping(value = "savePortraitClient/{id}")
    public String savePortraitClient(@Valid @ModelAttribute("autoPortraitBean") AutoPortraitResultBean autoPortraitBean,@PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "bnDream";
        }
        AutoPortraitResultBean mot1=autoPortraitBean;
        Optional<AutoPortraitBean> mot=mndream.getAutoportrait(id);
        UserBean userConnec = userService.getUserConnec();
        Optional<AutoPortraitResultBean> resultBean= mndream.getResulAutoportrait(userConnec.getNum());
        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());

       if (!resultBean.get().getAuto1()){
        if (resultBean.get().getQualite1().equals("-")) {
            resultBean.get().setQualite1(mot.get().getPersonnalite());
            mndream.modifAutoPortraitClient(resultBean.get());
            return "redirect:/bnDream";
        }
        if (resultBean.get().getQualite2().equals("-")) {
            resultBean.get().setQualite2(mot.get().getPersonnalite());
            mndream.modifAutoPortraitClient(resultBean.get());
            return "redirect:/bnDream";
        }
        if (resultBean.get().getQualite3().equals("-")) {
            resultBean.get().setQualite3(mot.get().getPersonnalite());
            mndream.modifAutoPortraitClient(resultBean.get());
            return "redirect:/bnDream";
        }
        if (resultBean.get().getDefaut1().equals("-")) {
            resultBean.get().setDefaut1(mot.get().getPersonnalite());
            mndream.modifAutoPortraitClient(resultBean.get());
            return "redirect:/bnDream";
        }
        if (resultBean.get().getDefaut2().equals("-")) {
            resultBean.get().setDefaut2(mot.get().getPersonnalite());
            mndream.modifAutoPortraitClient(resultBean.get());
            return "redirect:/bnDream";
        }
        if (resultBean.get().getDefaut3().equals("-")) {
        resultBean.get().setDefaut3(mot.get().getPersonnalite());
        resultBean.get().setAuto1(true);
        mndream.modifAutoPortraitClient(resultBean.get());
        return "redirect:/bnDream";}}

        if (resultBean.get().getAuto1()&&!resultBean.get().getAuto2()){
            if (resultBean.get().getQualite4().equals("-")) {
                resultBean.get().setQualite4(mot.get().getPersonnalite());
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";
            }
            if (resultBean.get().getQualite5().equals("-")) {
                resultBean.get().setQualite5(mot.get().getPersonnalite());
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";
            }
            if (resultBean.get().getQualite6().equals("-")) {
                resultBean.get().setQualite6(mot.get().getPersonnalite());
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";
            }
            if (resultBean.get().getDefaut4().equals("-")) {
                resultBean.get().setDefaut4(mot.get().getPersonnalite());
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";
            }
            if (resultBean.get().getDefaut5().equals("-")) {
                resultBean.get().setDefaut5(mot.get().getPersonnalite());
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";
            }
            if (resultBean.get().getDefaut6().equals("-")) {
                resultBean.get().setDefaut6(mot.get().getPersonnalite());
                resultBean.get().setAuto2(true);
                mndream.modifAutoPortraitClient(resultBean.get());
                return "redirect:/bnDream";}}
        if (resultBean.get().getAuto2()){
            resultBean.get().setReflexion(autoPortraitBean.getReflexion());
           questionnairesBean1.get().setAutoPortrait(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            mndream.modifAutoPortraitClient(resultBean.get());


            return "redirect:/bnDream";
        }




            return "redirect:/bnDream";
    }

    @RequestMapping(value = "/fiche{id}")
    public String fiche(Model model,@PathVariable("id") int id) {

       Optional<FicheMetierBean> ficheMetier=mndream.getFicheMetier(id);
        model.addAttribute("ficheMetier",ficheMetier.get());
        String[] competence=ficheMetier.get().getCompetence().split("-");
            model.addAttribute("competence",competence);
        String[] qualite=ficheMetier.get().getQualite().split("-");
        model.addAttribute("qualite",qualite);
        return "ficheMetier";
    }

    @RequestMapping(value = "saveHeroClient")
    public String saveHeroClient(@Valid @ModelAttribute("heroResultBean") HeroResultBean heroResultBean,BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            return "bnDream";
        }
        UserBean userConnec = userService.getUserConnec();
        Optional<HeroResultBean>hero=mndream.getResultHeroClient(userConnec.getNum());
        if (!hero.get().getChoixHero()){
       hero.get().setHero(heroResultBean.getHero());
       hero.get().setChoixHero(true);

            mndream.mmodifHeroClient(hero.get());
            return "redirect:/bnDream";

        }

        return "redirect:/bnDream";

    }
    @RequestMapping(value = "saveValeurClient/{id}")
    public String saveValeurClient(@PathVariable("id") int id)  {

        UserBean userConnec = userService.getUserConnec();
        Optional<HeroResultBean>hero=mndream.getResultHeroClient(userConnec.getNum());
        Optional<HeroBean> valeur=mndream.getValeurHero(id);
        Optional<QuestionnairesBean> questionnairesBean1=muserProxy.questionnairesUser(userConnec.getNum());

        if (hero.get().getValeur1().equals("-")){
            hero.get().setValeur1(valeur.get().getValeur());
            mndream.mmodifHeroClient(hero.get());
            return "redirect:/bnDream";
        }

        if (hero.get().getValeur2().equals("-")){
            hero.get().setValeur2(valeur.get().getValeur());
            mndream.mmodifHeroClient(hero.get());
            return "redirect:/bnDream";
        }

        if (hero.get().getValeur3().equals("-")){
            hero.get().setValeur3(valeur.get().getValeur());
            mndream.mmodifHeroClient(hero.get());
            questionnairesBean1.get().setHero(true);
            muserProxy.updateQuestionnaire(questionnairesBean1.get());
            return "redirect:/bnDream";
        }

        return "redirect:/bnDream";

    }



    @RequestMapping("/selectionParCategorie{categorie}")
    public String selectionParCategorie(Model model,@PathVariable("categorie") String categorie) {

    List<FicheMetierBean>ficheMetierBeanList=mndream.findByCategorie(categorie);
    model.addAttribute("ficheMetierBeanList",ficheMetierBeanList);
    model.addAttribute("categorie",categorie);
        return "listeMetier";
    }



    @RequestMapping("/ficheMetier")
    public String ficheMetier(Model model) {

        List<PhotoFicheMetierBean>categorieAll=mndream.getPhotoFicheMetierAll();
        model.addAttribute("categorieAll",categorieAll);
        return "listFicheMetier";
    }

}
