import java.awt.Image;

import javax.swing.ImageIcon;



public class Anneau extends Case {

	
// Attributs
	
	private int couleur;  // Couleur d'association des anneaux
	
	private Anneau partenaire; // Un anneau se lie avec un autre anneau, ils vont forcement par deux. Il faudra surement l'ajouter dans le test.
	
	public static ImageIcon image1;
	
	public static ImageIcon image2;
	
	
	
// Constructeur
	
	public Anneau(int couleur, Anneau partenaire, int x, int y) {
		super(x,y);
		this.couleur = couleur;
		this.partenaire = partenaire;
	}
	
	

// Méthodes
	 
	
	// Méthode pour l'affichage
	
	public ImageIcon getImage() {
		if(couleur == 1){
			return image1;
		}
		else return image2;
	}

	public static void setImage(ImageIcon image) {
		Anneau.image1 = image;
		Anneau.image2 = image;
	}
	
	
	// Méthode pour la gestion de la couleur
	
	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		// begin-user-code
		this.couleur = couleur;
		// end-user-code
	}
	
	public Anneau getPartenaire(){
		return partenaire;
	}
	
	public void setPartenaire(Anneau partenaire){
		this.partenaire = partenaire;
	}
	
	
	// Méthode pour le déplacement

	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		// begin-user-code
		if (Parameter2.x == this.x && Parameter2.y == this.y){
			Parameter2.x = this.getPartenaire().x;
			Parameter2.y = this.getPartenaire().y;
			Parameter1 = Parameter1;
		}
		// end-user-code
	}
}