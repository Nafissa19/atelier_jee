<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="metier.ProduitMetierImpl" %>
<%@ page import="modele.domaine.Produit" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Liste des Produits</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>
    <h1>Liste des Produits</h1>

    <a href="formProduit.jsp">Ajouter un nouveau produit</a><br><br>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Désignation</th>
                <th>Prix</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Utilisation de ProduitMetierImpl pour obtenir la liste des produits
                ProduitMetierImpl produitMetier = new ProduitMetierImpl();
                List<Produit> produits = produitMetier.listerProduits();

                for (Produit p : produits) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getCode() %></td>
                <td><%= p.getDesignation() %></td>
                <td><%= p.getPrix() %></td>
                <td>
                    <!-- Lien pour modifier ou supprimer un produit -->
                    <a href="ProduitEditController?id=<%= p.getId() %>">Modifier</a> |
                    <a href="ProduitDeleteController?id=<%= p.getId() %>">Supprimer</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>