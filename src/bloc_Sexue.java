import javax.swing.ImageIcon;


public class bloc_Sexue extends objet_Mouvant {

	
// Attributs
	
	private boolean male;
	
	public static ImageIcon image1;
	public static ImageIcon image2;
	
	
// Constructeur
	
	public bloc_Sexue(boolean male, int x, int y, Plateau plateau) {
		super(x,y,plateau);
		this.male=male;
	}	
	
	
// Méthodes
	
	// Méthode pour l'affichage
	
	public ImageIcon getImage() {
		if( male == true ){
			return image1;
		}
		else return image2;
		
	}

	public static void setImage(ImageIcon image) {
		bloc_Sexue.image1 = image;
		bloc_Sexue.image2 = image;
	}
	
	// Gestion du sexe
	public boolean isMale() {
		// begin-user-code
		return male;
		// end-user-code
	}


	public void setMale(boolean male) {
		// begin-user-code
		this.male = male;
		// end-user-code
	}



	public void disparition(int x, int y, Plateau plateau) {
		// Regarder comment supprimer un objet
		// Est-ce qu'on est sûr pour les variables d'éntrée de cette méthode ? Pourquoi pas deux objets sexués ?
		// Pour l'instant, il y a des erreurs sur cette méthode 
		
		if ((this.male == true).x == (this.male == false).x && (this.male == true).y == (this.male == false).y) {
			this.x = null;
			this.y = null;
		}
	}

	public void deplacement(int x, int y, Plateau plateau) {
		// Je pense qu'il faudrait créer une écoute clavier dans l'interface clavier pour pouvoir introduire la notion de direction qui nous permettrait de savoir dans quel sens les objets se déplacent
		
		// begin-user-code
		if (direction == 1){ // vers la droite
		y = y+1;
		}
		
		if (direction == 2){ // vers le haut
		x = x-1;	
		}
		
		if (direction == 3){ // vers la gauche
		y = y-1;
		}
		
		if (direction == 4){ // vers le bas
		x = x+1;
		}
	}
		// end-user-code
}

