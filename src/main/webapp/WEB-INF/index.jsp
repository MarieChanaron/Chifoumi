<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>


<head>
    <title>Chifoumi</title>
    <style><%@include file="/WEB-INF/style.css"%></style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gloria+Hallelujah&family=Mandali&display=swap" rel="stylesheet">
</head>


<body>

<header>
    <h1>CHIFOUMI</h1>
</header>

<main>
    <form action="jeu" method="post">
        <button class="icon" type="submit" name="choix" value="pierre">
            <img src="images?file=pierre.png" alt="pierre">
        </button>
        <button class="icon" type="submit" name="choix" value="ciseaux">
            <img src="images?file=ciseaux.png" alt="ciseaux">
        </button>
        <button class="icon" type="submit" name="choix" value="feuille">
            <img src="images?file=feuille.png" alt="feuille">
        </button>
    </form>
</main>

<footer>
    <p>Pierre, feuille ou ciseaux ? Faites votre choix !</p>
</footer>

</body>

</html>