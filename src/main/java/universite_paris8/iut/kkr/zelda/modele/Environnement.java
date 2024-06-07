package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

import java.util.ArrayList;
import java.util.List;

public class Environnement {

	private int largeur, hauteur;
	private ObservableList<Acteur> acteurs;
	private ObservableList<ObjetEnvironnement> items;
	private IntegerProperty nbToursProperty;

	private int[][] tableauMap = {
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.ARBRES, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.PETIT_ROCHER, Constantes.ARBRES, Constantes.HERBE, Constantes.HERBE, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.GROS_ROCHER, Constantes.GROS_ROCHER, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.COFFRE, Constantes.BUISSON, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.GROS_ROCHER, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, 4, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.VOITURE_ABANDONNEE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.POUBELLE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.PONT, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU},
			{Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.CHEMIN_EN_PIERRE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.PONT, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU, Constantes.EAU},
			{Constantes.LAVE, Constantes.HERBE, Constantes.HERBE, Constantes.CHEMIN_EN_PIERRE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.PONT, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
			{Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.EAU, Constantes.EAU, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE, Constantes.HERBE},
	};

	public Environnement(int largeur, int hauteur) {
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.nbToursProperty = new SimpleIntegerProperty(0);
		this.acteurs = FXCollections.observableArrayList();
		this.items = FXCollections.observableArrayList();

	}

	public int[][] getTableauMap() {
		return this.tableauMap;
	}


	public ObservableList<Acteur> getActeurs() {
		return acteurs;
	}

	public Acteur getActeur(String id) {
		for (Acteur a : this.acteurs) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public ObservableList<ObjetEnvironnement> getItems() {
		return items;
	}

	public void ajouterActeur(Acteur a) {
		acteurs.add(a);
	}

	public void retirerActeur(Acteur a) {
		acteurs.remove(a);
	}

	public void ajouterItem(ObjetEnvironnement a) {
		items.add(a);
	}

	public int getTuile(int x, int y) {

		int colonneGrille = (x) / 30; // Calculer l'indice de la colonne de la grille correspondant à la position x
		int ligneGrille = (y) / 30; // Calculer l'indice de la ligne de la grille correspondant à la position y
//		System.out.println("[" + ligneGrille + "]" + "[" + colonneGrille + "]  = " + tableauMap[ligneGrille][colonneGrille]);
		return tableauMap[ligneGrille][colonneGrille];
	}

	public void retirerItem(ObjetEnvironnement a) {
		items.remove(a);
	}


	public boolean verifObstacle(int x, int y, ActeurEnMouvement a) {
		int largeurPersonnage = 30; // Largeur du personnage en pixels
		int hauteurPersonnage = 30; // Hauteur du personnage en pixels

		if (x < 0 || x + largeurPersonnage > largeur || y < 0 || y + hauteurPersonnage > hauteur) {
			return false;
		}

		int tuile = getTuile(x, y);

		switch (tuile) {
			case 0: // Eau
				if (!(a instanceof Link)) {
					return false;
				}
				break;
			case 1: // Immeubles abandonnés
				return false;
			case 2: // Arbres
				return false;
			case 8: // Voiture abandonnée
				return false;
			case 4: // Coffre
				return false;
			case 5: // Rocher
				return false;
			case 6: // Poubelle
				return false;
			default:
				break;
		}
		return true;
	}


//	public void agir() {
//		ActeurEnMouvement link = (ActeurEnMouvement) this.getLink();
//		if (link != null) {
//			if (!this.getActeurs().isEmpty()) {
//				ArrayList<Acteur> acteurs = new ArrayList<>(this.getActeurs());
//				for (Acteur acteur : acteurs) {
//					if (acteur instanceof ActeurEnMouvement) {
//						ActeurEnMouvement acteurEnMouvement = (ActeurEnMouvement) acteur;
//						acteurEnMouvement.VerifEstVivant();
//						if (acteurEnMouvement instanceof Ennemis) {
//							Ennemis ennemi = (Ennemis) acteurEnMouvement;
//							if (ennemi.estADistanceAttaque(link)) {
//								ennemi.attaquer(link);
//							} else {
//								ennemi.seDeplacer();
//							}
//						}
//					}
//				}
//			}
//		}
//	}

	public void agir() {
		ActeurEnMouvement link = (ActeurEnMouvement) this.getLink();
		if (link != null) {
			ArrayList<Acteur> acteurs = new ArrayList<>(this.getActeurs());
			for (Acteur acteur : acteurs) {
				if (acteur instanceof Ennemis) {
					Ennemis ennemi = (Ennemis) acteur;
					ennemi.VerifEstVivant();
					ennemi.decrementerToursFige();
					if (!ennemi.estFige()) {
						if (ennemi.estADistanceAttaque(link)) {
							ennemi.attaquer(link);
						} else if (verifObstacle(link.getX(), link.getY(), ennemi)){
							ennemi.seDeplacer();
						}
					}
				}
			}
		}
	}

	public Link getLink() {
		for (Acteur a : acteurs) {
			if (a instanceof Link) {
				return (Link) a;
			}
		}
		return null;
	}


	public ActeurEnMouvement trouverEnnemiLePlusProche(int x, int y) {
		ActeurEnMouvement ennemiLePlusProche = null;
		double distanceMin = Double.MAX_VALUE;
		for (Acteur acteur : acteurs) {
			if (acteur instanceof Ennemis) {
				double distance = Math.sqrt(Math.pow(acteur.getX() - x, 2) + Math.pow(acteur.getY() - y, 2));
				if (distance < distanceMin) {
					distanceMin = distance;
					ennemiLePlusProche = (ActeurEnMouvement) acteur;
				}
			}
		}
		return ennemiLePlusProche;
	}

	public List<Ennemis> getEnnemisProches(int x, int y, int portee) {
		List<Ennemis> ennemisProches = new ArrayList<>();
		for (Acteur acteur : acteurs) {
			if (acteur instanceof Ennemis) {
				Ennemis ennemi = (Ennemis) acteur;
				int distanceX = Math.abs(ennemi.getX() - x);
				int distanceY = Math.abs(ennemi.getY() - y);
				double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
				if (distance <= portee) {
					ennemisProches.add(ennemi);
				}
			}
		}
		return ennemisProches;
	}

	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}
}