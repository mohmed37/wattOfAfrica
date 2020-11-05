import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import {HttpClient} from "@angular/common/http";
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements  AfterViewInit{
  map;
  public logo: string="assets/img/ofeli.png";
  public list:any[] =[
    {
      lat: 45.760547,
      lng: 4.861118,
      region:"auvergneRhoneAlpes",
      open: true,
      text:'<b style="color:#b65010">Auvergne Rhone Alpes</b><br><a href="http://www.orientation.auvergnerhonealpes.fr/se-former/recherche/formations">' +
        '<img style="font-size:20%" src="assets/img/ofeli.png" alt="Ofeli" target="blank"/></a>'
    },
    {
      lat: 47.237829,
      lng: 6.0240539,
      region:"bourgogneFrancheComté",
      open: true,
        text:'<b style=\"color:#b65010\">Bourgogne Franche Comté</b><br><a href="http://www.emfor-bfc.org/formations/"><img style="font-size:20%" src="assets/img/emfor.png" alt="Enfor" target="blank"/></a><br>' +
        '<a href="https://bourgogne-franche-comte.cleor.org/"><img style="font-size:20%" src="assets/img/cleor.png" alt="Cleor" target="blank"/></a><br>' +
        '<a href="http://www.orientation-formation-emploi.org/rubrique-se-former,2.html"><img style="font-size:20%" src="assets/img/orientation.png" alt="Orientation" target="blank"/></a>'
  },{
    lat: 48.117266,
    lng: -1.6777926,
    region:"bretagne",
    open: true,
    text:"Bretagne<br>https://www.formation.gref-bretagne.com/liste-des-offres"
  },{
      lat: 47.902964,
      lng: 1.909251,
      region:"centreValdeLoire",
      open: true,
      text:"Centre Val de Loire<br>http://www.etoile.regioncentre.fr/GIP/accueiletoile/seformer/formation/offre-formation-region<br>https://www.cleor-centrevaldeloire.fr/recherche/formations/etape/1"
    },{
      lat: 42.039604,
      lng: 9.012893,
      region:"corse",
      open: true,
      text:"Corse<br>http://www.fiore-corse.fr/formations/recherche-formations.html"
    },{
      lat: 48.692054,
      lng: 6.184417,
      region:"grandEst",
      open: true,
      text:"Grand Est<br>https://formation.grandest.fr/"
    },{
      lat: 50.633333,
      lng: 3.066667,
      region:"hautsDeFrance",
      open: true,
      text:"Hauts De France<br>https://cleor.c2rp.fr/recherche/formations/etape/1<br>https://www.c2rp.fr/formations"
    },{
      lat: 48.866667,
      lng: 2.333333,
      region:"iledeFrance",
      open: true,
      text: "Ile de France<br>https://www.defi-metiers.fr/oaio/formation<br>https://www.oriane.info/recherche?type_recherche=formation&ss_type_formation=initiale"
    },{
      lat: 49.443232,
      lng: 1.099971,
      region:"normandie",
      open: true,
      text:"Normandie<br>https://www.trouvermaformation.fr/<br>https://normandie.cleor.org/<br>https://parcours-metier.normandie.fr/recherche-formation"
    },
    {
      lat: 44.837789,
      lng: -0.57918,
      region:"nouvelleAquitaine",
      open: true,
      text:"Nouvelle Aquitaine<br>https://entrepot.aquitaine-cap-metiers.fr/recherche/accueil/"
    },{
      lat: 43.600000,
      lng: 1.433333,
      region:"occitanie",
      open: true,
      text:"Occitanie<br>https://www.meformerenregion.fr/recherche?k=formations&f%5B0%5D=",
    },{
      lat: 47.218371,
      lng: -1.553621,
      region:"paysdelaLoire",
      open: true,
      text:"Pays de la Loire<br>https://pro.choisirmonmetier-paysdelaloire.fr/donnees/recherche-formation/"
    },{
      lat: 43.300000,
      lng: 5.400000,
      region:"provenceAlpesCôtedAzur",
      open: true,
      text:"Provence Alpes Côte d'Azur<br>https://www.orientation-regionsud.fr/Formation/"
    },
  ];

  constructor(private http: HttpClient) { }

  ngAfterViewInit(): void {

//FRANCE
    let myfrugalmap = L.map('map').setView([46.227638, 2.213749], 6);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'France Map'
    }).addTo(myfrugalmap);
    let myIcon = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });
    this.list.forEach(podotactile => {
      L.marker([podotactile.lat, podotactile.lng], {icon: myIcon}).addTo(myfrugalmap).bindPopup(podotactile.text);
    });

 //GUADELOUPE

    let mapGuadeloupe=L.map('mapGuadeloupe').setView([16.241100 ,-61.533100], 10);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Guadeloupe Map'
    }).addTo(mapGuadeloupe);
    let myIconG = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    let lien:any="https://www.guadeloupeformation.com/";
    L.marker([16.241100 ,-61.533100], {icon: myIconG}).addTo(mapGuadeloupe).bindPopup(lien);

 //Guyane

    let mapGuyane=L.map('mapGuyane').setView([3.9517949999999997 ,-53.07822999999999], 7);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Guyane Map'
    }).addTo(mapGuyane);
    let myIconGuy = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    let lienGuy:any="http://www.portail-takari.org/";
    L.marker([3.9517949999999997 ,-53.07822999999999], {icon: myIconGuy}).addTo(mapGuyane).bindPopup(lienGuy);

    //Martinique
    let mapMartinique=L.map('mapMartinique').setView([14.635540500000001 ,-61.02281400000001], 10);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Martinique Map'
    }).addTo(mapMartinique);
    let myIconMart = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    let lienMart:any="http://www.seformerenmartinique.mq/formations/";
    L.marker([14.635540500000001 ,-61.02281400000001], {icon: myIconMart}).addTo(mapMartinique).bindPopup(lienMart);

    //Mayotte
    let mapMayotte=L.map('mapMayotte').setView([-12.8245115 ,45.16545500000001], 10);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Mayotte Map'
    }).addTo(mapMayotte);
    let myIconMayo = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    let lienMayo:any="http://www.mayotte-emploi-formation.info/formations/index.php#";
    L.marker([-12.8245115 ,45.16545500000001], {icon: myIconMayo}).addTo(mapMayotte).bindPopup(lienMayo);

    //La Réunion
    let mapReunion=L.map('mapReunion').setView([-21.115141,55.536384], 10);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'La Réunion Map'
    }).addTo(mapReunion);
    let myIconReun = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    let lienReun:any="https://www.formanoo.org/#/";
    L.marker([-21.115141,55.536384], {icon: myIconReun}).addTo(mapReunion).bindPopup(lienReun);



  }


}
