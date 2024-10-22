package universite_paris8.iut.kkr.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environnement {

	private int largeur, hauteur;
	private ObservableList<Acteur> listeActeurs;
	private ObservableList<ObjetEnvironnement> listeItems;
	private int tourActuel = 0;
	private int[][] tableauMap = {
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE , Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE,  Constantes.HERBE, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE,  Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.PETIT_ROCHER, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.GROS_ROCHER, Constantes.GROS_ROCHER, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.GROS_ROCHER, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.VOITURE_ABANDONNEE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.POUBELLE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.PONT, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.CHEMIN_EN_PIERRE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.PONT, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.CHEMIN_EN_PIERRE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.COFFRE, Constantes.HERBE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE, Constantes.LAVE},};

	public Environnement(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.listeActeurs = FXCollections.observableArrayList();
		this.listeItems = FXCollections.observableArrayList();
	}

	public int[][] getTableauMap() {
		return this.tableauMap;
	}


	public ObservableList<Acteur> getListeActeurs() {
		return listeActeurs;
	}


	public ObservableList<ObjetEnvironnement> getItems() { //liste d'item
		return listeItems;
	}

	public void ajouterActeur(Acteur a) {
		listeActeurs.add(a);
	}

	public void retirerActeur(Acteur a) {
		listeActeurs.remove(a);
	}
	public void ajouterItem(ObjetEnvironnement a) {
		listeItems.add(a);
	}
	public void retirerItem(ObjetEnvironnement a) {
		listeItems.remove(a);
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getTuile(int x, int y) { //renommage

		int colonneGrille = (x) / 30; // Calculer l'indice de la colonne de la grille correspondant à la position x
		int ligneGrille = (y) / 30; // Calculer l'indice de la ligne de la grille correspondant à la position y
//		System.out.println("[" + ligneGrille + "]" + "[" + colonneGrille + "]  = " + tableauMap[ligneGrille][colonneGrille]);
		return tableauMap[ligneGrille][colonneGrille];
	}




	public boolean verifObstacle(int x, int y, ActeurEnMouvement a) {
		int largeurPersonnage = 20; // Largeur du personnage en pixels
		int hauteurPersonnage = 30; // Hauteur du personnage en pixels

		if (x < 0 || x + largeurPersonnage > largeur || y < 0 || y + hauteurPersonnage > hauteur) {
			return false;
		}

		int tuile = getTuile(x, y);

		switch (tuile) {
			case Constantes.EAU: // Eau
				if (!(a instanceof Link)) {
					return false;
				}
				break;
			case Constantes.IMMEUBLES_ABANDONNES: // Immeubles abandonnés
				return false;
			case Constantes.ARBRES: // Arbres
				return false;
			case Constantes.VOITURE_ABANDONNEE: // Voiture abandonnée
				return false;
			case Constantes.PETIT_ROCHER: // Rocher
				return false;
			case Constantes.POUBELLE: // Poubelle
				return false;
			case Constantes.GROS_ROCHER:
				return false;
			default:
				break;
		}
		return true;
	}



	public void agir() {
		ActeurEnMouvement link =  this.getLink();
		if (link != null) {
			ArrayList<Acteur> acteurs = new ArrayList<>(this.getListeActeurs());
			for (Acteur acteur : acteurs) {
				if (acteur instanceof Ennemis) {
					Ennemis ennemi = (Ennemis) acteur;
					ennemi.decrementerToursFige();
					if (!ennemi.estFige()) { //	TODO: mettre cette vérification dans les méthode qui sont appler ci dessus (attaquer/ se deplcaer)
						if (ennemi.procheDe(link.getX(), link.getY(), 5)) {
							ennemi.attaquer(link);
						} else if (verifObstacle(link.getX(), link.getY(), ennemi)) {
							ennemi.seDeplacer();
						}
					}
				}
			}
		}
	}

	public Link getLink() {
		for (Acteur a : listeActeurs) {
			if (a instanceof Link) {
				return (Link) a;
			}
		}
		return null;
	}

	public double ADistanceDeLink(int postionX, int postionY){
		return Math.sqrt(Math.pow(postionX - getLink().getX(),2)+Math.pow(postionY - getLink().getY(),2));
	}


	public List<Ennemis> listeEnnemisProcheDeLink(int portee) {
		//Retourne la liste d'ennemis proche de link
		List<Ennemis> ennemisProches = new ArrayList<>();
		for (Acteur acteur : listeActeurs) {
			if (acteur instanceof Ennemis) {
				double distance = ADistanceDeLink(acteur.getX(), acteur.getY());
				if (distance <= portee) {
					ennemisProches.add((Ennemis) acteur);
				}
			}
		}
		return ennemisProches;
	}

	public ActeurEnMouvement ennemiProcheDeLink(){
		//Parmi la liste des ennemis  proches, la méthode retourne celui qui est plus proche de Link
		List<Ennemis> listeEnnemisProche = listeEnnemisProcheDeLink(15);
		if (listeEnnemisProche.isEmpty()){
			return null;
		}
		double minDistance = ADistanceDeLink(listeEnnemisProche.get(0).getX(), listeEnnemisProche.get(0).getY());
		Ennemis ennemisProche = listeEnnemisProche.get(0);
		for (int i = 1; i < listeEnnemisProche.size(); i++){
			double distance = ADistanceDeLink(listeEnnemisProche.get(i).getX(), listeEnnemisProche.get(i).getY());
			if(distance< minDistance){
				ennemisProche = listeEnnemisProche.get(i);
				minDistance = distance;
			}
		}
		return ennemisProche;
	}


	//Choisit l'ennemi à faire apparaitre et le crée.
	public ActeurEnMouvement ennemisAleatoire() {
		Random rand = new Random();
		int aleatoire = rand.nextInt(100);
		if (aleatoire < 50) {
			return new Ennemis("Marcos", 200,350 , 3, this, 150, 5);
		} else if (aleatoire < 75) {
			return  new Ennemis("Relith", 500, 300, 3, this, 100, 3);
		} else if (aleatoire < 90) {
			return new Ennemis("Simonus", 360, 450, 3, this, 100, 3);
		} else {
			return new Ennemis("Cataltos", 680, 45, 2, this, 150, 5);
		}
	}

//fait apparaitre les ennemis dans l'environnement a une distance de 15²(dans un rayon de 15 pixels) de Link
	public void SpawnEnnemis() {
		Random rand = new Random();
		ActeurEnMouvement ennemis = ennemisAleatoire();
		int x, y;

		do {
			x = rand.nextInt(largeur);
			y = rand.nextInt(hauteur);
		} while (!verifObstacle(x, y, null) || ADistanceDeLink(x, y)<15*15);

		ajouterActeur(ennemis);
	}

	public void incrementerTour() {
		tourActuel++;
		if (tourActuel % 120 == 0) {
			SpawnEnnemis();
		}
		if(tourActuel==120){
			ajouterActeur(new Ennemis("Bonnoctus", 650, 550, 3, this, 10000, 4));
		}
	}
}