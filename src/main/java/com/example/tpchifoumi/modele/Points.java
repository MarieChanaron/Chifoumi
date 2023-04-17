package com.example.tpchifoumi.modele;

public class Points {

    protected int utilisateur = 0;
    protected int ordinateur = 0;


    Points(Choix choix) {
        switch (choix.utilisateur) {
            case "pierre":
                if (choix.ordinateur.equals("feuille")) {
                    this.ordinateur += 1;
                } else if (choix.ordinateur.equals("ciseaux")) {
                    this.utilisateur += 1;
                }
                break;
            case "feuille":
                if (choix.ordinateur.equals("pierre")) {
                    this.utilisateur += 1;
                } else if (choix.ordinateur.equals("ciseaux")) {
                    this.ordinateur += 1;
                }
                break;
            case "ciseaux":
                if (choix.ordinateur.equals("pierre")) {
                    this.ordinateur += 1;
                } else if (choix.ordinateur.equals("feuille")) {
                    this.utilisateur += 1;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Points{" +
                "utilisateur=" + utilisateur +
                ", ordinateur=" + ordinateur +
                '}';
    }

    public int getUtilisateur() {
        return this.utilisateur;
    }

    public int getOrdinateur() {
        return this.ordinateur;
    }
}

/*

    La pierre écrase les ciseaux et gagne.
    La feuille enveloppe la pierre et gagne.
    Les ciseaux découpent la feuille et gagnent.

 */