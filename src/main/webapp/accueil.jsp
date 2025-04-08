<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@include file="entete.jsp" %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Connexion</title>
<link rel ="stylesheet" type ="text/css"  href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div>
<a href="UserForm.jsp" >Ajouter un utilisateur</a>
	<hr>
	<a href="UserListController">Liste des utilisateurs</a>
	<hr>
	<a href="formProduit.jsp">Ajouter un produit</a>
<hr>
<a href="ProduitListController">Liste des produits</a>
<<hr>
	<a href="formCategorie.jsp">Ajouter une catégorie</a><hr>
<a href="listCategorie.jsp">Lister les catégories</a>
	

</div>

</body>
</html>