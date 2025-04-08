<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="entete.jsp" %>

<html>
<head>
    <title>Ajouter un produit</title>
</head>
<body>
    <h2>Ajouter un produit</h2>
    <form action="ProduitEditionController" method="POST">
        <table>
            <tr>
                <td>Code :</td>
                <td><input type="text" name="code" required/></td>
            </tr>
            <tr>
                <td>Designation :</td>
                <td><input type="text" name="designation" required/></td>
            </tr>
            <tr>
                <td>Prix :</td>
                <td><input type="number" step="0.01" name="prix" required/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Ajouter"/>
                    <input type="reset" value="Annuler"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
