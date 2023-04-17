package com.example.tpchifoumi.modele;

public class Points {

    protected int utilisateur = 0;
    protected int ordinateur = 0;


    Points(Choix choix) {
        switch (choix.utilisateur) {
            case "Pierre":
                if (choix.ordinateur.equals("Feuille")) {
                    this.ordinateur += 1;
                } else if (choix.ordinateur.equals("Ciseaux")) {
                    this.utilisateur += 1;
                }
                break;
            case "Feuille":
                if (choix.ordinateur.equals("Pierre")) {
                    this.utilisateur += 1;
                } else if (choix.ordinateur.equals("Ciseaux")) {
                    this.ordinateur += 1;
                }
                break;
            case "Ciseaux":
                if (choix.ordinateur.equals("Pierre")) {
                    this.ordinateur += 1;
                } else if (choix.ordinateur.equals("Feuille")) {
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