import javax.swing.ImageIcon;


public class Bulle extends objet_Mouvant {

// Attributs
	
	private static boolean mouvement = false;
	
	private boolean selection;
	
	private static Clavier clavier;   // Provient de la relation mais est-ce n�cessaire?
	
	public static ImageIcon image;  // Toutes les bulles sont identiques � l'�cran
	
	private int ordre; // Donne le num�ro de la bulle dans le classement des bulles du plateau
	
	
// Constructeur
	public Bulle(boolean selection, int ordre, int x, int y, Plateau plateau) {
		super(x,y,plateau);
		this.selection=selection;
		this.ordre=ordre;
	}
	
// M�thodes
	
	// Affichage
	
	public ImageIcon getImage() {
		return image;
	}

	public static void setImage(ImageIcon image) {
		Bulle.image = image;
	}
	
	// Gestion de la possibilit� de jouer

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
		// ATTENTION METHODE NON FINIE: il faut parcourir le plateau � la recherche de la bulle dont l'odre est l'ordre +1
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
	
	// Gestion disparition et d�placement

	public void disparition(Plateau plateau) {
		
		// Voir ce qu'on supprime
		
	}

	public void deplacement(Plateau plateau) {

		boolean voisin = false; // Indique s'il y a un voisin sur la future case o� doit se d�placer la bulle
		this.mouvement = true;

		// On obtient les coordonn�es de la future position de la bulle si le
		// d�placement est possible
		// Je pense qu'il faudra effectuer un genre de test pour �tre sur qu'on
		// a bien une direction, pour que la droite puisse �tre d
		// et pas seulement un else

		int xNxt;
		int yNxt;

		if (this.sens == "haut") {
			xNxt = this.x;
			yNxt = this.y + 1;
		}
		if (this.sens == "bas") {
			xNxt = this.x;
			yNxt = this.y - 1;
		}
		if (this.sens == "gauche") {
			xNxt = this.x - 1;
			yNxt = this.y;
		} else {
			xNxt = this.x + 1;
			yNxt = this.y;
		}
		// On v�rifie qu'il n'y a pas de voisin sur la case suivante
		int i = 0;
		while (i < plateau.objetMouvant.length) {
			if (plateau.objetMouvant[i].x == xNxt
					&& plateau.objetMouvant[i].y == yNxt) {
				voisin = true;
			}
			i++;
			// On consid�re qu'on lance l'objet voisin peut importe sa nature
			if (voisin) {
				plateau.objetMouvant[i - 1].deplacement(plateau);
				if (plateau.objetMouvant[i - 1].isMouvement() == false) {
					this.mouvement = false;
				} else {
					this.deplacement(plateau);
				}
			} else {
				if (plateau.plateau[xNxt][yNxt] instanceof Anneau) {

					// Il faudrait pouvoir connaitre les coordonn�es du
					// partenaire. Dans le cas o� les coordonn�es du partenaire
					// sont mis en
					// attribut ca donne
					// this.x = plateau.plateau[xNxt][yNxt].getXPartenaire();
					// this.y = plateau.plateau[xNxt][yNxt].getYPartenaire();

				}
				if (plateau.plateau[xNxt][yNxt].deplacement(this)) {
					this.x = xNxt;
					this.y = yNxt;
					this.deplacement(plateau);
				}

			}

		}
		// Si vous �tes d'accord, on peut ptet mettre la m�me chose que pour bloc_Sexue avec les directions ?
	}
}

