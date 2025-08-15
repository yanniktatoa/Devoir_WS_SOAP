# Devoir_WS_SOAP
# 🚀Prérequis
    Java 17 
    maven
    maria_db
# 📁Structure du Projet

    Devoir_WS_SOAP/
    ├── pom.xml                          # Configuration Maven
    ├── README.md                        # Documentation du projet
    └── src/
        └── main/
            ├── java/
            │   └── com/example/bibliotheque/ws/
            │       ├── dao/              # Couche d'accès aux données
            │       │   ├── DBUtil.java   # Utilitaires de connexion DB
            │       │   ├── GenreDao.java # DAO pour les genres
            │       │   └── SousGenreDao.java # DAO pour les sous-genres
            │       ├── model/            # Modèles de données
            │       │   ├── Genre.java    # Entité Genre
            │       │   └── SousGenre.java # Entité SousGenre
            │       ├── service/          # Couche service
            │       │   ├── BibliothequeService.java # Interface du service
            │       │   └── BibliothequeServiceImpl.java # Implémentation
            │       └── Server.java       # Point d'entrée du serveur
            └── resources/                # Ressources de configuration
                ├── db.properties         # Configuration base de données
                └── schema.sql            # Script de création des tables
# ✨Fonctionnalités

    📕Gestion des Genres
    - Ajouter un genre : Création d'un nouveau genre littéraire
    - Lister tous les genres : Récupération de la liste complète des genres
    - Rechercher un genre par ID : Consultation d'un genre spécifique
    - Supprimer un genre : Suppression d'un genre et de tous ses sous-genres associés (cascade)

    📚Gestion des Sous-Genres
    - Ajouter un sous-genre : Création d'un sous-genre associé à un genre parent
    - Lister les sous-genres par genre : Récupération des sous-genres d'un genre spécifique
    - Lister tous les sous-genres : Consultation de l'ensemble des sous-genres
    - Rechercher un sous-genre par ID : Consultation d'un sous-genre spécifique
    - Supprimer un sous-genre : Suppression d'un sous-genre individuel

    ⚙️Caractéristiques Techniques
    - Service SOAP : Interface standardisée pour l'intégration
    - Persistance MariaDB : Stockage relationnel avec contraintes d'intégrité
    - WSDL dynamique : Description automatique du service
# 🧪Test
Exécutez cette commande

    java --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED -jar target/bibliotheque-ws-1.0.0.jar

___________________________________________________________


<img width="1483" height="298" alt="Capture d'écran 2025-08-14 145735" src="https://github.com/user-attachments/assets/d0e5c911-3ba4-45ed-8c75-2dcfe5035a05" />

______________________________________________________________

<img width="1875" height="892" alt="Capture d'écran 2025-08-14 150407" src="https://github.com/user-attachments/assets/8c28fd56-509e-4df4-a8c2-39689e7a5e75" />

_______________________________________________________________

# 🧪Test avec postman

Importer dans postman la bibliothèque wsdl qui se trouver au http://localhost:8080/bibliotheque?wsdl lorsque le service est lancé

<img width="1448" height="353" alt="Capture d'écran 2025-08-14 150703" src="https://github.com/user-attachments/assets/9b737006-00cf-4a27-bd41-47876e7945f4" />

------------------------------------------------

Quelques résultats attendus

<img width="1440" height="782" alt="Capture d'écran 2025-08-14 150936" src="https://github.com/user-attachments/assets/f0bc491d-4dd1-436d-a396-c1aa44c07767" />

_____________________________________________________________

<img width="1436" height="798" alt="Capture d'écran 2025-08-14 151137" src="https://github.com/user-attachments/assets/89be09d3-4260-4b06-853c-170248edde74" />

__________________________________________________________

<img width="1435" height="718" alt="Capture d'écran 2025-08-14 151555" src="https://github.com/user-attachments/assets/7102dda4-7b39-4bde-a049-0abff5e014ec" />

-------------------------------------------------------------

<img width="1519" height="380" alt="Capture d'écran 2025-08-14 155113" src="https://github.com/user-attachments/assets/4a18ff6f-8beb-489c-be7e-061877054c53" />
