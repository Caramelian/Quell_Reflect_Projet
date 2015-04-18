import java.util.Set;
import cartes_De_Jeu.*;


public class Profil {
	
// Je ne vois pas trop l'utilité des méthodes set telles qu'elles sont faîtes j'ai donc créer des méthodes
// en dessous pour pouvoir modifier l'attribut corespondant.

	
// Attributs
	
	private String nom = "*";
	
	private Set<Niveau> niveau;
	
	public int nombreNiveau = 0;
	
	private boolean[] joyau_Niveau;
	
	private int[] score_niveau;
	
	private int score_total = 0;
	
	
// Méthodes
			
	public int getNombreNiveau(){
		return nombreNiveau;
	}
	
	public void setnombreNiveau(){
		File[] f = cartes_Jeu.listFiles();
		int x = 0;
		for (int i = 0 ; i < f.length ; i++) {
		  if (f[i].isFile()) {
		    x++;
		  }
		}
		this.nombreNiveau = f.length;
	}
	
	
	public Set<Niveau> getNiveau() {
		return niveau;
	}

	public void setNiveau(Set<Niveau> niveau) {
		this.niveau = niveau;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int[] getScore_niveau() {
		return score_niveau;		
	}

	
	public void setScore_niveau(int[] score_niveau) {
		this.score_niveau = score_niveau;
	}
	
	
	public void changeScoreNiveau(int niveau, int score, int[] score_niveau){
		this.score_niveau(niveau-1)=score;
	}

	
	public int getScore_total() {
		return score_total;
	}

	public void setScore_total(int score_total) {
		this.score_total = score_total;
	}
	
	
	public void changeScoreTotal(int[] scoreNiveau){
		int score = 0;
		for (int i = 0 ; i < scoreNiveau.length ; i++){
			score = score + scoreNiveau(i);
		}
		this.score_total = score;
	}


	public boolean[] getJoyau_Niveau() {
		return joyau_Niveau;
	}


	public void setJoyau_Niveau(boolean[] joyau_Niveau) {
		// begin-user-code
		this.joyau_Niveau = joyau_Niveau;
		// end-user-code
	}
	
	
	public void changeJoyauNiveau(int niveau){
		this.joyau_Niveau(niveau-1) = true
	}
	

	public void nombre_Coup_Niveau(Object Parameter1) {
	}

	public void nombre_Coup_Total() {
	}

	public void change_Joyau_Niveau() {
	}
}