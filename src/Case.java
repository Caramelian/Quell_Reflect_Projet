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


	
// M�thode pour l'affichage
	
	public abstract ImageIcon getImage();

// M�thode concernant le d�placement
	
	public abstract boolean deplacement(objet_Mouvant Parameter2);
}
