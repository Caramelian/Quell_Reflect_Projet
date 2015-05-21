import javax.swing.*;

import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;


public class Ecran extends JPanel {

	// Attributs
	
	private static final long serialVersionUID = 1L;
	public Plateau plateau;
	public GridBagLayout gbl;
	public GridBagConstraints gbc;

	// Constructeurs

	public Ecran(int num) throws IOException {
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.gbc.fill = GridBagConstraints.BOTH;
		this.setLayout(this.gbl);
		this.plateau = new Plateau("Tableau.xml",num);

		dessin();
	}


	// Dessin

		public void dessin() {

			int a = 0;
			ImageIcon image;
			JLabel fenetre;

			removeAll();

			for (int i = 0; i < this.plateau.plateau.length; i++) {
				for (int j = 0; j < this.plateau.plateau[i].length; j++) {

					this.gbc.gridx = i;
					this.gbc.gridy = j;

					if (this.plateau.objetMouvant.length > 0
							&& (this.plateau.objetMouvant[a].x == i && this.plateau.objetMouvant[a].y == j)) {
						image = this.plateau.objetMouvant[a].getImage();
					} else {

						image = this.plateau.plateau[i][j].getImage();

						fenetre = new JLabel(image);

						this.gbl.setConstraints(fenetre, this.gbc);
						add(fenetre);

						revalidate();
						repaint();
					}
				}
			}
		}
		
		// Key Listener

		// Je ne suis pas sur que cette partie va nous être intéressantes.

}
			

		
