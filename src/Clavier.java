import java.awt.event.*;
import javax.swing.*;


public class Clavier implements ActionListener {
	
	// Compl�ter le bouton pour savoir auquel �a correspond
	
		JButton espace = new JButton();
		JButton haut = new JButton();
		JButton bas = new JButton();
		JButton gauche = new JButton();
		JButton droite = new JButton();
		JButton restart = new JButton();
		Ecran ecran;

		int ordre; // Attribut pour g�rer la bulle s�lectionner

		public Clavier(Ecran ecran) {

			this.espace.addActionListener(this);
			this.haut.addActionListener(this);
			this.bas.addActionListener(this);
			this.gauche.addActionListener(this);
			this.droite.addActionListener(this);
			this.ecran = ecran;
			int ordre = 0;
		}

		/*
		 * �tape 2 :Cette m�thode est d�clar�e dans l'interface ActionListener. Il
		 * nous faut l'impl�menter.
		 */
		
		public void actionPerformed(ActionEvent e) {

			// La barre espace g�re la s�lection de l'objetMouvant. Je pense qu'il faudrait ajouter un attribut d'indice qui change avec la barre espace
			// Et ensuite l'ajouter au d�placement

			if (e.getSource() == this.espace) {
				if (this.ordre < this.ecran.plateau.getNombreBulle() - 1) {
					this.ordre++;
				} else {
					this.ordre = 0;
				}
			}
			
			// Il faudrait se d�brouiller pour que dans le tableau d'objet mouvant les bulles se trouvent au d�but
			
			Bulle cible = (Bulle) this.ecran.plateau.objetMouvant[this.ordre];


			if (e.getSource() == this.haut) {
				cible.sens = "haut";
				cible.deplacement(this.ecran.plateau);
			}
			if (e.getSource() == this.bas) {
				cible.sens = "bas";
				cible.deplacement(this.ecran.plateau);
			}
			if (e.getSource() == this.gauche) {
				cible.sens = "gauche";
				cible.deplacement(this.ecran.plateau);

			}
			if (e.getSource() == this.droite) {
				cible.sens = "droite";
				cible.deplacement(this.ecran.plateau);

			}
			if (e.getSource() == this.restart) {
				// Il faut restart le niveau
			}
		}
	}
