import javax.swing.ImageIcon;


public abstract class Case {

// Attributs de la classe Case
	
	public Plateau plateau;
	
	public int x;
	public int y;
	
// Constructeur
	
	public Case(int x, int y){
		this.x = x;
		this.y = y;
	}


	
// Méthode pour l'affichage
	
	public abstract ImageIcon getImage();

// Méthode concernant le déplacement
	
	public abstract boolean deplacement(objet_Mouvant Parameter2);
}
