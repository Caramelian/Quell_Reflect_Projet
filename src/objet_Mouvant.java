import java.util.Set;
import javax.swing.ImageIcon;



public abstract class objet_Mouvant {
	
	// Attributs
	
	private static boolean mouvement = false;

	public Plateau plateau;
	
	public int x;   // Coordonnées courantes
	public int y;
	
	public int xi; // Coordonnées initales
	public int yi;
	
	public String sens;
	
	
// Constructeur
	
	 public objet_Mouvant(int x, int y, Plateau plateau){
		this.plateau = plateau;
		this.x = x;
		this.y = y;
		this.xi = x;
		this.yi = y;
		this.sens = "";
		}
	

	public Plateau getPlateau() {
		// begin-user-code
		return plateau;
		// end-user-code
	}


	public void setPlateau(Plateau plateau) {
		// begin-user-code
		this.plateau = plateau;
		// end-user-code
	}
	
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


	public abstract void disparition(Plateau plateau);


	public abstract void deplacement(Plateau plateau);
	
	
	public abstract ImageIcon getImage();
}
