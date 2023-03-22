package com.example.gsbandroid.Models;

public class Visite {
    private int id;
    private String compteRendu;
    private Visiteur visiteur;
    private Practicien praticien;

    public Visite(int id, String compteRendu, Visiteur visiteur, Practicien praticien) {
        this.id = id;
        this.compteRendu = compteRendu;
        this.visiteur = visiteur;
        this.praticien = praticien;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Practicien getPraticien() {
        return praticien;
    }

    public void setPraticien(Practicien praticien) {
        this.praticien = praticien;
    }
}