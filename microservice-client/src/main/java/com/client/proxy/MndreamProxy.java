package com.client.proxy;

import com.client.bean.nDream.*;
import com.client.controler.ProfilReponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")

public interface MndreamProxy {


    @PostMapping(value = "microservice-tests/photo")
   ResponseEntity<PhotoBean> savePhoto(@RequestBody PhotoBean photo);

    @GetMapping(value = "microservice-tests/listPhotos")
    ProfilReponse listPhotos(@RequestParam(name="page",defaultValue = "0")int page,
                                        @RequestParam(name="size",defaultValue = "4")int size);
    @GetMapping(value = "microservice-tests/listPhotosAll")
    List<PhotoBean> listPhotosAll();

    @PostMapping(value = "microservice-tests/saveResultClientNbdream")
    PhotoLangageBean saveResultClient(@RequestBody PhotoLangageBean resultNbdream);

    @PutMapping(value = "microservice-tests/modifResultNbdream")
    PhotoLangageBean modifResultNbdream(@RequestBody PhotoLangageBean resultNbdream);

    @GetMapping(value = "microservice-tests/getNbdream/{id}")
   Optional<PhotoLangageBean> getNbdream(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/getNbdreamAll")
    List<PhotoLangageBean> getNbdreamAll();

    @GetMapping(value = "microservice-tests/getPhoto/{id}")
    Optional<PhotoBean>getPhoto(@PathVariable("id") int id);

   @DeleteMapping(value = "microservice-tests/deletePhoto/{id}/{idClient}")
   PhotoLangageBean deletePhoto(@PathVariable("id") int id , @PathVariable("idClient") int idClient);

    @GetMapping(value = "microservice-tests/listRoueVie")
    List<RoueVieBean> listRoueVie();

    @GetMapping(value = "microservice-tests/getRoueVieClient/{id}")
    Optional<RoueVieBean>getRoueVieClient(@PathVariable("id") int id);
    @PostMapping(value = "microservice-tests/saveRoueVieClient")
    RoueVieBean saveRoueVieClient(@RequestBody RoueVieBean roueVie);

    @PutMapping(value = "microservice-tests/modifRoueVieClient")
    RoueVieBean modifRoueVieClient(@RequestBody RoueVieBean roueVie);

   @GetMapping(value = "microservice-tests/listAutoportrait")
   List<AutoPortraitBean> listAutoportrait();

   @GetMapping(value = "microservice-tests/getAutoportrait/{id}")
   Optional<AutoPortraitBean>getAutoportrait(@PathVariable("id") int id);
   @GetMapping(value = "microservice-tests/ResulAutoportraitAll")
   List<AutoPortraitResultBean> ResulAutoportraitAll();

   @GetMapping(value = "microservice-tests/getResulAutoportrait/{id}")
   Optional<AutoPortraitResultBean>getResulAutoportrait(@PathVariable("id") int id);

   @PostMapping(value = "microservice-tests/saveAutoPortraitClient")
   AutoPortraitResultBean saveAutoPortraitClient(@RequestBody AutoPortraitResultBean autoportraitResult);
    @PutMapping(value = "microservice-tests/modifAutoPortraitClient")
     AutoPortraitResultBean modifAutoPortraitClient(@RequestBody AutoPortraitResultBean autoportraitResult);
    @PostMapping(value = "microservice-tests/saveFicheMetier")
    ResponseEntity<FicheMetierBean> saveFicheMetier(@RequestBody FicheMetierBean ficheMetier);

    @GetMapping(value = "microservice-tests/getFicheMetier/{id}")
    Optional<FicheMetierBean>getFicheMetier(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/getFicheMetierCode/{code}")
    List<FicheMetierBean>getFicheMetierCode(@PathVariable("code") String code);

    @GetMapping(value = "microservice-tests/listvaleurHero")
    List<HeroBean> listvaleurHero();
    @GetMapping(value = "microservice-tests/listResultHero")
    List<HeroResultBean> listResultHero();

    @GetMapping(value = "microservice-tests/getValeurHero/{id}")
   Optional<HeroBean>getValeurHero(@PathVariable("id") int id);

    @GetMapping(value = "microservice-tests/getResultHeroClient/{id}")
    Optional<HeroResultBean>getResultHeroClient(@PathVariable("id") int id);

    @PostMapping(value = "microservice-tests/saveHeroClient")
    HeroResultBean saveHeroClient(@RequestBody HeroResultBean heroResult);

    @PutMapping(value = "microservice-tests/modifHeroClient")
    HeroResultBean mmodifHeroClient(@RequestBody HeroResultBean heroResult);


}
