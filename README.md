# TIPIAK (pirates !)

Projet de cours visant à réaliser un clone de Blablacar.

Le projet est séparé en deux parties :
- le back, une API faite en Java avec Spring
- le front, réalisé avec VueJS

Des documents détaillant l'architecture du projet sont disponibles dans le dossier `docs`

## Back

### Pré-requis

* maven v3+
* java v1.8+
* mysql v5.7+

### Installation

* Se connecter à mysql
* Créer la base de données  
    `create database db_example;`
* Créer l'utilisateur Spring  
    `create user 'springuser'@'localhost' identified by 'ThePassword';`
* Ajouter les droits à l'utilisateur spring sur la base  
    `grant all on db_example.* to 'springuser'@'localhost';`
 
### Remplacer les informations contenues dans application.properties

Comming soon, paramétrage de `application.properties` avec un fichier `.env`

### Démarrer via intellij idea

Comming soon, la démarrer sans intellij :)

## Front

### Pré-requis

* NodeJs
* NPM

### Installation

- Installer les dépendences avec la commande `npm i`

### Usage

- Lancer la commande `npm run serve` et visiter l'url `http://localhost:8081`

### TODO

- Mettre en place un système de configuration, notamment pour determiner l'url de l'API. Pour le moment une URL de test est utilisée et renseignée en dur dans le code.

- Se brancher à l'API

- Réaliser les pages manquantes