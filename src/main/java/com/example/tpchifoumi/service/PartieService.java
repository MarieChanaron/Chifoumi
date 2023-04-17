package com.example.tpchifoumi.service;

import com.example.tpchifoumi.modele.Partie;

import java.util.HashMap;
import java.util.Map;


public class PartieService {

    String choixUtilisateur;

    private static Map<String, Integer> totalPoints = new HashMap<>();

    public Partie traiterRequetePost(String choixUtilisateur) {
        this.choixUtilisateur = choixUtilisateur;
        Partie partie = new Partie(choixUtilisateur);

        if (totalPoints.get("utilisateur") == null) {
            PartieService.totalPoints.put("utilisateur", partie.getPoints().getUtilisateur());
        } else {
            Integer ptsUtil = totalPoints.get("utilisateur") + partie.getPoints().getUtilisateur();
            PartieService.totalPoints.replace("utilisateur", ptsUtil);
        }

        if (totalPoints.get("ordinateur") == null) {
            PartieService.totalPoints.put("ordinateur", partie.getPoints().getOrdinateur());
        } else {
            Integer ptsOrdi = totalPoints.get("ordinateur") + partie.getPoints().getOrdinateur();
            PartieService.totalPoints.replace("ordinateur", ptsOrdi);
        }

        return partie;
    }

    public static Map<String, Integer> getTotalPoints() {
        return PartieService.totalPoints;
    }

    public static void clearList() {
        PartieService.totalPoints.clear();
    }
}