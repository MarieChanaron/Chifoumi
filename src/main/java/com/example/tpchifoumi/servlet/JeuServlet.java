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

        Map<String, Integer> points = PartieService.getTotalPoints();

        HttpSession session = request.getSession();
        session.setAttribute("points", points);
        session.setAttribute("partie", partie);

        if (points.get("utilisateur").equals(3) || points.get("ordinateur").equals(3)) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp");
            dispatcher.forward(request, response);
            PartieService.clearList();
            session.invalidate();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp");
        dispatcher.forward(request, response);
    }
}
