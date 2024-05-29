package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

	private int width,height;
	private ObservableList<Acteur> acteurs;
	private ObservableList<Item> items;
	private IntegerProperty nbToursProperty;

	private int[][] tableauMap = {
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9},

			{9,9,9,1,1,1,1,1,1,1,9,9,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,1,1,1,1,1,1,1,9,9,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,1,1,1,1,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9},

			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,1,1,1,1,1},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,1,1,1,1,1},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,9,9,9,9,9},

	};

	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.nbToursProperty = new SimpleIntegerProperty(0);
		this.acteurs = FXCollections.observableArrayList();
		this.items = FXCollections.observableArrayList();
	}

	public int[][] getTableauMap(){return this.tableauMap;}


	public ObservableList<Acteur> getActeurs() {
		return acteurs;
	}

	public Acteur getActeur(String id) {
		for(Acteur a:this.acteurs){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}

	public ObservableList<Item> getItems() {return items;}

	public void ajouterActeur(Acteur a){
		acteurs.add(a);
	}

	public void ajouterItem(Item a){items.add(a);}

	public void retirerItem(Item a){items.remove(a);}

//	public boolean estPositionValide(int x, int y) {
//		// les limites de la map
//		if (x < 0 || x >= width || y < 0 || y >= height) {
//			return false;
//		}
//
//		// Convertir les coordonnées en pixels vers les coordonnées de la grille
//		int gridX = x / 30; // Supposons que chaque case fait 30x30 pixels
//		int gridY = y / 30;
//
//		// Vérifier si la position sur la grille est de l'eau
//		if (tableauMap[gridY][gridX] == 1) {
//			System.out.println("Il y a de l'eau à (" + gridX + ", " + gridY + ")");
//			return false;
//		}
//
//		return true;
//	}

	public boolean estPositionValide(int x, int y) {
		int tailleTuile = 30; // Taille d'une tuile en pixels
		int largeurPersonnage = 20; // Largeur du personnage en pixels
		int hauteurPersonnage = 20; // Hauteur du personnage en pixels

		if (x < 0 || x + largeurPersonnage > width || y < 0 || y + hauteurPersonnage > height) {
			return false;
		}

		// Vérifier les 4 coins du personnage
		int[][] coins = {
				{x, y},
				{x + largeurPersonnage, y},
				{x, y + hauteurPersonnage},
				{x + largeurPersonnage, y + hauteurPersonnage}
		};

		for (int[] coin : coins) {
			int gridX = coin[0] / tailleTuile;
			int gridY = coin[1] / tailleTuile;

			if (tableauMap[gridY][gridX] == 1) {
				System.out.println("Il y a de l'eau à (" + gridX + ", " + gridY + ")");
				return false;
			}
		}

		return true;
	}

}