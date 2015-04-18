import javax.swing.ImageIcon;


public class Bulle extends objet_Mouvant {

// Attributs
	
	private static boolean mouvement = false;
	
	private boolean selection;
	
	private static Clavier clavier;   // Provient de la relation mais est-ce nécessaire?
	
	public static ImageIcon image;  // Toutes les bulles sont identiques à l'écran
	
	private int ordre; // Donne le numéro de la bulle dans le classement des bulles du plateau
	
	
// Constructeur
	public Bulle(boolean selection, int ordre, int x, int y, Plateau plateau) {
		super(x,y,plateau);
		this.selection=selection;
		this.ordre=ordre;
	}
	
// Méthodes
	
	// Affichage
	
	public ImageIcon getImage() {
		return image;
	}

	public static void setImage(ImageIcon image) {
		Bulle.image = image;
	}
	
	// Gestion de la possibilité de jouer

	public boolean isMouvement() {
		// begin-user-code
		return mouvement;
		// end-user-code
	}


	public void setMouvement(boolean mouvement) {
		// begin-user-code
		this.mouvement = mouvement;
		// end-user-code
	}
	
	
	public boolean isSelection(){
		
		return this.selection;
	}



	public void setSelection(boolean selection) {
		// begin-user-code
		this.selection = selection;
		// end-user-code
	}
	
	
	public boolean autorisationJouer(){
		if ( mouvement == false && selection == true ){
			return true;
		}else{
			return false;
		}
	}

	
	
	public void selectionnerBulle(Bulle bulle) {
		// ATTENTION METHODE NON FINIE: il faut parcourir le plateau à la recherche de la bulle dont l'odre est l'ordre +1
		bulle.setSelection(true);
	}
	
	// Gestion clavier

	public Clavier getClavier() {
		// begin-user-code
		return clavier;
		// end-user-code
	}
	
	public void setClavier(Clavier clavier) {
		// begin-user-code
		this.clavier = clavier;
		// end-user-code
	}
	
	// Gestion disparition et déplacement

	public void disparition(int x, int y, Plateau plateau) {
		
		// Voir ce qu'on supprime
		
	}

	public void deplacement(int x, int y, Plateau plateau) {
	// Si vous êtes d'accord, on peut ptet mettre la même chose que pour bloc_Sexue avec les directions ?	
		
		// begin-user-code
	

		// end-user-code
	}
}
