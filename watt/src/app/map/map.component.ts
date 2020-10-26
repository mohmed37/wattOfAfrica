import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import {control} from "leaflet";
import zoom = control.zoom;
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
      text:"http://www.orientation.auvergnerhonealpes.fr/se-former/recherche/formations"
    },
    {
      lat: 47.237829,
      lng: 6.0240539,
      region:"bourgogneFrancheComté",
      open: true,
      text:"http://www.emfor-bfc.org/formations/"+"\n"+"https://bourgogne-franche-comte.cleor.org/"+"\n"+"http://www.orientation-formation-emploi.org/rubrique-se-former,2.html"
  },{
    lat: 48.117266,
    lng: -1.6777926,
    region:"bretagne",
    open: true,
    text:"https://www.formation.gref-bretagne.com/liste-des-offres"
  },{
      lat: 47.902964,
      lng: 1.909251,
      region:"centreValdeLoire",
      open: true,
      text:"http://www.etoile.regioncentre.fr/GIP/accueiletoile/seformer/formation/offre-formation-region"+"\n"+"https://www.cleor-centrevaldeloire.fr/recherche/formations/etape/1"
    },{
      lat: 42.039604,
      lng: 9.012893,
      region:"corse",
      open: true,
      text:"http://www.fiore-corse.fr/formations/recherche-formations.html"
    },{
      lat: 48.692054,
      lng: 6.184417,
      region:"grandEst",
      open: true,
      text:"https://formation.grandest.fr/"
    },{
      lat: 50.633333,
      lng: 3.066667,
      region:"hautsDeFrance",
      open: true,
      text:"https://cleor.c2rp.fr/recherche/formations/etape/1"+"\n"+"https://www.c2rp.fr/formations"
    },{
      lat: 48.866667,
      lng: 2.333333,
      region:"iledeFrance",
      open: true,
      text: "https://www.defi-metiers.fr/oaio/formation"+"\n"+"https://www.oriane.info/recherche?type_recherche=formation&ss_type_formation=initiale"
    },{
      lat: 49.443232,
      lng: 1.099971,
      region:"normandie",
      open: true,
      text:"https://www.trouvermaformation.fr/"+"\n"+"https://normandie.cleor.org/"+"\n"+"https://parcours-metier.normandie.fr/recherche-formation"
    },
    {
      lat: 44.837789,
      lng: -0.57918,
      region:"nouvelleAquitaine",
      open: true,
      text:"https://entrepot.aquitaine-cap-metiers.fr/recherche/accueil/"
    },{
      lat: 43.600000,
      lng: 1.433333,
      region:"occitanie",
      open: true,
      text:"https://www.meformerenregion.fr/recherche?k=formations&f%5B0%5D=",
    },{
      lat: 47.218371,
      lng: -1.553621,
      region:"paysdelaLoire",
      open: true,
      text:"https://pro.choisirmonmetier-paysdelaloire.fr/donnees/recherche-formation/"
    },{
      lat: 43.300000,
      lng: 5.400000,
      region:"provenceAlpesCôtedAzur",
      open: true,
      text:"https://www.orientation-regionsud.fr/Formation/"
    },
  ];

  constructor(private http: HttpClient) { }

  ngAfterViewInit(): void {

    const myfrugalmap = L.map('map').setView([46.227638, 2.213749], 6);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Frugal Map'
    }).addTo(myfrugalmap);

    const myIcon = L.icon({
      iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png'
    });

    this.list.forEach(podotactile => {
        L.marker([podotactile.lat, podotactile.lng], {icon: myIcon}).addTo(myfrugalmap).bindPopup(podotactile.text);

      });

  }




}
