# Watt Of Africa
### Projet de site pour les usagers.
<p>S’inscrire,
<p>Passer des tests et exercices,
<p>Mettre en place des outils d’analyse,
<p>Des conseils pratiques.

#### Architecture de l'application
<p>Le projet est découpé en microservices:
<ul>
    <li>config-server: appelle un repo git avec les configurations des serveurs</li>
    <li>eureka-server: lie les services avec eureka</li>
    <li>zuul-server: API Gateway</li>
    <li>microservice-librairie: services contient les livres et emprunts, BDD librairie</li>
    <li>microservice-utilisateur: services contient les utilisateurs et roles, BDD users</li>  
    
</ul>

### Deploiement

<ol>
 <li>Installer le JDK d'Oracle 1.8 </li>
 <li>Cloner le répertoire</li>
   <li>Installer Maven version minimum 2.</li>  
   <li>Créez un repository github pour le dossier config-repo-wattofafrica</li>
   <li>Dans le service config-server, modifiez src\main\resources\application.properties: 
   spring.cloud.config.server.git.uri= l'adresse de votre repository</li>
   <li>Créer deux basses de données Postgresql:
           <ul>
               <li>Une tests pour le microservice-tests </li>
               <li>Une users pour le microservice-utilisateur </li>
              
           
   <li>Dans votre repo config-repo-wattofafrica,  modifier pour les trois microservices les informations suivantes:
   <ul>
      <li>le nom de votre base de données: jdbc.url = jdbc:postgresql://localhost:5432/"nom-de-la-base-de-données" </li>
      <li>votre username: jdbc.username = "username" </li>
      <li>votre mot de passe: jdbc.password = "password" </li>
   </ul>
   </li> 
 <li>Lancez les microservices:
  <ul>
      <li>config-server</li>
      <li>eureka-server</li>
      <li>zuul-server</li>
      <li>microservice-utilisateur</li>
      <li>microservice-tests</li>	  
  </ul>
<P> Démarrer la microapp ce positionner sur le wattOfAfrica</p>
 <ul>
<li>1- mvn -f config_server clean spring-boot:run</li>
<li>2- mvn -f eureka-server clean spring-boot:run</li>
<li>3- mvn -f microservice-tests clean spring-boot:run</li>
<li>4- mvn -f microservice-utilisateur clean spring-boot:run</li>
<li>5- mvn -f zuul-server clean spring-boot:run
 </ul>

<P>Front Angular placer vous sur le dossier watt
<p>Tapez  ng serve

 <li>Dans un navigateur rendez vous sur http://localhost:4200/</li>
 



