(window.webpackJsonp=window.webpackJsonp||[]).push([[8],{ANEU:function(t,e,i){"use strict";i.d(e,"a",(function(){return r}));var n=i("fXoL"),o=i("tk/3"),c=i("ej43");let r=(()=>{class t{constructor(t,e){this.htttpClient=t,this.userConnect=e,this.hostTest="http://localhost:9004/microservice-tests"}saveListMetierClient(t,e){return this.htttpClient.post(t,e.valueOf())}modifListMetierClient(t,e){return this.htttpClient.put(t,e.valueOf())}getFicheMetierClient(){return this.htttpClient.get(this.hostTest+"/getMetierByClient/"+this.userConnect.userAuthenticated.num)}getQuestionnaireProfileU(){return this.htttpClient.get(this.hostTest+"/listQuestion/")}saveProfilU(t){return this.htttpClient.post(this.hostTest+"/saveClientRa/",t.valueOf())}getResultatProfileU(){return this.htttpClient.get(this.hostTest+"/questionClient/"+this.userConnect.userAuthenticated.num)}getRestitusionProfilU(){return this.htttpClient.get(this.hostTest+"/restitusionAll/")}getRestitusionProfilUByPosAndDim(t,e){return this.htttpClient.get(this.hostTest+"/restitusionByDimAndPos/"+t+"/"+e)}saveCompetence(t){return this.htttpClient.post(this.hostTest+"/saveListCompetences/",t.valueOf())}getCompetence(){return this.htttpClient.get(this.hostTest+"/listCompetences/")}getCompetenceById(t){return this.htttpClient.get(this.hostTest+"/getCompetenceById/"+t)}getCompetenceByCompetence(t){return this.htttpClient.get(this.hostTest+"/getCompetenceByCompetence/"+t)}saveCompetenceClient(t){return this.htttpClient.post(this.hostTest+"/saveListCompetencesClient/",t.valueOf())}getCompetenceClient(){return this.htttpClient.get(this.hostTest+"/getCompetenceClientByIdClient/"+this.userConnect.userAuthenticated.num)}}return t.\u0275fac=function(e){return new(e||t)(n.cc(o.a),n.cc(c.a))},t.\u0275prov=n.Nb({token:t,factory:t.\u0275fac,providedIn:"root"}),t})()},E5Q8:function(t,e,i){"use strict";i.r(e),i.d(e,"CvModule",(function(){return V}));var n=i("ofXK"),o=i("zioG"),c=i("LPYB"),r=i("3Pt+"),s=i("NFeN"),l=i("bTqV"),a=i("bSwM"),h=i("kmnG"),b=i("QibW"),u=i("qFsG"),d=i("0TzO"),f=i("tyNb"),m=i("l0mC");class p{constructor(t,e,i,n,o,c,r,s,l){this.nom=t,this.metier=e,this.competence=i,this.experience=n,this.diplome=o,this.adresse=c,this.mail=r,this.mobile=s,this.photo=l}}var g=i("+z1p"),C=i("fXoL"),A=i("tk/3"),v=i("Jmk/"),M=i("ej43"),k=i("ANEU");function X(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc(2).onChange(e)})),C.Wb()}if(2&t){const t=C.kc(2);C.oc("data",t.currentCv.metier),C.nc("editor",t.Editor)}}function P(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc(2).onChange(e)})),C.Wb()}if(2&t){const t=C.kc(2);C.oc("data",t.currentCv.nom),C.nc("editor",t.Editor)}}function E(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc(2).finModif()})),C.Jc(1,"Valider"),C.Wb()}}function x(t,e){if(1&t&&(C.Xb(0,"div"),C.Hc(1,X,1,2,"ckeditor",10),C.Hc(2,P,1,2,"ckeditor",10),C.Hc(3,E,2,0,"button",11),C.Wb()),2&t){const t=C.kc();C.Db(1),C.nc("ngIf",t.modifMetier),C.Db(1),C.nc("ngIf",t.modifNom),C.Db(1),C.nc("ngIf",t.bouttonActif)}}function N(t,e){if(1&t){const t=C.Yb();C.Xb(0,"img",18),C.gc("click",(function(){return C.Ac(t),C.kc(),C.yc(14).click()})),C.Wb()}if(2&t){const t=C.kc();C.nc("src",t.cheminImage,C.Cc)}}function W(t,e){if(1&t){const t=C.Yb();C.Xb(0,"h3"),C.Xb(1,"a",19),C.gc("click",(function(){return C.Ac(t),C.kc().modif("competences")})),C.Jc(2,"COMPETENCES PROFESSIONNELLES"),C.Wb(),C.Wb()}if(2&t){const t=C.kc();C.Db(1),C.Gc("color",t.colorNewText)}}function D(t,e){if(1&t&&C.Sb(0,"P",20),2&t){const t=C.kc();C.nc("innerHTML",t.currentCv.competence,C.Bc)}}function T(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.experience),C.nc("editor",t.Editor)}}function I(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc().finModif()})),C.Jc(1,"Valider"),C.Wb()}}function w(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.adresse),C.nc("editor",t.Editor)}}function O(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.mail),C.nc("editor",t.Editor)}}function S(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.mobile),C.nc("editor",t.Editor)}}function J(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc().finModif()})),C.Jc(1,"Valider"),C.Wb()}}function L(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.photo),C.nc("editor",t.Editor)}}function y(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc().finModif()})),C.Jc(1,"Valider"),C.Wb()}}function H(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc().onChange(e)})),C.Wb()}if(2&t){const t=C.kc();C.oc("data",t.currentCv.competence),C.nc("editor",t.Editor)}}function R(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc().finModif()})),C.Jc(1,"Valider"),C.Wb()}}function B(t,e){if(1&t){const t=C.Yb();C.Xb(0,"a",19),C.gc("click",(function(){return C.Ac(t),C.kc(2).modif("nom")})),C.Sb(1,"h1",29),C.Wb()}if(2&t){const t=C.kc(2);C.Db(1),C.Gc("color",t.colorNewTextNom),C.nc("innerHTML",t.currentCv.nom,C.Bc)}}function _(t,e){if(1&t&&(C.Xb(0,"div"),C.Xb(1,"h1"),C.Jc(2),C.Wb(),C.Wb()),2&t){const t=C.kc(2);C.Db(1),C.Gc("color",t.colorNewTextNom),C.Db(1),C.Mc("",t.nomClient,"\xa0",t.premomClient,"")}}function U(t,e){if(1&t){const t=C.Yb();C.Xb(0,"a",19),C.gc("click",(function(){return C.Ac(t),C.kc(2).modif("metier")})),C.Sb(1,"h3",29),C.Wb()}if(2&t){const t=C.kc(2);C.Db(1),C.Gc("color",t.colorNewTextMetier),C.nc("innerHTML",t.currentCv.metier,C.Bc)}}function G(t,e){if(1&t){const t=C.Yb();C.Xb(0,"ckeditor",17),C.gc("change",(function(e){return C.Ac(t),C.kc(2).onChange(e)})),C.Wb()}if(2&t){const t=C.kc(2);C.oc("data",t.currentCv.diplome),C.nc("editor",t.Editor)}}function Y(t,e){if(1&t){const t=C.Yb();C.Xb(0,"button",1),C.gc("click",(function(){return C.Ac(t),C.kc(2).finModif()})),C.Jc(1,"Valider"),C.Wb()}}function q(t,e){if(1&t){const t=C.Yb();C.Xb(0,"div",21),C.Xb(1,"div",22),C.Hc(2,B,2,3,"a",23),C.Hc(3,_,3,4,"div",4),C.Hc(4,U,2,3,"a",23),C.Wb(),C.Xb(5,"div",24),C.Xb(6,"a",12),C.gc("click",(function(){return C.Ac(t),C.kc().modif("experience")})),C.Xb(7,"h3",25),C.Jc(8,"EXPERIENCES PROFESSIONNELLES"),C.Wb(),C.Wb(),C.Sb(9,"P",26),C.Wb(),C.Xb(10,"div",27),C.Xb(11,"a",19),C.gc("click",(function(){return C.Ac(t),C.kc().modif("diplomes")})),C.Xb(12,"h3"),C.Jc(13,"DIPL\xd4MES"),C.Wb(),C.Wb(),C.Sb(14,"P",28),C.Wb(),C.Hc(15,G,1,2,"ckeditor",10),C.Hc(16,Y,2,0,"button",11),C.Wb()}if(2&t){const t=C.kc();C.Db(1),C.Gc("background-color",t.colorNew2),C.Db(1),C.nc("ngIf",!t.userConnectClient),C.Db(1),C.nc("ngIf",t.userConnectClient),C.Db(1),C.nc("ngIf",!t.userConnectClient),C.Db(3),C.Gc("background-color",t.colorNew)("color",t.colorNewText),C.Db(2),C.nc("innerHTML",t.currentCv.experience,C.Bc),C.Db(3),C.Gc("background-color",t.colorNew)("color",t.colorNewText),C.Db(2),C.nc("innerHTML",t.currentCv.diplome,C.Bc),C.Db(1),C.nc("ngIf",t.modifDiplom),C.Db(1),C.nc("ngIf",t.bouttonActif4)}}const F=[{path:"",data:{breadcrumb:"newCv"},children:[{path:"",data:{breadcrumb:null},component:m.a},{path:"monCv",data:{breadcrumb:"Mon Cv"},children:[{path:"",data:{breadcrumb:null},component:(()=>{class t{constructor(t,e,i,n){this.http=t,this.clientService=e,this.userConnect=i,this.bnbecome=n,this.currentCv=new p("LAURA MONTREUIL"," ASSISTANTE DE DIRECTION","<h4>Accueil et communication :</h4><ul><li>Accueil t\xe9l\xe9phonique et physique de la client\xe8le</li><li>Traiter l'information et orienter les clients vers le bon interlocuteur</li><li>Relance client et gestion de la relation SAV</li><li>Assurer la transmission des informations en interne et en externe (d\xe9cisions, notes...) </li><li>Contribuer \xe0 la mise en \u0153uvre d'actioons de communications</li><li>Communiquer \xe0 l'\xe9crit et \xe0 l'oral en fran\xe7ais et en anglais</li></ul><h4>Administratif et gestion :</h4><ul><li>Saisir des documents num\xe9riques</li><li>R\xe9aliser les commandes de mat\xe9riel, de fournitures, de consommables et v\xe9rifier la conformit\xe9 des livraisons</li><li>R\xe9diger les devis, conventions et factures </li><li>Actualiser la documentation professionnelle et r\xe9glementaire</li><li>Veille informatique et r\xe9glementaire</li>\n<li>Contribuer \xe0 la gestion administrative des RH</li><li>Connaissances sur Photoshop, Premi\xe8re pro et Sony Vegas Pro (retouches photos, montage vid\xe9o)</li></ul><h4>Comp\xe9tences linguistiques :</h4><ul ><li> Arabe : Niveau C2</li><li>Fran\xe7ais : Niveau C1</li><li>Anglais : Niveau B2</li></ul><h4>Mobilit\xe9 :</h4><ul ><li>Permis B et v\xe9hicul\xe9e</li><li>Mobilit\xe9 d\xe9partementale / r\xe9gionale / nationale / internationale</li><li>En cours de mobilit\xe9 \xe0 Alger</li></ul><h4>Accomplissements / Centres d'inter\xeat :</h4><ul ><li>Sport pratiqu\xe9 -  Loisirs (lecture, cin\xe9ma, jeux vid\xe9o\u2026) \u2013 Passions \u2013 Engagement associatif </li></ul>"," <h4>Vendeuse polyvalente \xe9v\xe9nementiel</h4><p>SOLARY PRODUCTION \xc0 TOURS</p><p>Diverses missions accomplies en 2019 lors d'\xe9v\xe8nements gaming et E-sportif tels que la Paris Games Week</p><h4>Entraineur de gymnastique artistique</h4><p>AS CHANCEAUX GYMNASTIQUE \xc0 CHANCEAUX SUR CHOISILLE</p><p>En formation BPJEPS de Septembre 2018 \xe0 f\xe9vrier 2019</p><h4>Assistante de direction</h4><p>ALPMA FRANCE \xc0 LANGEAIS</p><p>En contrat d'apprentissage d'octobre 2017 \xe0 avril 2018</p><h4>Employ\xe9e polyvalente</h4><p>MCDONALD'S \xc0 AMIENS</p><p>Janvier \xe0 Juin 2017</p><p>QUICK \xc0 AMIENS </p><p>Octobre 2014 \xe0 Mars 2016 en contrat \xe9tudiant</p><h4>Femme de chambre</h4><p>MISTER BED \xc0 RANG-DU-FLIERS (62)</p><p>En ao\xfbt 2013, contrat saisonnier</p>"," <h4>ASSISTANTE DE DIRECTION</h4><p>LANGUES ETRANGERES APPLIQUEES</p>\n<p>PREMI\xc8RE ANN\xc9E UPJV AMIENS EN 2016</p><p>Anglais et Italien</p><h4>BACCALAUREAT LITTERAIRE</h4><p>LYC\xc9E JAN LAVEZZARI  EN 2014</p><p>Option droit et grands enjeux du monde contemporain</p>","<ul><li>1 rue de la chambrerie, 37100 TOURS</li></ul>","<ul><li>laura.montreuil@hotmail.fr</li></ul>","<ul><li>06.74.76.96.36</li></ul>","assets/img/portrai.jpg"),this.modifNom=!1,this.modifMetier=!1,this.modifCom=!1,this.modifProf=!1,this.modifPhoto=!1,this.modifDiplom=!1,this.modifAdresse=!1,this.modifMail=!1,this.modifPhone=!1,this.bouttonActif=!1,this.bouttonActif2=!1,this.bouttonActif3=!1,this.bouttonActif4=!1,this.bouttonActif5=!1,this.bouttonActif6=!1,this.cheminImage="/assets/img/portrai.jpg",this.fileToUpload=null,this.colorBotton2="#bdc3c7",this.colorBotton1="#bdc3c7",this.metierValide=[],this.listByMetierSelect=[],this.metier=[],this.Editor=g,this.selectedFile=null,this.colorNew="pink",this.colorNew2="#1f46c1",this.colorNewText="#1f46c1",this.colorNewTextNom="pink",this.colorNewTextMetier="#ffffff",i.userAuthenticated&&(this.userConnectClient=i.userAuthenticated)}ngOnInit(){this.userConnect.userAuthenticated&&(this.nomClient=this.userConnect.userAuthenticated.nom,this.premomClient=this.userConnect.userAuthenticated.prenom,this.listFicheMetierClient())}onReady(t){t.ui.getEditableElement().parentElement.insertBefore(t.ui.view.toolbar.element,t.ui.getEditableElement())}maxlength(t){t.editor.getTotalLength()>500&&t.editor.deleteText(500,t.editor.getLength())}onChange({editor:t}){this.modifCom&&(this.currentCv.competence=t.getData()),this.modifMetier&&(this.currentCv.metier=t.getData()),this.modifNom&&(this.currentCv.nom=t.getData()),this.modifAdmin&&(this.currentCv.administration=t.getData()),this.modifProf&&(this.currentCv.experience=t.getData()),this.modifDiplom&&(this.currentCv.diplome=t.getData()),this.modifAdresse&&(this.currentCv.adresse=t.getData()),this.modifMail&&(this.currentCv.mail=t.getData()),this.modifPhone&&(this.currentCv.mobile=t.getData()),this.modifPhoto&&(this.cheminImage=t.getData())}modif(t){"metier"===t&&(this.bouttonActif=!this.bouttonActif,this.modifMetier=!this.modifMetier),"nom"===t&&(this.bouttonActif=!this.bouttonActif,this.modifNom=!this.modifNom),"competences"===t&&(this.bouttonActif2=!this.bouttonActif2,this.modifCom=!this.modifCom),"experience"===t&&(this.bouttonActif3=!this.bouttonActif3,this.modifProf=!this.modifProf),"diplomes"===t&&(this.bouttonActif4=!this.bouttonActif4,this.modifDiplom=!this.modifDiplom),"adresse"===t&&(this.modifMail||this.modifPhone||(this.bouttonActif5=!this.bouttonActif5),this.modifAdresse=!this.modifAdresse),"mail"===t&&(this.modifAdresse||this.modifPhone||(this.bouttonActif5=!this.bouttonActif5),this.modifMail=!this.modifMail),"phone"===t&&(this.modifAdresse||this.modifMail||(this.bouttonActif5=!this.bouttonActif5),this.modifPhone=!this.modifPhone),"photo"===t&&(this.bouttonActif6=!this.bouttonActif6,this.modifPhoto=!this.modifPhoto)}finModif(){this.bouttonActif=!1,this.bouttonActif2=!1,this.bouttonActif3=!1,this.bouttonActif4=!1,this.bouttonActif5=!1,this.bouttonActif6=!1,this.modifPhoto=!1,this.modifNom=!1,this.modifMetier=!1,this.modifCom=!1,this.modifAdmin=!1,this.modifProf=!1,this.modifDiplom=!1,this.modifAdresse=!1,this.modifMail=!1,this.modifPhone=!1,this.modifPhone=!1}onFileSelected(t){console.log(t),this.selectedFile=t.target.files[0],this.newImage=t.target.value}handleFinInput(t){console.log(t),this.fileToUpload=t.item(0);var e=new FileReader;e.onload=t=>{this.cheminImage=t.target.result},e.readAsDataURL(this.fileToUpload)}changeColor(){switch(this.colorNew){case"pink":this.colorBotton1="#1f46c1",this.colorNew="#bdc3c7",this.colorNewText="#1f46c1";break;case"#bdc3c7":this.colorBotton1="pink",this.colorNew="#1f46c1",this.colorNewText="#ffffff";break;case"#1f46c1":this.colorBotton1="#bdc3c7",this.colorNew="pink",this.colorNewText="#1f46c1";break;default:this.colorBotton1="#bdc3c7",this.colorNew="pink",this.colorNewText="#1f46c1"}}changeColor2(){switch(this.colorNew2){case"#1f46c1":this.colorBotton2="pink",this.colorNew2="#bdc3c7",this.colorNewTextNom="#1f46c1",this.colorNewTextMetier="#1f46c1";break;case"#bdc3c7":this.colorBotton2="#1f46c1",this.colorNew2="pink",this.colorNewTextNom="#1f46c1";break;case"pink":this.colorBotton2="#bdc3c7",this.colorNew2="#1f46c1",this.colorNewTextNom="#ffffff",this.colorNewTextMetier="#ffffff";break;default:this.colorBotton2="#bdc3c7",this.colorNew2="#1f46c1",this.colorNewText="#ffffff",this.colorNewTextMetier="#ffffff"}}listFicheMetierClient(){this.bnbecome.getFicheMetierClient().subscribe(t=>{this.ficheClient=t,this.ficheClient.valide.forEach(t=>{1==t.etat&&this.metierValide.push(t)}),this.ficheClient.ficheMetiers.forEach(t=>{let e=t.id;this.metierValide.forEach(i=>{i.id==e&&this.metier.push(t)})}),this.getMetierSelection(this.metierValide,this.ficheClient)},t=>{console.log(t)})}getMetierSelection(t,e){t.forEach(t=>{1==t.selection&&e.ficheMetiers.forEach(e=>{e.id==t.id&&this.listByMetierSelect.push(e)})})}}return t.\u0275fac=function(e){return new(e||t)(C.Rb(A.a),C.Rb(v.a),C.Rb(M.a),C.Rb(k.a))},t.\u0275cmp=C.Lb({type:t,selectors:[["app-mon-cv"]],decls:39,vars:35,consts:[[1,"container"],["type","button",1,"btn","btn-success",3,"click"],[1,"row"],[1,"competences","col-lg-4"],[4,"ngIf"],["class","portrait","alt"," ","title","Cliquez ici pour changer la photo",3,"src","click",4,"ngIf"],["type","file","accept","image/*",2,"display","none",3,"change"],["Image","","fileInput",""],["class","competences",3,"innerHTML",4,"ngIf"],[1,"editorExperience"],[3,"editor","data","change",4,"ngIf"],["type","button","class","btn btn-success",3,"click",4,"ngIf"],[3,"click"],["title","Cliquez ici pour modifier",3,"innerHTML"],[1,"editorText","col-lg-8"],["class","presentations col-lg-8",4,"ngIf"],[1,"basPage","col-lg-12"],[3,"editor","data","change"],["alt"," ","title","Cliquez ici pour changer la photo",1,"portrait",3,"src","click"],["title","Cliquez ici pour modifier",3,"click"],[1,"competences",3,"innerHTML"],[1,"presentations","col-lg-8"],[1,"presentation"],["title","Cliquez ici pour modifier",3,"click",4,"ngIf"],[1,"experiences"],["title","Cliquez ici pour modifier"],[1,"experience",3,"innerHTML"],[1,"diplomes"],[1,"diplome",3,"innerHTML"],[3,"innerHTML"]],template:function(t,e){1&t&&(C.Xb(0,"div",0),C.Xb(1,"button",1),C.gc("click",(function(){return e.changeColor()})),C.Jc(2,"new color"),C.Wb(),C.Xb(3,"button",1),C.gc("click",(function(){return e.changeColor2()})),C.Jc(4,"new color"),C.Wb(),C.Xb(5,"P"),C.Jc(6),C.Wb(),C.Xb(7,"div",2),C.Xb(8,"div",3),C.Hc(9,x,4,3,"div",4),C.Xb(10,"form"),C.Hc(11,N,1,1,"img",5),C.Xb(12,"input",6,7),C.gc("change",(function(t){return e.handleFinInput(t.target.files)})),C.Wb(),C.Wb(),C.Hc(15,W,3,2,"h3",4),C.Hc(16,D,1,1,"P",8),C.Xb(17,"div",9),C.Hc(18,T,1,2,"ckeditor",10),C.Hc(19,I,2,0,"button",11),C.Wb(),C.Xb(20,"h4"),C.Jc(21,"Contact"),C.Wb(),C.Xb(22,"a",12),C.gc("click",(function(){return e.modif("adresse")})),C.Sb(23,"div",13),C.Wb(),C.Xb(24,"a",12),C.gc("click",(function(){return e.modif("mail")})),C.Sb(25,"div",13),C.Wb(),C.Xb(26,"a",12),C.gc("click",(function(){return e.modif("phone")})),C.Sb(27,"div",13),C.Wb(),C.Hc(28,w,1,2,"ckeditor",10),C.Hc(29,O,1,2,"ckeditor",10),C.Hc(30,S,1,2,"ckeditor",10),C.Hc(31,J,2,0,"button",11),C.Wb(),C.Xb(32,"div",14),C.Hc(33,L,1,2,"ckeditor",10),C.Hc(34,y,2,0,"button",11),C.Hc(35,H,1,2,"ckeditor",10),C.Hc(36,R,2,0,"button",11),C.Wb(),C.Hc(37,q,17,17,"div",15),C.Sb(38,"div",16),C.Wb(),C.Wb()),2&t&&(C.Db(1),C.Gc("background-color",e.colorBotton1),C.Db(2),C.Gc("background-color",e.colorBotton2),C.Db(3),C.Kc(null==e.nomClient2?null:e.nomClient2.nom),C.Db(2),C.Gc("background-color",e.colorNew)("color",e.colorNewText),C.Db(1),C.nc("ngIf",e.bouttonActif),C.Db(2),C.nc("ngIf",!e.bouttonActif),C.Db(4),C.nc("ngIf",!e.modifProf),C.Db(1),C.nc("ngIf",!e.modifProf),C.Db(2),C.nc("ngIf",e.modifProf),C.Db(1),C.nc("ngIf",e.bouttonActif3),C.Db(4),C.Gc("color",e.colorNewText),C.nc("innerHTML",e.currentCv.adresse,C.Bc),C.Db(2),C.Gc("color",e.colorNewText),C.nc("innerHTML",e.currentCv.mail,C.Bc),C.Db(2),C.Gc("color",e.colorNewText),C.nc("innerHTML",e.currentCv.mobile,C.Bc),C.Db(1),C.nc("ngIf",e.modifAdresse),C.Db(1),C.nc("ngIf",e.modifMail),C.Db(1),C.nc("ngIf",e.modifPhone),C.Db(1),C.nc("ngIf",e.bouttonActif5),C.Db(2),C.nc("ngIf",e.modifPhoto),C.Db(1),C.nc("ngIf",e.bouttonActif6),C.Db(1),C.nc("ngIf",e.modifCom),C.Db(1),C.nc("ngIf",e.bouttonActif2),C.Db(1),C.nc("ngIf",!e.modifCom),C.Db(1),C.Gc("background-color",e.colorNew2))},directives:[n.j,r.z,r.o,r.p,o.a],styles:["ul[_ngcontent-%COMP%]{list-style-type:circle;margin-top:10px;margin-bottom:20px}.competences[_ngcontent-%COMP%]{height:100%}.competences[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%]{text-align:center;margin-bottom:20px}.competences[_ngcontent-%COMP%]   h4[_ngcontent-%COMP%]{margin-bottom:10px}h3[_ngcontent-%COMP%]:hover{color:green}.presentation[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%]{color:#fff}.presentation[_ngcontent-%COMP%]{padding-bottom:30px;padding-top:30px;text-align:center}.diplomes[_ngcontent-%COMP%], .experiences[_ngcontent-%COMP%]{margin-left:80px;margin-bottom:20px}.diplomes[_ngcontent-%COMP%]   p[_ngcontent-%COMP%], .experiences[_ngcontent-%COMP%]   p[_ngcontent-%COMP%]{color:#1f46c1}.diplomes[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%], .experiences[_ngcontent-%COMP%]   h3[_ngcontent-%COMP%]{margin-bottom:20px;margin-top:20px;padding-bottom:10px;padding-top:10px}.diplomes[_ngcontent-%COMP%]   h4[_ngcontent-%COMP%], .experiences[_ngcontent-%COMP%]   h4[_ngcontent-%COMP%]{padding-bottom:10px;padding-top:10px;font-weight:700}.basPage[_ngcontent-%COMP%]{height:30px}.portrait[_ngcontent-%COMP%]{padding-top:20px;width:200px;height:150px;margin-left:80px}.btn[_ngcontent-%COMP%]{margin-left:10px;margin-right:10px;margin-top:5px}.editorExperience[_ngcontent-%COMP%]{margin-top:20px}a[_ngcontent-%COMP%]{text-decoration:none}a[_ngcontent-%COMP%]:hover, h1[_ngcontent-%COMP%]:hover{color:red}"]}),t})()}]},{path:"CvExpert",data:{breadcrumb:"Cv Expert"},children:[{path:"",data:{breadcrumb:null},component:(()=>{class t{constructor(){this.photoExpert="assets/img/cvexpert2.png",this.photoExpert2="assets/img/cvexpert1.png",this.photoExpert3="assets/img/cvexpert3.jpg",this.photoExpert4="assets/img/cvexpert4.jpg",this.photoExpert5="assets/img/cvexpert5.jpg"}ngOnInit(){}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=C.Lb({type:t,selectors:[["app-cv-expert"]],decls:70,vars:4,consts:[[1,"container"],[1,"photo1",3,"src"],[1,"item"],[1,"photo2",3,"src"],[1,"photo3",3,"src"]],template:function(t,e){1&t&&(C.Xb(0,"div",0),C.Sb(1,"img",1),C.Xb(2,"ul"),C.Xb(3,"li"),C.Jc(4,"XXXXXX"),C.Wb(),C.Xb(5,"li"),C.Jc(6,"93 rue XXXX"),C.Wb(),C.Xb(7,"li"),C.Jc(8,"91000 \u2013 XXXXXX"),C.Wb(),C.Xb(9,"li"),C.Jc(10,"06 12 00 00 00"),C.Wb(),C.Xb(11,"li"),C.Jc(12,"zhemarid@gmail.com"),C.Wb(),C.Xb(13,"li"),C.Jc(14,"29 ans, mari\xe9e, 2 enfants "),C.Wb(),C.Wb(),C.Xb(15,"div",2),C.Xb(16,"h2"),C.Jc(17,"Responsable Projet Fonctionnel"),C.Wb(),C.Sb(18,"img",3),C.Xb(19,"p"),C.Jc(20,"Conduire et accompagner le changement"),C.Wb(),C.Wb(),C.Wb(),C.Xb(21,"div",0),C.Xb(22,"h2"),C.Jc(23,"Domaines de comp\xe9tences"),C.Wb(),C.Xb(24,"h4"),C.Jc(25,"Management"),C.Wb(),C.Sb(26,"img",4),C.Xb(27,"p"),C.Xb(28,"b"),C.Jc(29,"Mobilisation, motivation, d\xe9veloppement, contr\xf4le"),C.Wb(),C.Jc(30," : Mise en place de points face \xe0 face r\xe9guliers, animation des r\xe9unions de service, animation des entretiens individuels, repositionnement d\u2019un service support au service de ses clients."),C.Wb(),C.Xb(31,"p"),C.Xb(32,"b"),C.Jc(33,"Gestion de la performance"),C.Wb(),C.Jc(34," : Mise en place de tableaux d\u2019activit\xe9 (usine visuelle)."),C.Wb(),C.Xb(35,"p"),C.Xb(36,"b"),C.Jc(37,"Animation d\u2019\xe9quipe"),C.Wb(),C.Jc(38," service ou projet (15 personnes Ing\xe9nieurs techniciens assistantes)."),C.Wb(),C.Xb(39,"p"),C.Xb(40,"b"),C.Jc(41,"Gestion de projet et d\u2019activit\xe9 du service"),C.Wb(),C.Jc(42," : D\xe9finir les priorit\xe9s d\u2019action et d\u2019allocation des moyens, des ressources dans le respect des d\xe9lais. Cas concret : Changement des outils informatiques qualit\xe9 (480 personnes impact\xe9es)"),C.Wb(),C.Xb(43,"h4"),C.Jc(44,"Conduite et accompagnement du changement"),C.Wb(),C.Sb(45,"img",4),C.Xb(46,"p"),C.Xb(47,"b"),C.Jc(48,"Analyse des processus"),C.Wb(),C.Jc(49," avant et apr\xe8s le changement (Analyse des processus de gestion documentaire 5000 documents, gestion des demandes de changement, des d\xe9viations, actions correctives et pr\xe9ventives, des plans de formation)"),C.Wb(),C.Xb(50,"p"),C.Xb(51,"b"),C.Jc(52,"Ecoute et analyse les freins et les r\xe9sistances"),C.Wb(),C.Jc(53," pour les att\xe9nuer."),C.Wb(),C.Xb(54,"p"),C.Xb(55,"b"),C.Jc(56,"Coordination et mise \xe0 jour des documents associ\xe9s"),C.Wb(),C.Jc(57," Modes op\xe9ratoires et proc\xe9dures."),C.Wb(),C.Xb(58,"p"),C.Xb(59,"b"),C.Jc(60,"Elaboration du plan de communication"),C.Wb(),C.Jc(61," aupr\xe8s de la direction, des managers et des utilisateurs."),C.Wb(),C.Xb(62,"p"),C.Xb(63,"b"),C.Jc(64,"Elaboration du plan de formation"),C.Wb(),C.Jc(65," (480 personnes)."),C.Wb(),C.Xb(66,"p"),C.Xb(67,"b"),C.Jc(68,"Faire du reporting"),C.Wb(),C.Jc(69," aupr\xe8s de la direction."),C.Wb(),C.Wb()),2&t&&(C.Db(1),C.nc("src",e.photoExpert,C.Cc),C.Db(17),C.nc("src",e.photoExpert2,C.Cc),C.Db(8),C.nc("src",e.photoExpert3,C.Cc),C.Db(19),C.nc("src",e.photoExpert4,C.Cc))},styles:[".container[_ngcontent-%COMP%]{display:flex;flex-direction:row;flex-wrap:wrap;justify-content:space-evenly}.photo1[_ngcontent-%COMP%]{width:auto}.photo1[_ngcontent-%COMP%], .photo2[_ngcontent-%COMP%]{height:40%}ul[_ngcontent-%COMP%]{list-style-type:none}.photo3[_ngcontent-%COMP%]{float:left}"]}),t})()}]}]}];let j=(()=>{class t{}return t.\u0275mod=C.Pb({type:t}),t.\u0275inj=C.Ob({factory:function(e){return new(e||t)},imports:[[f.i.forChild(F)],f.i]}),t})(),V=(()=>{class t{}return t.\u0275mod=C.Pb({type:t}),t.\u0275inj=C.Ob({factory:function(e){return new(e||t)},imports:[[n.b,o.b,c.b,r.u,s.b,l.b,a.b,h.d,b.c,u.b,d.a,j,r.j]]}),t})()}}]);