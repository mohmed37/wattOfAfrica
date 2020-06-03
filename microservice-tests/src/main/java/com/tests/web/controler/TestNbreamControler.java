package com.tests.web.controler;

import com.tests.dao.ndream.*;
import com.tests.entity.ndream.*;
import com.tests.web.exceptions.QuestioneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestNbreamControler {

    @Autowired
    PhotoRepositories photoRepositories;
    @Autowired
    PhotoLangageRepositories nbdreamRepositories;
    @Autowired
    RoueVieRepositories roueVieRepositories;
    @Autowired
    AutoportraitRepositories autoportraitRepositories;
    @Autowired
    AutoportraitResultRepositories autoportraitResultRepositories;
    @Autowired
    HeroResultRepositories heroResultRepositories;
    @Autowired
    heroRepositories heroRepositories;
    @Autowired
    FicheMetierRepositories ficheMetierRepositories;
    @Autowired
    PhotoFMRepositories photoFMRepositories;

    @PostMapping(value = "/photo")
    public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }

        Photo savePhoto = photoRepositories.save(photo);

        return new ResponseEntity<Photo>(savePhoto, HttpStatus.CREATED);
    }




    @GetMapping(value = "/listPhotos")
    public Page<Photo> listPhotos(@RequestParam(name="page",defaultValue = "0")int page,
                                  @RequestParam(name="size",defaultValue = "4")int size){

        return photoRepositories.findAll(PageRequest.of(page,size));
    }

    @GetMapping(value = "/listPhotosAll")
    public List<Photo> listPhotosAll(){

        return photoRepositories.findAll();
    }

    @GetMapping(value = "getPhoto/{id}")
    public Optional<Photo>getPhoto(@PathVariable("id") int id) {
        Optional<Photo> photo = photoRepositories.findById(id);
        if (!photo.isPresent()) throw new QuestioneNotFoundException("Cette photo n'existe pas");
        return photo;

    }


    @PostMapping(value = "saveResultClientNbdream")
    public PhotoLangage saveResultClient(@RequestBody PhotoLangage resultNbdream, BindingResult bindingResult ){
        if (bindingResult.hasErrors()){
            return null;
        }
        resultNbdream.setPhoto1(0);
        resultNbdream.setPhoto2(0);
        resultNbdream.setPhoto3(0);
        resultNbdream.setPhoto4(0);
        resultNbdream.setPhoto5(0);
        resultNbdream.setPhoto6(0);
        resultNbdream.setTest1(false);
        return nbdreamRepositories.save(resultNbdream);

    }


    @PutMapping(value = "modifResultNbdream")
    public PhotoLangage modifResultNbdream(@RequestBody PhotoLangage resultNbdream, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }
        return nbdreamRepositories.save(resultNbdream);
    }

    @GetMapping(value = "getNbdream/{id}")
    public Optional<PhotoLangage>getNbdream(@PathVariable("id") int id) {
        Optional<PhotoLangage> resultatClient = nbdreamRepositories.findByClient(id);
        if (!resultatClient.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return resultatClient;

    }
    @GetMapping(value = "getNbdreamAll")
    public List<PhotoLangage> getNbdreamAll(){
        return  nbdreamRepositories.findAll();
    }

    @DeleteMapping(value = "deletePhoto/{id}/{idClient}")
    public PhotoLangage deletePhoto(@PathVariable("id") int id , @PathVariable("idClient") int idClient){
         Optional<PhotoLangage> client= getNbdream(idClient);
        if (id==1){
            client.get().setPhoto1(0);
            return nbdreamRepositories.save(client.get());
       }
        if (id==2){
            client.get().setPhoto2(0);
            return nbdreamRepositories.save(client.get());
        }
        if (id==3){
            client.get().setPhoto3(0);
            return nbdreamRepositories.save(client.get());
        }
        if (id==4){
            client.get().setPhoto4(0);
            return nbdreamRepositories.save(client.get());
        }
        if (id==5){
            client.get().setPhoto5(0);
            return nbdreamRepositories.save(client.get());
        }
        if (id==6){
            client.get().setPhoto6(0);
            return nbdreamRepositories.save(client.get());
        }

        return null;

    }

    @GetMapping(value = "/listRoueVie")
    public List<RoueVie> listRoueVie(){
        return roueVieRepositories.findAll();
    }

    @GetMapping(value = "getRoueVieClient/{id}")
    public Optional<RoueVie>getRoueVieClient(@PathVariable("id") int id) {
        Optional<RoueVie> roueVieClient = roueVieRepositories.findByClient(id);
        if (!roueVieClient.isPresent()) throw new QuestioneNotFoundException("Cette photo n'existe pas");
        return roueVieClient;
    }

    @PostMapping(value = "saveRoueVieClient")
    public RoueVie saveRoueVieClient(@RequestBody RoueVie roueVie, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        roueVie.setRoueVie1(false);
        roueVie.setRoueVie2(false);
        return roueVieRepositories.save(roueVie);

    }

    @PutMapping(value = "modifRoueVieClient")
    public RoueVie modifRoueVieClient(@RequestBody RoueVie roueVie, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        return roueVieRepositories.save(roueVie);

    }

    @GetMapping(value = "/listAutoportrait")
    public List<Autoportrait> listAutoportrait(){
        return autoportraitRepositories.findAll();
    }

    @GetMapping(value = "getAutoportrait/{id}")
    public Optional<Autoportrait>getAutoportrait(@PathVariable("id") int id) {
        Optional<Autoportrait> autoPortrait = autoportraitRepositories.findById(id);
        if (!autoPortrait.isPresent()) throw new QuestioneNotFoundException("Ce mot n'existe pas");
        return autoPortrait;
    }
    @GetMapping(value = "/ResulAutoportraitAll")
    public List<AutoportraitResult> ResulAutoportraitAll(){
        return autoportraitResultRepositories.findAll();
    }

    @GetMapping(value = "getResulAutoportrait/{id}")
    public Optional<AutoportraitResult>getResulAutoportrait(@PathVariable("id") int id) {
        Optional<AutoportraitResult> autoPortrait = autoportraitResultRepositories.findByClient(id);
        if (!autoPortrait.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test n'existe pas");
        return autoPortrait;
    }


    @PostMapping(value = "saveAutoPortraitClient")
    public AutoportraitResult saveAutoPortraitClient(@RequestBody AutoportraitResult autoportraitResult, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        autoportraitResult.setDefaut1("-");
        autoportraitResult.setDefaut2("-");
        autoportraitResult.setDefaut3("-");
        autoportraitResult.setQualite1("-");
        autoportraitResult.setQualite2("-");
        autoportraitResult.setQualite3("-");
        autoportraitResult.setDefaut4("-");
        autoportraitResult.setDefaut5("-");
        autoportraitResult.setDefaut6("-");
        autoportraitResult.setQualite4("-");
        autoportraitResult.setQualite5("-");
        autoportraitResult.setQualite6("-");
        autoportraitResult.setAuto1(false);
        autoportraitResult.setAuto2(false);

        return autoportraitResultRepositories.save(autoportraitResult);
    }
    @PutMapping(value = "modifAutoPortraitClient")
    public AutoportraitResult modifAutoPortraitClient(@RequestBody AutoportraitResult autoportraitResult, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        return autoportraitResultRepositories.save(autoportraitResult);
    }

    @GetMapping(value = "/listvaleurHero")
    public List<Hero> listvaleurHero(){
        return heroRepositories.findAll();
    }
    @GetMapping(value = "/listResultHero")
    public List<HeroResult> listResultHero(){
        return heroResultRepositories.findAll();
    }

    @GetMapping(value = "getValeurHero/{id}")
    public Optional<Hero>getValeurHero(@PathVariable("id") int id) {
        Optional<Hero> valeurHero = heroRepositories.findById(id);
        if (!valeurHero.isPresent()) throw new QuestioneNotFoundException("Cette valeur n'existe pas");
        return valeurHero;
    }

    @GetMapping(value = "getResultHeroClient/{id}")
    public Optional<HeroResult>getResultHeroClient(@PathVariable("id") int id) {
        Optional<HeroResult> heroResult = heroResultRepositories.findByClient(id);
        if (!heroResult.isPresent()) throw new QuestioneNotFoundException("Ce client n'a pas de test");
        return heroResult;
    }

    @PostMapping(value = "saveHeroClient")
    public HeroResult saveHeroClient(@RequestBody HeroResult heroResult, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        heroResult.setChoixHero(false);
        heroResult.setValeur1("-");
        heroResult.setValeur2("-");
        heroResult.setValeur3("-");
        return heroResultRepositories.save(heroResult);

    }

    @PutMapping(value = "modifHeroClient")
    public HeroResult mmodifHeroClient(@RequestBody HeroResult heroResult, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        return heroResultRepositories.save(heroResult);

    }




    @PostMapping(value = "/saveFicheMetier")
    public ResponseEntity<FicheMetier> saveFicheMetier(@RequestBody FicheMetier ficheMetier, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }

        FicheMetier saveFicheMetier = ficheMetierRepositories.save(ficheMetier);

        return new ResponseEntity<FicheMetier>(saveFicheMetier, HttpStatus.CREATED);
    }

    @GetMapping(value = "getFicheMetier/{id}")
    public Optional<FicheMetier>getFicheMetier(@PathVariable("id") int id) {
        Optional<FicheMetier> ficheMetier = ficheMetierRepositories.findById(id);
        if (!ficheMetier.isPresent()) throw new QuestioneNotFoundException("Cette fiche n'existe pas");
        return ficheMetier;
    }

    @GetMapping(value = "getFicheMetierCode/{code}")
    public List<FicheMetier>getFicheMetierCode(@PathVariable("code") String code) {
        return ficheMetierRepositories.findByCode(code);
    }

    @PostMapping(value = "/photoFicheMetier")
    public ResponseEntity<PhotoFicheMetier> photoFicheMetier(@RequestBody PhotoFicheMetier photo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }

        PhotoFicheMetier savePhoto = photoFMRepositories.save(photo);

        return new ResponseEntity<PhotoFicheMetier>(savePhoto, HttpStatus.CREATED);
    }

    @GetMapping(value = "getPhotoFicheMetier/{id}")
    public Optional<PhotoFicheMetier>getPhotoFicheMetier(@PathVariable("id") int id) {
        Optional<PhotoFicheMetier> photo = photoFMRepositories.findById(id);
        if (!photo.isPresent()) throw new QuestioneNotFoundException("Cette photo n'existe pas");
        return photo;
    }
    @GetMapping(value = "getPhotoFicheMetierAll")
    public List<PhotoFicheMetier>getPhotoFicheMetierAll() {

        return photoFMRepositories.findAll();
    }

    @GetMapping(value = "/categorie")
    public List<FicheMetier> findByCategorie(  @RequestParam(name = "categorie",defaultValue =" " )String categorie){
        return ficheMetierRepositories.findByPhoto_Categirie(categorie);
    }





}


