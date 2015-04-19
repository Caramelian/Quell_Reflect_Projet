import javax.swing.ImageIcon;


public class Mur extends Case {
	
	
// Attributs

	private boolean joyau;    // Booleen qui indique s'il y a un joyau dans le mur.
	
	private int compteur_Joyau = 1;   // C'est le  nombre a incr�menter pour r�cup�rer le Joyau s'il y en a un.
	
	public static ImageIcon image1;
	public static ImageIcon image2;
	public static ImageIcon image3;
	public static ImageIcon image4;
	
	
// Constructeur
	
	public Mur(boolean joyau, int x, int y) {
		super(x,y);
		this.joyau=joyau;
	}
	
	
// M�thodes
	
	// Affichage
	
	public ImageIcon getImage() {
		if (compteur_Joyau == 1) {return image1;}
		
		if (compteur_Joyau == 2) {return image2;}
		
		if (compteur_Joyau == 3) {return image3;}
		
		else return image4;
	}
	
		
	// Gestion Joyau
	
		// Renvoie la nature true or false de joyau
			public boolean isJoyau() {
				return joyau;
			}
	
		// Renvoie la valeur du compteur de joyau
			// ATTENTION il faudrait que l'allure graphique du mur soit modifi� en fonction de la valeur de compteur_Joyau
			// Par exemple a 0 il est clean, � 1 il se fissure un peu, � 2 il est bien fissur� et � 3 il se d�truit et
			// lib�re le joyau
			public int getCompteur_Joyau(){
				return compteur_Joyau;
			}

			public void setCompteur_Joyau(int compteur_Joyau) {
				// begin-user-code
				this.compteur_Joyau = compteur_Joyau;
				// end-user-code
			}

			public void setJoyau(boolean joyau) {
				// begin-user-code
				this.joyau = joyau;
				// end-user-code
			}
	
	
			// C'est une m�thode incr�mentiel il faut taper trois le bloc pour r�cup�rer le joyau s'il y en a un.
			// Elle est li�e � la m�thode profil pour savoir si le joyau a �t� r�colt� dans le niveau concern� ou non.
			public void recolte_Joyau() {
				if (this.joyau == true){
					this.compteur_Joyau++;
				}
				if (this.compteur_Joyau == 4){
			// Il faudrait associer un profil qui est en train de jouer pour m�moriser les joyaux et cr�er une m�moire
			// pour contenir les informations. Je pense qu'on va mettre ce genre de truc en dernier
				}
			}

	// D�placement
	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		// Premi�re �tape est d'effectuer la r�colte de joyau
		this.recolte_Joyau();
	}
}
