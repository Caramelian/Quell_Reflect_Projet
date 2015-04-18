import javax.swing.ImageIcon;



public class case_Vide extends Case {
	
// Attributs

	private boolean piece;

	public static ImageIcon image1; // Case vide
	
	public static ImageIcon image2; // Case contenant une pièce
	
// Constructeur
	
	public case_Vide(boolean piece, int x, int y) {
		super(x,y);
		this.piece=piece;
	}
	
// Méthodes
	
	// Affichage
	
	public ImageIcon getImage() {
		if(this.piece == true){
		return image2;
		}
		else return image1;
	}

	public static void setImage(ImageIcon image) {
		case_Vide.image1 = image;
		case_Vide.image2 = image;
	}
	
	
	// Gestion des pièces
	
	public boolean isPiece() {
		// begin-user-code
		return piece;
		// end-user-code
	}

	public void setPiece(boolean piece) {
		// begin-user-code
		this.piece = piece;
		// end-user-code
	}

	public void change_Etat_Piece() {
		
		this.piece = false;
	}
	
	// Déplacement

	public void deplacement(int Parameter1, objet_Mouvant Parameter2) {
		// begin-user-code
		if (Parameter2 instanceof Bulle){
			if(Parameter2.x == this.x && Parameter2.y == this.y){
				if(piece == true){
				change_Etat_Piece();
				actualiser_Piece();
				
			}
		}
		

		// end-user-code
	}
}
