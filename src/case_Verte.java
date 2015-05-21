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

	public boolean deplacement(objet_Mouvant Parameter2) {
		// Je pense que le changement d'obstacle devrait se gérer au niveau de l'objet mouvant
				if (this.passante == false) {
					return false;
				} else {
					this.passante = false;
					return true;
				}

	}
}

