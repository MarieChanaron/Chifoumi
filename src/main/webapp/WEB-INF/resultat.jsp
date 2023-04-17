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
    <style><%@include file="/WEB-INF/css/style.css"%></style>
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
            <td><img src="images?file=${choixUtil}.png" alt="${choixUtil}"></td>
            <td></td>
            <td><img src="images?file=${choixOrdi}.png" alt="${choixOrdi}"></td>
        </tr>
        <tr>
            <td>${ptsUtil}</td>
            <td></td>
            <td>${ptsOrdi}</td>
        </tr>
        </tbody>
    </table>

    <c:choose>
        <c:when test="${!fin}">
            <p>${resultat}</p>
        </c:when>
        <c:otherwise>
            <p>${resultatFinal}</p>
        </c:otherwise>
    </c:choose>

</main>

    <c:choose>
        <c:when test="${!fin}">
            <footer>
                <a href="jeu">
                    <button class="button">Retenter</button>
                </a>
            </footer>
        </c:when>
        <c:otherwise>
            <footer>
                <a href="jeu">
                    <button class="button">Rejouer</button>
                </a>
            </footer>
        </c:otherwise>
    </c:choose>

</body>
</html>
