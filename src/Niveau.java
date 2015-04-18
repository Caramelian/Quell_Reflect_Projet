import java.util.Set;


public class Niveau {
// Classe probablement inutile
	
	
// Attributs
	
	private Plateau plateau;
	
	private Set<Profil> joueur;
	
	private int numero;
	
	private int nombre_Piece;
	
	private int nombre_Coup_Optimal;
	
	

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

	
	public Set<Profil> getJoueur() {
		// begin-user-code
		return joueur;
		// end-user-code
	}

	public void setJoueur(Set<Profil> joueur) {
		// begin-user-code
		this.joueur = joueur;
		// end-user-code
	}


	public int getNumero() {
		// begin-user-code
		return numero;
		// end-user-code
	}


	public void setNumero(int numero) {
		// begin-user-code
		this.numero = numero;
		// end-user-code
	}

	public int getNombre_Piece() {
		// begin-user-code
		return nombre_Piece;
		// end-user-code
	}

	
	public void setNombre_Piece(int nombre_Piece) {
		// begin-user-code
		this.nombre_Piece = nombre_Piece;
		// end-user-code
	}

	
	public int getNombre_Coup_Optimal() {
		// begin-user-code
		return nombre_Coup_Optimal;
		// end-user-code
	}


	public void setNombre_Coup_Optimal(int nombre_Coup_Optimal) {
		// begin-user-code
		this.nombre_Coup_Optimal = nombre_Coup_Optimal;
		// end-user-code
	}
}
