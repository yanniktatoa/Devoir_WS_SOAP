-- Créez d'abord la base (si besoin), puis sélectionnez-la
CREATE DATABASE IF NOT EXISTS bibliotheque CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bibliotheque;

-- Table des genres
CREATE TABLE IF NOT EXISTS genre (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(255) NOT NULL,
  UNIQUE KEY uq_genre_nom (nom)
) ENGINE=InnoDB;

-- Table des sous-genres
CREATE TABLE IF NOT EXISTS sous_genre (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(255) NOT NULL,
  description TEXT NULL,
  genre_id BIGINT NOT NULL,
  CONSTRAINT fk_sous_genre_genre FOREIGN KEY (genre_id)
      REFERENCES genre(id) ON DELETE CASCADE,
  UNIQUE KEY uq_sous_genre_nom (genre_id, nom)
) ENGINE=InnoDB; 