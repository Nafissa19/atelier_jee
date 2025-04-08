<%@ page import="java.util.List" %>
<%@ page import="modele.domaine.Categorie" %>
<%
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
%>
<html>
<head><title>Liste des Catégories</title></head>
<body>
<h2>Liste des Catégories</h2>
<a href="CategorieController?action=AfficherForm">Ajouter une Catégorie</a>
<table border="1">
    <tr><th>ID</th><th>Code</th><th>Libellé</th><th>Actions</th></tr>
    <%
    if (categories != null) {
        for (Categorie c : categories) {
%>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getCode() %></td>
            <td><%= c.getLibelle() %></td>
            <td>
                <a href="CategorieController?action=edit&id=<%= c.getId() %>">Modifier</a>
                <a href="CategorieController?action=delete&id=<%= c.getId() %>">Supprimer</a>
            </td>
        </tr>
<%
        }
    }
%>

</table>
</body>
</html>
