## Réponses questions

### 1. Pourquoi le mot-clé volatile est-il indispensable sur l'instance dans le DoubleChecked Locking ?
Le volatile permet d'indiquer que la variable peut être modifiée dans des threads différents donc elle est requise dans le double checked locking pour éviter les problèmes de threads.

### 2. Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est elle préférable ?
Initialisation a la demande, ou singleton enum, exemples: https://www.baeldung.com/java-singleton-double-checked-locking

### 3. Quelle est la différence entre le pattern State et un simple if/else sur un attribut enum ? Donne un avantage concret du State dans ce contexte
Le pattern State permet de changer ce qu'il se passe en fonction de l'état alors que le if/else ne rajotue que des conditions ce qui rendrait le code illisible sur cette situation, le state permet de séparer la logique.

### 4. Pourquoi faut-il appeler field.setAccessible(true) avant field.get(objet) pour les champs privés ?
Les champs privés ne sont pas accessibles donc il faut les rendre accessibles pour pouvoir les lire ou les modifier, si on ne le fait pas on aura une exception.

### 5. Cite un risque de sécurité lié à l'utilisation de setAccessible() en production
Utiliser setAccessible() en production modifie la visibilité des méthodes en runtime et peut permettre à des attaquants d'accéder à des méthodes ou des champs qui ne sont pas censés être accessibles normalement. ça peut causer des problèmes de sécurité et si il se passe quelque chose c'est encore plus compliqué de trouver le problème.

### 6. Le RestEngine lit les annotations @Rest, @Get, @Post via réflexion pour construire la table de routage. Explique en 3 lignes comment fonctionne ce mécanisme.
RestEngine utilise la réflexion pour parcourir les classes et méthodes et trouver les annotations @Rest, @Get, @Post, lorsqu'il les trouve il recupere leurs informations et construit une table pour faire le lien entre les routes et les méthodes à appeler, avec les paramètres (ex: queryparam).