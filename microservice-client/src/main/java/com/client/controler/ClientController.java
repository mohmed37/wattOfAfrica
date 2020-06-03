package com.client.controler;



import com.client.bean.compVerbale.CompVerbale2Bean;
import com.client.bean.compVerbale.CompVerbale3Bean;
import com.client.bean.nDream.FicheMetierBean;
import com.client.bean.nDream.PhotoFicheMetierBean;
import com.client.bean.profilU.*;
import com.client.bean.user.QuestionnairesBean;
import com.client.bean.user.UserBean;
import com.client.proxy.MCompVerbaleProxy;
import com.client.proxy.MProfilUProxy;
import com.client.proxy.MndreamProxy;
import com.client.proxy.MuserProxy;
import com.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
public class ClientController {

    @Autowired
    MProfilUProxy mtestsProxy;
    @Autowired
    MuserProxy muserProxy;
    @Autowired
    MCompVerbaleProxy mCompVerbaleProxy;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IUserService userService;
    @Autowired
    MndreamProxy mndreamProxy;

    @Value("${dir.images}")
    private String imageDir;


    @RequestMapping("/")
    public String accueil(Model model){

        List<ProfiluBean>questionsList=mtestsProxy.listDesQuestion();
        model.addAttribute("listQuestion",questionsList);

        return "accueil1";
    }

    @RequestMapping(value ="/listQuestionnaires")
    public String listQuestionnaires(Model model) {
        UserBean userConnec=userService.getUserConnec();
        Optional<QuestionnairesBean> questionnairesBean=muserProxy.questionnairesUser(userConnec.getNum());
        model.addAttribute("questionnaire",questionnairesBean);
        return "listQuestionnaires";}

    @RequestMapping("/form")
    public String formLivre(Model model){
        FicheMetierBean ficheMetierBean=new FicheMetierBean();
        model.addAttribute("ficheMetierBean",ficheMetierBean);
        List<PhotoFicheMetierBean>categorieMetier=mndreamProxy.getPhotoFicheMetierAll();
        model.addAttribute("categorieMetier",categorieMetier);


        return "formRest";
    }


    @RequestMapping("/saveRest")
    public String saveRestitution(@Valid @ModelAttribute("ficheMetierBean") FicheMetierBean ficheMetierBean, @RequestParam("iDCategorie") int iDCategorie) {
        ficheMetierBean.setPhoto(mndreamProxy.getPhotoFicheMetier(iDCategorie).get());
        mndreamProxy.saveFicheMetier(ficheMetierBean);
        return "redirect:/form";
    }



    /**
     * page connection utilisateur
     */

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
    /**
     * @param username rechercher un utilisateur avec son username.
     */
    @RequestMapping(value ="/username")
    public UserBean findUserByUsername(@RequestParam(name = "username",defaultValue ="") String username) {
        return muserProxy.findUserByUsername(username);}



}
