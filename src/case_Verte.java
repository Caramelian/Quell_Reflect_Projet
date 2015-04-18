import javax.swing.ImageIcon;



public class case_Verte extends Case {

// Attributs
	
	private static boolean passante = true;
	
	public static ImageIcon image1;
	
	public static ImageIcon image2;
	
// Constructeur
	public case_Verte(int x, int y) {
		super(x,y);
	}

// Méthodes
	
	// Affichage
	
	public ImageIcon getImage() {
		if( passante == true){
			return image1;
		}
		else return image2;
	}

	public static void setImage(ImageIcon image) {
		case_Verte.image1 = image;
		case_Verte.image2 = image;
	}
	
	
	// Gestion de la nature passante ou blocante de la case

	public boolean isPassante() {
		// begin-user-code
		return passante;
		// end-user-code
	}


	public void setPassante(boolean passante) {
		// begin-user-code
		this.passante = passante;
		// end-user-code
	}


	public void changement_Obstacle(objet_Mouvant objetMouvant) {
		// Quand la position de l'objet mouvant devient différente de celle de l'obstacle on termine		
		this.passante = false;
	}
	
	
	// Déplacement

	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		if (Parameter2.x == this.x && Parameter2.y == this.y){
			this.changement_Obstacle(Parameter2);
		}
		if (passante == true){
			if (Parameter1 == 1){ // direction vers la droite
			Parameter2.y = Parameter2.y + 1;
			}
			if (Parameter1 == 2){ // direction vers le haut
			Parameter2.x = Parameter2.x - 1;
			}
			if (Parameter1 == 3){ // direction vers la gauche
			Parameter2.y = Parameter2.y - 1;	
			}
			if (Parameter1 == 4){ // direction vers le bas
			Parameter2.x = Parameter2.x + 1;	
			}
		}
		if (passante == false){
			Parameter2.x = Parameter2.x;
			Parameter2.y = Parameter2.y;
		}
	}
}
