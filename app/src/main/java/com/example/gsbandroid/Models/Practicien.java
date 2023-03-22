package com.example.gsbandroid.Models;

import java.util.Collection;

public class Practicien {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private String tel;
    private String mail;
    private int coefNotoriete;
    private Collection<Visite> visites;
    private Collection<Visiteur> visiteurs;

    public Practicien(int id, String nom, String prenom, String adresse, String cp, String ville, String tel, String mail, int coefNotoriete, Collection<Visite> visites, Collection<Visiteur> visiteurs) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.coefNotoriete = coefNotoriete;
        this.visites = visites;
        this.visiteurs = visiteurs;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(int coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public Collection<Visite> getVisites() {
        return visites;
    }

    public void setVisites(Collection<Visite> visites) {
        this.visites = visites;
    }

    public Collection<Visiteur> getVisiteurs() {
        return visiteurs;
    }

    public void setVisiteurs(Collection<Visiteur> visiteurs) {
        this.visiteurs = visiteurs;
    }
}