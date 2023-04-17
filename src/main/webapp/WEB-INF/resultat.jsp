<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Marie
  Date: 12/04/2023
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Résultats</title>
    <style><%@include file="/WEB-INF/style.css"%></style>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gloria+Hallelujah&family=Mandali&display=swap" rel="stylesheet">
</head>
<body>

<header>
    <h1>CHIFOUMI</h1>
</header>

<main id="resultat">
    <table>
        <thead>
        <tr>
            <td>VOUS</td>
            <td>vs</td>
            <td>ORDINATEUR</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><img src="images?file=${choix.getUtilisateur()}.png" alt="${choix.getUtilisateur()}"></td>
            <td></td>
            <td><img src="images?file=${choix.getOrdinateur()}.png" alt="${choix.getOrdinateur()}"></td>
        </tr>
        <tr>
            <td><c:out value="${totalPoints.get('utilisateur')} point(s)" /></td>
            <td></td>
            <td><c:out value="${totalPoints.get('ordinateur')} point(s)" /></td>
        </tr>
        </tbody>
    </table>


    <c:if test="${points.get('utilisateur') < 3 && points.get('ordinateur') < 3}">
        <c:if test="${partie.getPoints().getUtilisateur() > partie.getPoints().getOrdinateur()}">
            <p>Gagné !</p>
        </c:if>
        <c:if test="${partie.getPoints().getUtilisateur() < partie.getPoints().getOrdinateur()}">
            <p>Perdu !</p>
        </c:if>
        <c:if test="${partie.getPoints().getUtilisateur() == partie.getPoints().getOrdinateur()}">
            <p>Égalité !</p>
        </c:if>
    </c:if>

    <c:if test="${fin && totalPoints.get('utilisateur') == 3}">
        <p>Bravo ! Vous avez gagné la partie !</p>
    </c:if>

    <c:if test="${fin && totalPoints.get('ordinateur') == 3}">
        <p>Vous avez perdu... Voulez-vous réessayer ?</p>
    </c:if>
</main>

<footer>
    <a href="jeu">
        <button class="button">Rejouer</button>
    </a>
</footer>

</body>
</html>
