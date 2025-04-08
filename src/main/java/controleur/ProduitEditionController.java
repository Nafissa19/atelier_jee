package controleur;

import metier.ProduitMetierImpl;
import modele.domaine.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ProduitEditionController")
public class ProduitEditionController extends HttpServlet {

    private ProduitMetierImpl produitMetier = new ProduitMetierImpl();

    // Méthode GET pour afficher le formulaire d'ajout d'un produit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige vers le formulaire d'ajout de produit (formProduit.jsp)
        request.getRequestDispatcher("formProduit.jsp").forward(request, response);
    }

    // Méthode POST pour traiter l'ajout d'un produit
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String designation = request.getParameter("designation");
        double prix = Double.parseDouble(request.getParameter("prix"));

        Produit produit = new Produit();
        produit.setCode(code);
        produit.setDesignation(designation);
        produit.setPrix(prix);

        // Ajoute le produit en utilisant la méthode d'ajout de la classe ProduitMetierImpl
        produitMetier.ajouterProduit(produit);

        // Redirige vers la page de liste des produits après l'ajout
        response.sendRedirect("listProduit.jsp");
    }
}
