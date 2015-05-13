import javax.swing.*;

import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;


public class Ecran extends JPanel {

	// Attributs

	public Plateau grille;
	public GridBagLayout gbl;
	public GridBagConstraints gbc;

	// Constructeurs

	public Ecran(int num) throws IOException {
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.gbc.fill = GridBagConstraints.BOTH;
		this.setLayout(this.gbl);
		this.grille = new Plateau(num);

		dessin();
	}

	// Dessiner

	public void dessin() {

		int a = 0;
		ImageIcon image;
		JLabel fenetre;

		removeAll();

		for (int i = 0; i < this.grille.plateau.length; i++) {
			for (int j = 0; j < this.grille.plateau[i].length; j++) {

				this.gbc.gridx = i;
				this.gbc.gridy = j;

				if (this.grille.objetMouvant.length > 0
						&& (this.grille.objetMouvant[a].x == i && this.grille.objetMouvant[a].y == j)) {
					image = this.grille.objetMouvant[a].getImage();
				} else {

					image = this.grille.plateau[i][j].getImage();

					fenetre = new JLabel(image);

					this.gbl.setConstraints(fenetre, this.gbc);
					add(fenetre);

					revalidate();
					repaint();
				}
			}
		}

	}
}
