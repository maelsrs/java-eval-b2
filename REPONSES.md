## Réponses questions

### 1. Pourquoi le mot-clé volatile est-il indispensable sur l'instance dans le DoubleChecked Locking ?
Le volatile permet d'indiquer que la variable peut être modifiée dans des threads différents donc elle est requise dans le double checked locking pour éviter les problèmes de threads.

### 2. Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est elle préférable ?
Initialisation a la demande, ou singleton enum, exemples: https://www.baeldung.com/java-singleton-double-checked-locking

### 3. Quelle est la différence entre le pattern State et un simple if/else sur un attribut enum ? Donne un avantage concret du State dans ce contexte
Le pattern State permet de changer ce qu'il se passe en fonction de l'état alors que le if/else ne rajotue que des conditions ce qui rendrait le code illisible sur cette situation, le state permet de séparer la logique.

### 4.
### 5.