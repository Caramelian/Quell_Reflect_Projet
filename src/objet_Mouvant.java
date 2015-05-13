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
	
	
// Constructeur
	
	 public objet_Mouvant(int x, int y, Plateau plateau){
		this.plateau = plateau;
		this.x = x;
		this.y = y;
		this.xi = x;
		this.yi = y;
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



	public abstract void disparition(int x, int y, Plateau plateau);


	public abstract void deplacement(int x, int y, Plateau plateau);
	
	public abstract ImageIcon getImage();
}
