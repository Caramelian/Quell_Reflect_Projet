import javax.swing.ImageIcon;


public class bloc_Sexue extends objet_Mouvant {

	
// Attributs
	
	private boolean mouvement = false;
	
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



	public void disparition(Plateau plateau) {
		// Regarder comment supprimer un objet
		// Est-ce qu'on est sûr pour les variables d'éntrée de cette méthode ? Pourquoi pas deux objets sexués ?
		// Pour l'instant, il y a des erreurs sur cette méthode 
	}

	public void deplacement(Plateau plateau) {
		boolean voisin = false; // Indique s'il y a un voisin sur la future case où doit se déplacer la bulle
		this.mouvement = true;

		// On obtient les coordonnées de la future position de la bulle si le
		// déplacement est possible
		// Je pense qu'il faudra effectuer un genre de test pour être sur qu'on
		// a bien une direction, pour que la droite puisse être d
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
		// On vérifie qu'il n'y a pas de voisin sur la case suivante
		int i = 0;
		while (i < plateau.objetMouvant.length) {
			if (plateau.objetMouvant[i].x == xNxt && plateau.objetMouvant[i].y == yNxt) {
				voisin = true;

			}
			i++;
			// On considère qu'on lance l'objet voisin peut importe sa nature
			// L'erreur vient qu'il faudrait forcer le typage comme on est sur que c'est un bloc sexue

			if (voisin) {
				if (plateau.objetMouvant[i - 1] instanceof bloc_Sexue && this.isMale() != ((bloc_Sexue)plateau.objetMouvant[i - 1]).isMale()) {
					this.disparition(plateau);
					plateau.objetMouvant[i - 1].disparition(plateau);
				} else {
					plateau.objetMouvant[i - 1].deplacement(plateau);
				if (plateau.objetMouvant[i - 1].isMouvement() == false) {
					this.mouvement = false;
				} else {
					this.deplacement(plateau);
				}
			}
			} else {
			if (plateau.plateau[xNxt][yNxt].deplacement(this)) {
				this.x = xNxt;
				this.y = yNxt;
				this.deplacement(plateau);
			}

			}
// Si vous êtes d'accord, on peut ptet mettre la même chose que pour
// bloc_Sexue avec les directions ?

		}
	}
}



