package com.example.tpchifoumi.modele;


public class Partie {

    private Choix choix;
    private Points points;

    public Partie(String choixUtilisateur) {
        this.choix = new Choix(choixUtilisateur);
        this.points = new Points(this.choix);
    }

    @Override
    public String toString() {
        return "Partie{" +
                "choix=" + choix +
                ", points=" + points +
                '}';
    }

    public Points getPoints() {
        return this.points;
    }


    public Choix getChoix() {
        return this.choix;
    }

}
