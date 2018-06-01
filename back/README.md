1- Dépendances :
==

* maven v3+
* java v1.8+
* mysql v5.7+

2- Installation :
==

* Se connecter à mysql
* Créer la base de données  
    create database db_example;
* Créer l'utilisateur Spring  
    create user 'springuser'@'localhost' identified by 'ThePassword';
* Ajouter les droits à l'utilisateur spring sur la base  
    grant all on db_example.* to 'springuser'@'localhost';
 
3- Remplacer les informations contenues dans application.properties
== 

Comming soon, paramétrage de application.properties avec un fichier .env

4- Démarrer via intellij idea
==

Comming soon, la démarrer sans intellij