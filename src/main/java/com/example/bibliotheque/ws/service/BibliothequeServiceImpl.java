package com.example.bibliotheque.ws.service;

import com.example.bibliotheque.ws.dao.GenreDao;
import com.example.bibliotheque.ws.dao.SousGenreDao;
import com.example.bibliotheque.ws.model.Genre;
import com.example.bibliotheque.ws.model.SousGenre;

import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import java.sql.SQLException;
import java.util.List;

@WebService(
        serviceName = "BibliothequeService",
        endpointInterface = "com.example.bibliotheque.ws.service.BibliothequeService",
        targetNamespace = "http://ws.bibliotheque.example.com/"
)
public class BibliothequeServiceImpl implements BibliothequeService {

    private final GenreDao genreDao = new GenreDao();
    private final SousGenreDao sousGenreDao = new SousGenreDao();

    @Override
    public Genre ajouterGenre(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new WebServiceException("Le nom du genre est obligatoire");
        }
        try {
            return genreDao.create(nom.trim());
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de l'ajout du genre: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Genre> listerGenres() {
        try {
            return genreDao.findAll();
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors du listing des genres: " + e.getMessage(), e);
        }
    }

    @Override
    public SousGenre ajouterSousGenre(long genreId, SousGenre sousGenre) {
        if (genreId <= 0) {
            throw new WebServiceException("genreId invalide");
        }
        if (sousGenre == null || sousGenre.getNom() == null || sousGenre.getNom().isBlank()) {
            throw new WebServiceException("Le nom du sous-genre est obligatoire");
        }
        try {
            // Vérifie que le genre existe
            Genre g = genreDao.findById(genreId);
            if (g == null) {
                throw new WebServiceException("Genre introuvable pour id=" + genreId);
            }
            SousGenre created = sousGenreDao.create(genreId, sousGenre.getNom().trim(), sousGenre.getDescription());
            // Remplit le genre complet si possible
            if (created != null) {
                created.setGenre(g);
            }
            return created;
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de l'ajout du sous-genre: " + e.getMessage(), e);
        }
    }

    @Override
    public List<SousGenre> listerSousGenresParGenre(long genreId) {
        try {
            return sousGenreDao.findAllByGenreId(genreId);
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors du listing des sous-genres: " + e.getMessage(), e);
        }
    }

    @Override
    public List<SousGenre> listerTousSousGenres() {
        try {
            return sousGenreDao.findAll();
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors du listing de tous les sous-genres: " + e.getMessage(), e);
        }
    }

    @Override
    public Genre rechercherGenreParId(long id) {
        try {
            return genreDao.findById(id);
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de la recherche du genre: " + e.getMessage(), e);
        }
    }

    @Override
    public SousGenre rechercherSousGenreParId(long id) {
        try {
            return sousGenreDao.findById(id);
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de la recherche du sous-genre: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean supprimerGenre(long id) {
        try {
            return genreDao.deleteById(id);
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de la suppression du genre: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean supprimerSousGenre(long id) {
        try {
            return sousGenreDao.deleteById(id);
        } catch (SQLException e) {
            throw new WebServiceException("Erreur DB lors de la suppression du sous-genre: " + e.getMessage(), e);
        }
    }
} 