package com.example.gsbandroid.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Visiteur {




    @SerializedName("token")
    private String token;

    public String getToken() {
        return "Bearer " + token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Visiteur(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private int id;
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private String matricule;
    @SerializedName("portFeuille")
    private ArrayList<String> portefeuilles;





    public Visiteur(int id, String username, String password, String nom, String prenom, String adresse, String cp, String ville, String matricule) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.matricule = matricule;
        this.portefeuilles = new ArrayList<String>();
    }




    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public String getMatricule() {
        return matricule;
    }

    public ArrayList<String> getPortefeuilles() {
        return portefeuilles;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setPortefeuilles(ArrayList<String> portefeuilles) {
        this.portefeuilles = portefeuilles;
    }

}