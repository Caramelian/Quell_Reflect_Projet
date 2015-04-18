import javax.swing.ImageIcon;


public class Mur extends Case {
	
	
// Attributs

	private boolean joyau;    // Booleen qui indique s'il y a un joyau dans le mur.
	
	private int compteur_Joyau = 1;   // C'est le  nombre a incrémenter pour récupérer le Joyau s'il y en a un.
	
	public static ImageIcon image1;
	public static ImageIcon image2;
	public static ImageIcon image3;
	public static ImageIcon image4;
	
	
// Constructeur
	
	public Mur(boolean joyau, int x, int y) {
		super(x,y);
		this.joyau=joyau;
	}
	
	
// Méthodes
	
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
			// ATTENTION il faudrait que l'allure graphique du mur soit modifié en fonction de la valeur de compteur_Joyau
			// Par exemple a 0 il est clean, à 1 il se fissure un peu, à 2 il est bien fissuré et à 3 il se détruit et
			// libère le joyau
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
	
	
			// C'est une méthode incrémentiel il faut taper trois le bloc pour récupérer le joyau s'il y en a un.
			// Elle est liée à la méthode profil pour savoir si le joyau a été récolté dans le niveau concerné ou non.
			public void recolte_Joyau() {
				if (this.joyau == true){
					this.compteur_Joyau++;
				}
				if (this.compteur_Joyau == 4){
			// Il faudrait associer un profil qui est en train de jouer pour mémoriser les joyaux et créer une mémoire
			// pour contenir les informations. Je pense qu'on va mettre ce genre de truc en dernier
				}
			}

	// Déplacement
	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		// Première étape est d'effectuer la récolte de joyau
		this.recolte_Joyau();
	}
}
