import javax.swing.ImageIcon;


public class Switcher extends Case {

	
// Attributs
	
	// Il y avait un attribut de direction mais je pense que c'est inutile
	
	public static ImageIcon image;

	private int couleur;
	
	private int orientation; // Sens horaire en partant de la flèche du haut à 1
	
	
// Constructeur
	public Switcher(int couleur, int orientation, int x, int y) {
		super(x,y);
		this.couleur = couleur;
		this.orientation=orientation;
	}
	
	
// Méthodes
	
	// Affichage
	
	public ImageIcon getImage() {
		return image;
	}

	public static void setImage(ImageIcon image) {
		Switcher.image = image;
	}
	
	
	// Gestion du couplage du switcher
	
	public int getCouleur() {
		// begin-user-code
		return couleur;
		// end-user-code
	}

	public void setCouleur(int couleur) {
		// begin-user-code
		this.couleur = couleur;
		// end-user-code
	}

	
	// Gestion de l'orientation du switcher
	
	public int getOrientation() {
		// begin-user-code
		return orientation;
		// end-user-code
	}

	public void setOrientation(int couleur) {
		// begin-user-code
		this.orientation = orientation;
		// end-user-code
	}
		
	public void rotation(int Parameter1) {
		// Le paramètre se veut représentant la direction mais je pense pas que(il faudra le conserver.
	}
	
	
	// Déplacement

	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}
