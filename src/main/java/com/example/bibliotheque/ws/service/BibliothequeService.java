package com.example.bibliotheque.ws.service;

import com.example.bibliotheque.ws.model.Genre;
import com.example.bibliotheque.ws.model.SousGenre;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BibliothequeService", targetNamespace = "http://ws.bibliotheque.example.com/")
public interface BibliothequeService {

    @WebMethod
    Genre ajouterGenre(String nom);

    @WebMethod
    List<Genre> listerGenres();

    @WebMethod
    SousGenre ajouterSousGenre(long genreId, SousGenre sousGenre);

    @WebMethod
    List<SousGenre> listerSousGenresParGenre(long genreId);

    @WebMethod
    List<SousGenre> listerTousSousGenres();

    @WebMethod
    Genre rechercherGenreParId(long id);

    @WebMethod
    SousGenre rechercherSousGenreParId(long id);

    @WebMethod
    boolean supprimerGenre(long id);

    @WebMethod
    boolean supprimerSousGenre(long id);
} 