import javax.swing.ImageIcon;


public class Pic extends Case {
	
	
// Attributs

	private boolean haut;
	
	private boolean bas;
	
	private boolean gauche;
	
	private boolean droite;
	
	private int couleur;
	
	public static ImageIcon image1; 
	public static ImageIcon image2;
	public static ImageIcon image3;
	public static ImageIcon image4;
	public static ImageIcon image5;
	
	
// Constructeur
	
	public Pic(boolean haut, boolean bas, boolean gauche, boolean droite, int couleur, int x, int y) {
		
		super(x,y);
		this.haut=haut;
		this.bas=bas;
		this.gauche=gauche;
		this.droite=droite;
		this.couleur=couleur;
		
	}
	
	
// Affichage
	
	public ImageIcon getImage() {
		
		boolean positionPic[] = {haut, bas, gauche, droite};
		
		int nombrePic = 0;
				
		for (int i=0; i<=3; i++){
			
			if(positionPic[i] == true){
				nombrePic++;
			}
		}
		
		if (nombrePic == 3) {
			return image4;
		}
		if (nombrePic == 4) {
			return image5;
		}
		if (nombrePic == 2) {
			if ((this.haut == true && this.bas == true)
					|| (this.gauche == true && this.droite == true)) {
				return image3;
			} else
				return image2;
		} else {
			return image1;
		}
	}


	public static void setImage(ImageIcon image) {
		Pic.image1 = image;
		Pic.image2 = image;
		Pic.image3 = image;
		Pic.image4 = image;
		Pic.image5 = image;
	}
	
	
	// Gestion du couplage du pic
	
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

	
	// Gestion de l'orientatino des pics
	
	public boolean isHaut() {
		// begin-user-code
		return haut;
		// end-user-code
	}

	public void setHaut(boolean haut) {
		// begin-user-code
		this.haut = haut;
		// end-user-code
	}

	public boolean isBas() {
		// begin-user-code
		return bas;
		// end-user-code
	}

	public void setBas(boolean bas) {
		// begin-user-code
		this.bas = bas;
		// end-user-code
	}

	public boolean isGauche() {
		// begin-user-code
		return gauche;
		// end-user-code
	}

	public void setGauche(boolean gauche) {
		// begin-user-code
		this.gauche = gauche;
		// end-user-code
	}
	
	public boolean isDroite() {
		// begin-user-code
		return droite;
		// end-user-code
	}
	
	public void setDroite(boolean droite) {
		// begin-user-code
		this.droite = droite;
		// end-user-code
	}
	
	public void rotation(String sens) {
		if (sens == "gauche") {
			// rotation vers la gauche
			boolean transitoire = this.haut;
			this.haut = this.droite;
			this.droite = this.bas;
			this.bas = this.gauche;
			this.gauche = transitoire;
		} else {
			// Rotation vers la droite
			boolean transitoire = this.haut;
			this.haut = this.gauche;
			this.gauche = this.bas;
			this.bas = this.droite;
			this.droite = transitoire;
		}

	}

	
	
	// Déplacement
	
	public boolean deplacement(objet_Mouvant Parameter2) {
		if (Parameter2 instanceof Bulle) {
			if ((Parameter2.sens == "haut" && this.bas)
					|| (Parameter2.sens == "bas" && this.haut)
					|| (Parameter2.sens == "gauche" && this.droite)
					|| (Parameter2.sens == "droite" && this.gauche)) {
				Parameter2.disparition(Parameter2.plateau);
			}
		}
		return false;
	}
}

