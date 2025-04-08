package controleur;

import modele.domaine.Categorie;
import metier.CategorieMetierImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategorieController")
public class CategorieController extends HttpServlet {

    private final CategorieMetierImpl metier = new CategorieMetierImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("AfficherForm".equals(action)) {
            request.setAttribute("action", "Ajouter");
            request.getRequestDispatcher("formCategorie.jsp").forward(request, response);
        } else if ("Edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Categorie c = metier.getCategorieById(id);
            request.setAttribute("categorie", c);
            request.setAttribute("action", "Modifier");
            request.getRequestDispatcher("formCategorie.jsp").forward(request, response);
        } else if ("Delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            metier.supprimerCategorie(id);
            response.sendRedirect("CategorieController");
        } else {
            List<Categorie> categories = metier.listerCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("listCategorie.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String code = request.getParameter("code");
        String libelle = request.getParameter("libelle");

        if ("Ajouter".equals(action)) {
            Categorie c = new Categorie();
            c.setCode(code);
            c.setLibelle(libelle);
            metier.ajouterCategorie(c);
        } else if ("Modifier".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Categorie c = new Categorie();
            c.setId(id);
            c.setCode(code);
            c.setLibelle(libelle);
            metier.modifierCategorie(c);
        }
        response.sendRedirect("CategorieController");
    }
}
