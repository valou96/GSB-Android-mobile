package com.example.gsbandroid.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Practicien {
    @SerializedName("id")
    private int id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("adresse")
    private String adresse;
    @SerializedName("cp")
    private String cp;
    @SerializedName("ville")
    private String ville;
    @SerializedName("tel")
    private String tel;
    @SerializedName("mail")
    private String mail;
    @SerializedName("coefNotoriete")
    private int coefNotoriete;
    @SerializedName("visite")
    private Collection<String> visites;
    @SerializedName("visiteurs")
    private Collection<String> visiteurs;

    public Practicien(int id, String nom, String prenom, String adresse, String cp, String ville, String tel, String mail, int coefNotoriete, Collection<String> visites) {
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

    public Collection<String> getVisites() {
        return visites;
    }

    public void setVisites(Collection<String> visites) {
        this.visites = visites;
    }

    public Collection<String> getVisiteurs() {
        return visiteurs;
    }

    public void setVisiteurs(Collection<String> visiteurs) {
        this.visiteurs = visiteurs;
    }
}