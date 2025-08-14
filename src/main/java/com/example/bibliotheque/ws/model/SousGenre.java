package com.example.bibliotheque.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sousGenre")
@XmlAccessorType(XmlAccessType.FIELD)
public class SousGenre {
    private Long id;
    private String nom;
    private String description;

    @XmlElement(name = "genre")
    private Genre genre;

    public SousGenre() {
    }

    public SousGenre(Long id, String nom, String description, Genre genre) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
} 