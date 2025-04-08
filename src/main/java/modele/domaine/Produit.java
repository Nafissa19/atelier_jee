package modele.domaine;

public class Produit {
	 private int id;
	    private String code;
	    private String designation;
	    private double prix;

	    // Getters et setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getDesignation() {
	        return designation;
	    }

	    public void setDesignation(String designation) {
	        this.designation = designation;
	    }

	    public double getPrix() {
	        return prix;
	    }

	    public void setPrix(double prix) {
	        this.prix = prix;
	    }

}
