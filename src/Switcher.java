import javax.swing.ImageIcon;


public class Switcher extends Case {

	
// Attributs
	
	// Il y avait un attribut de direction mais je pense que c'est inutile
	
	public static ImageIcon image;

	private int couleur;
	
	private String orientation; // Sens horaire en partant de la fl�che du haut � 1
	
	
// Constructeur
	public Switcher(int couleur, String orientation, int x, int y) {
		super(x,y);
		this.couleur = couleur;
		this.orientation=orientation;
	}
	
	
// M�thodes
	
	// Affichage
	
	public ImageIcon getImage() {
		return image;
	}

	public static void setImage(ImageIcon image) {
		Switcher.image = image;
	}
	
	
	// Gestion du couplage du switcher
	
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

	
	// Gestion de l'orientation du switcher
	
	public String getOrientation() {
		// begin-user-code
		return orientation;
		// end-user-code
	}

	public void setOrientation(int couleur) {
		// begin-user-code
		this.orientation = orientation;
		// end-user-code
	}
		
	public void rotation(Plateau plateau, String sensAvant) {
		// Il faudrait lui mettre en attribut l'ensemble des pics qui lui sont associ�s. 
		// On retire le probl�me de la couleur et �a all�ge le code
		// Ou alors si c'est trop lourd en xml on garde la couleur mais on le met en attribut en g�n�rante code en regardant les couleurs des pics
		// Mais �a suppose de pouvoir savoir que la case est un pic c'est toujours le m�me probl�me...
		// Si plusieurs switchers sont de la m�me couleurs il faut aussi les faire pivoter et on ajoute en attribut.
		// Sinon on est oblig� d'aller les retrouver � chaque fois je ne vois pas l'int�ret.
		if ((sensAvant == "haut" && this.orientation == "gauche")
				|| (sensAvant == "gauche" && this.orientation == "bas")
				|| (sensAvant == "bas" && this.orientation == "droite")
				|| (sensAvant == "droite" && this.orientation == "haut")) {
			// On effectue une rotation vers la gauche
		}
		if ((sensAvant == "haut" && this.orientation == "droite")
				|| (sensAvant == "doite" && this.orientation == "bas")
				|| (sensAvant == "bas" && this.orientation == "gauche")
				|| (sensAvant == "gauche" && this.orientation == "haut")) {
			// On effectue une rotation vers la droite
		} else {
			// On effectue deux rotation vers la droite ou la gauche
		}
		// Je ne me suis pas occuper de l'affichage des images correspondantes.
		// Il faudra r�fl�chir au moyen de les faire tourner au moment de l'affichage en fonction de lu string de l'orientation
		// On a le m�me probl�me de forcage du typage pour pouvoir tester la couleur.
		// J'ai bien une id�e de comment faire mais je ne sais pas si c'est la meilleure.
	}

	
	
	// D�placement

	public boolean deplacement(objet_Mouvant Parameter2) {
		if (Parameter2.sens != this.orientation) {
			String sensAvant = this.orientation;
			this.orientation = Parameter2.sens;
			this.rotation(Parameter2.plateau, sensAvant);
		}

		return true;

	}
}