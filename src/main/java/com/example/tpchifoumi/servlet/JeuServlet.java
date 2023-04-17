package com.example.tpchifoumi.servlet;

import com.example.tpchifoumi.modele.Partie;
import com.example.tpchifoumi.service.PartieService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "JeuServlet", urlPatterns = {"/jeu"})
public class JeuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choix = request.getParameter("choix");

        PartieService service = new PartieService();
        Partie partie = service.traiterRequetePost(choix);

        Map<String, Integer> total = PartieService.getTotalPoints();

        String resultat;
        if (partie.getPoints().getUtilisateur() > partie.getPoints().getOrdinateur()) {
            resultat = "Gagné !";
        } else if (partie.getPoints().getUtilisateur() < partie.getPoints().getOrdinateur()) {
            resultat = "Perdu !";
        } else {
            resultat = "Égalité !";
        }

        String ptsUtil;
        if (total.get("utilisateur") > 1) {
            ptsUtil = total.get("utilisateur") + " points";
        } else {
            ptsUtil = total.get("utilisateur") + " point";
        }

        String ptsOrdi;
        if (total.get("ordinateur") > 1) {
            ptsOrdi = total.get("ordinateur") + " points";
        } else {
            ptsOrdi = total.get("ordinateur") + " point";
        }

        String choixUtil = partie.getChoix().getUtilisateur();
        String choixOrdi = partie.getChoix().getOrdinateur();

        HttpSession session = request.getSession();
        session.setAttribute("partie", partie);
        session.setAttribute("total", total);
        session.setAttribute("fin", false);
        session.setAttribute("resultat", resultat);
        session.setAttribute("ptsUtil", ptsUtil);
        session.setAttribute("ptsOrdi", ptsOrdi);
        session.setAttribute("choixUtil", choixUtil);
        session.setAttribute("choixOrdi", choixOrdi);

        if (total.get("utilisateur").equals(3) || total.get("ordinateur").equals(3)) {
            session.setAttribute("fin", true);
            String resultatFinal;
            if (total.get("utilisateur") == 3) {
                resultatFinal = "Bravo !  &#128079; Vous avez gagné la partie !";
            } else {
                resultatFinal = "Vous avez perdu la partie... &#128546; Voulez-vous réessayer ?";
            }
            session.setAttribute("resultatFinal", resultatFinal);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp");
            dispatcher.forward(request, response);
            PartieService.clearList();
            session.invalidate();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp");
        dispatcher.forward(request, response);
    }
}
