import java.awt.Image;

import javax.swing.ImageIcon;



public class Anneau extends Case {

	
// Attributs
	
	private int couleur;  // Couleur d'association des anneaux
	
	public static ImageIcon image1;
	
	public static ImageIcon image2;
	
	
	
// Constructeur
	
	public Anneau(int couleur, int x, int y) {
		super(x,y);
		this.couleur = couleur;
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
	
	// Méthode pour le partnaire si on place les coordonnées directement en private attribut;
		public int getXPartenaire(){
			return xPartenaire;
		}
		public int getYPartenaire(){
			return yPartenaire;
		}

		
	// Méthode pour le déplacement

	public boolean deplacement(objet_Mouvant Parameter2) {

		if (Parameter2.x == this.x && Parameter2.y == this.y) {
			
		}	
			return true;
		}
	}
