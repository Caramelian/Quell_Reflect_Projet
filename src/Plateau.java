import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;

import org.w3c.dom.Document;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Plateau {
	

	
/// Attributs de la classe Plateau
	
	public Case[][] plateau;               // C'est le plateau du jeu sous forme de tableau
		
	public Case[][] plateauDeDepart;		  // Plateau initial du jeu
	
	private int nombre_Coup_Niveau = 0;
		
	private Ecran ecran;
	
	public objet_Mouvant[] objetMouvant;
		
	public int niveau; // Donne le numéro du niveau associé avec le plateau
		
	private int nombreBulle = 0; // donne le nombre de bulle du plateau
		
	private BufferedReader entree;	
	
	
		
/// Lecture du fichier XML

	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File("Tableau.xml"));
			
			System.out.println(document.getXmlVersion());
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlStandalone());
			
			// Récupérer la racine de l'arbre
			
			Element data = document.getDocumentElement();
			System.out.println(data.getNodeName());	
			
			// Récupérer les noeuds de la racine : level
			
			NodeList dataNoeuds = data.getChildNodes();
			
			int nbDataNoeuds = dataNoeuds.getLength();
			for (int i =0 ; i<nbDataNoeuds; i++){
				if(dataNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE){
					Element level = (Element) dataNoeuds.item(i);
					System.out.println(level.getNodeName());
				}
			}
			
			// Récupérer les différents éléments d'un niveau
			
			Element level = document.getDocumentElement();
			NodeList levelNoeuds = level.getChildNodes();
			
			int nbLevelNoeuds = levelNoeuds.getLength();
			for (int i=0 ; i<nbLevelNoeuds ; i++){
				
					Element length = (Element) levelNoeuds.item(0);					
					int l = Integer.parseInt(length.getNodeValue());
					Element width = (Element) levelNoeuds.item(1);
					int w = Integer.parseInt(width.getNodeValue());
					Element numberOfCoins = (Element) levelNoeuds.item(2);
					int nOC = Integer.parseInt(numberOfCoins.getNodeValue());
				
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "Anneau"){
						Element Anneau = (Element) levelNoeuds.item(i);
						Element coordinateX = (Element) Anneau.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) Anneau.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
						Element color = (Element) Anneau.getElementsByTagName("color").item(i);
						int c = Integer.parseInt(color.getNodeValue());
						Element partner = (Element) Anneau.getElementsByTagName("partner");
						NodeList partnerNoeuds = partner.getChildNodes();
						int nbPartnerNoeuds = partnerNoeuds.getLength();
							for (int j=0 ; j<nbPartnerNoeuds ; j++){
								Element coordinateXPartner = (Element) partner.getElementsByTagName("coordinateX");
								int x1 = Integer.parseInt(coordinateXPartner.getNodeValue());
								Element coordinateYPartner = (Element) partner.getElementsByTagName("coordinateY");
								int y1 = Integer.parseInt(coordinateYPartner.getNodeValue());
								Element colorPartner = (Element) partner.getElementsByTagName("color");
								int c1 = Integer.parseInt(colorPartner.getNodeValue());
							}
						plateauDeDepart [x][y] = new Anneau (c, partner, x, y);
						plateauDeDepart [x][y].setPartenaire (new Anneau (c1, plateauDeDepart[x][y], x1, y1));
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "bloc_Sexue"){
						Element bloc_Sexue = (Element) levelNoeuds.item(i);
						Element male = (Element) bloc_Sexue.getElementsByTagName("male").item(i);
						boolean m = Boolean.parseBoolean(male.getNodeValue());
						Element coordinateX = (Element) bloc_Sexue.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) bloc_Sexue.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
						
						plateauDeDepart [x][y] = new bloc_Sexue (m, x, y, plateau);
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "Bulle"){
						Element Bulle = (Element) levelNoeuds.item(i);
						Element selection = (Element) Bulle.getElementsByTagName("selection").item(i);
						boolean s = Boolean.parseBoolean(selection.getNodeValue());
						Element order = (Element) Bulle.getElementsByTagName("coordinateX").item(i);
						int o = Integer.parseInt(order.getNodeValue());
						Element coordinateX = (Element) Bulle.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) Bulle.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
						
						plateauDeDepart [x][y] = new bloc_Sexue (s, o, x, y, plateau);
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "case_Verte"){
						Element case_Verte = (Element) levelNoeuds.item(i);
						Element coordinateX = (Element) case_Verte.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) case_Verte.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
						
						plateauDeDepart [x][y] = new case_Verte (x, y);
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "case_Vide"){
						Element case_Vide = (Element) levelNoeuds.item(i);
						Element piece = (Element) case_Vide.getElementsByTagName("piece").item(i);
						boolean p = Boolean.parseBoolean(piece.getNodeValue());
						Element coordinateX = (Element) case_Vide.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) case_Vide.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
												
						plateauDeDepart [x][y] = new case_Vide (p, x, y);
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "Mur"){
						Element Mur = (Element) levelNoeuds.item(i);
						Element jewel = (Element) Mur.getElementsByTagName("jewel").item(i);
						boolean j = Boolean.parseBoolean(jewel.getNodeValue());
						Element coordinateX = (Element) Mur.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) Mur.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
												
						plateauDeDepart [x][y] = new Mur (j, x, y);
					}
					if (levelNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && levelNoeuds.item(i).getNodeName() == "Pic"){
						Element Pic = (Element) levelNoeuds.item(i);
						Element up = (Element) Pic.getElementsByTagName("up").item(i);
						boolean u = Boolean.parseBoolean(up.getNodeValue());
						Element down = (Element) Pic.getElementsByTagName("down").item(i);
						boolean d = Boolean.parseBoolean(down.getNodeValue());
						Element right = (Element) Pic.getElementsByTagName("right").item(i);
						boolean r = Boolean.parseBoolean(right.getNodeValue());
						Element left = (Element) Pic.getElementsByTagName("left").item(i);
						boolean le = Boolean.parseBoolean(left.getNodeValue());
						Element color = (Element) Pic.getElementsByTagName("color").item(i);
						int c = Integer.parseInt(color.getNodeValue());
						Element coordinateX = (Element) Pic.getElementsByTagName("coordinateX").item(i);
						int x = Integer.parseInt(coordinateX.getNodeValue());
						Element coordinateY = (Element) Pic.getElementsByTagName("coordinateY").item(i);
						int y = Integer.parseInt(coordinateY.getNodeValue());
												
						plateauDeDepart [x][y] = new Pic (u, d, r, le, c, x, y);
					}
			}
			
		}catch (final ParserConfigurationException e){
			e.printStackTrace();
		
		}catch (final SAXException e){
			e.printStackTrace();
		
		}catch (final IOException e){
			e.printStackTrace();
		}
	}
		
	
	
// Constructeur du plateau (non-terminée)
	
	public Plateau(int num){
	
	// Enregistrement des images correspondant aux objets
	
	// Pour le moment j'ai considéré 2 paires d'anneaux et un type d'interrupteur.
	// ATTENTION : Je n'ai pas mis les images pour les pics et les interrupteurs.
	
	ImageIcon mur = new ImageIcon(getClass().getResource("Image_des_objets/mur.jpg"));
	ImageIcon fissure1 = new ImageIcon(getClass().getResource("Image_des_objets/fissure1.jpg"));
	ImageIcon fissure2 = new ImageIcon(getClass().getResource("Image_des_objets/fissure2.jpg"));
	ImageIcon joyau = new ImageIcon(getClass().getResource("Image_des_objets/joyau.jpg"));
	ImageIcon anneau1 = new ImageIcon(getClass().getResource("Image_des_objets/anneau bleu.jpg"));
	ImageIcon anneau2 = new ImageIcon(getClass().getResource("Image_des_objets/anneau rouge.jpg"));
	ImageIcon blocMale = new ImageIcon(getClass().getResource("Image_des_objets/male.png"));
	ImageIcon blocFeminin = new ImageIcon(getClass().getResource("Image_des_objets/feminin.jpg"));
	ImageIcon bulle = new ImageIcon(getClass().getResource("Image_des_objets/bulle.jpg"));
	ImageIcon caseVerte1 = new ImageIcon(getClass().getResource("Image_des_objets/pointVert.jpg"));
	ImageIcon caseVerte2 = new ImageIcon(getClass().getResource("Image_des_objets/murVert.jpg"));
	ImageIcon vide = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon piece = new ImageIcon(getClass().getResource("Image_des_objets/piece.jpg"));
	ImageIcon interrupteur = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon pic1gauche = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon pic1gaucheHaut = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon pic1gaucheDroite = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon pic1gaucheHautDroite = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	ImageIcon pic1total = new ImageIcon(getClass().getResource("Image_des_objets/vide.jpg"));
	
	// Changement de la taille des images pour les faire correspondre au plateau
	// ATTENTION NON FAIT
	
	
	// Attribution des images correspondantes à chaque objets.
		// Le problème c'est qu'il faut gérer les aspects statiques et pas statiques...
	
	Anneau.image1=anneau1;
	bloc_Sexue.image1=blocMale;
	bloc_Sexue.image2=blocFeminin;
	Bulle.image=bulle;
	case_Verte.image1=caseVerte1;
	case_Verte.image2=caseVerte2;
	case_Vide.image1=vide;
	case_Vide.image2=piece;
	Mur.image1=mur;
	Mur.image2=fissure1;
	Mur.image3=fissure2;
	Mur.image4=joyau;
	Pic.image1=pic1gauche;
	Pic.image2=pic1gaucheHaut;
	Pic.image3=pic1gaucheDroite;
	Pic.image4=pic1gaucheHautDroite;
	Pic.image5=pic1total;
	Switcher.image=interrupteur;
		
	
		
// Méthodes
	
	public objet_Mouvant[] getObjet_mouvant() {
		// begin-user-code
		return objet_Mouvant;
		// end-user-code
	}

	public void setObjet_mouvant(objet_Mouvant[] objet_mouvant) {
		// begin-user-code
		this.objet_Mouvant = objet_mouvant;
		// end-user-code
	}


	public int getNombre_Coup_Niveau() {
		// begin-user-code
		return nombre_Coup_Niveau;
		// end-user-code
	}

	public void setNombre_Coup_Niveau(int nombre_Coup_Niveau) {
		// begin-user-code
		this.nombre_Coup_Niveau = nombre_Coup_Niveau;
		// end-user-code
	}


	

	public Ecran getEcran() {
		// begin-user-code
		return ecran;
		// end-user-code
	}


	public void setEcran(Ecran ecran) {
		// begin-user-code
		this.ecran = ecran;
		// end-user-code
	}
	

	public void	 perdant(String Reponse) {

	}


	public String gagnant() {
	// Il manque à écrire dans quelles conditions ce message s'affiche	
	if (nombre_Piece == 0){
		String gagnant = "Vous avez gagné";
		return gagnant;
	}
	}


	public void calcul_Coup_Optimal(int Parameter1) {

	}


	public int actualiser_Piece() {
		nombre_Piece = nombre_Piece - 1;
		return nombre_Piece;
	}


	public void reinitialiser_Niveau() {

	}


	public void actualiser_Plateau() {
	
	}
	
	
	public int getNombreBulle(){
		
		return this.nombreBulle;
	}
	
	public void setNombreBulle(int nombreBulle){
		this.nombreBulle = nombreBulle;
	}
	
	public void setPlateau(Case[][] t) {
		this.plateau = new Case[(t[0].length)][(t.length)];
		for (int colonne = 0; colonne < t.length; colonne++) {
			for (int ligne = 0; ligne < t[0].length; ligne++) {
				this.plateau[ligne][colonne] = t[ligne][colonne];
			}	
		}
	}

	public void setPlateauDeDepart(Case[][] t) {
		this.plateau = new Case[(t[0].length)][(t.length)];
		for (int colonne = 0; colonne < t.length; colonne++) {
			for (int ligne = 0; ligne < t[0].length; ligne++) {
				this.plateauDeDepart[ligne][colonne] = t[ligne][colonne];

			}	
		}
	}
	
// Reinitialisation du plateau
	
	public void restartPlateau() {
		// Gérer la réinitialisation des pièces, en fonction de leur initialisation de base
		for (int i = 0; i < objetMouvant.length; i++) {
			objetMouvant[i].x=objetMouvant[i].xi;
			objetMouvant[i].y=objetMouvant[i].yi;

		}
		setPlateau(plateauDeDepart);

	}

	
}