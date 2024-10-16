package com.book.livre.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String auteur;
    @Column
    private String edition;
    @Column
    private int nbPage;
    @Column
    private double prix;
    @Column
    private String image;
        public Livre(Long id, String title, String auteur, String edition, int nbPage, double prix,String image) {
        this.id = id;
        this.title = title;
        this.auteur = auteur;
        this.edition = edition;
        this.nbPage = nbPage;
        this.prix = prix;
         this.image = image;
    }

    public Livre(String title, String auteur, String edition, int nbPage, double prix) {
        this.title = title;
        this.auteur = auteur;
        this.edition = edition;
        this.nbPage = nbPage;
        this.prix = prix;
    }

    public Livre() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public double getPrix() {
        return this.prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auteur='" + auteur + '\'' +
                ", edition='" + edition + '\'' +
                ", nbPage='" + nbPage + '\'' +
                ", Prix=" + this.prix +
                ", image=" + this.image +
                '}';
    }
}