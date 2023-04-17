package com.example.tpchifoumi.modele;

public class Choix {

    protected String utilisateur;
    protected String ordinateur;


    Choix(String choixUtilisateur) {
        this.utilisateur = choixUtilisateur;
        this.ordinateur = Choix.genererChoixOrdinateur();
    }

    public static String genererChoixOrdinateur() {
        String[] choix = new String[] {"pierre", "feuille", "ciseaux"};
        int randNum = (int) Math.floor(Math.random() * 2) + 1;
        return choix[randNum];
    }

    @Override
    public String toString() {
        return "Choix{" +
                "utilisateur='" + utilisateur + '\'' +
                ", ordinateur='" + ordinateur + '\'' +
                '}';
    }


    public String getUtilisateur() {
        return this.utilisateur;
    }

    public String getOrdinateur() {
        return this.ordinateur;
    }

}