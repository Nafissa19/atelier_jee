<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String action = (request.getAttribute("action") != null) ? (String) request.getAttribute("action") : "Ajouter";
    modele.domaine.Categorie categorie = (modele.domaine.Categorie) request.getAttribute("categorie");
    if (categorie == null) {
        categorie = new modele.domaine.Categorie();
    }
%>
<html>
<head><title><%= action %> Catégorie</title></head>
<body>
<h2><%= action %> une Catégorie</h2>
<form action="CategorieController" method="post">
    <input type="hidden" name="id" value="${categorie.id}" />
    Code: <input type="text" name="code" value="${categorie.code}" required /><br/>
    Libellé: <input type="text" name="libelle" value="${categorie.libelle}" required /><br/>
    <input type="submit" value="Valider"/>
</form>

</body>
</html>
