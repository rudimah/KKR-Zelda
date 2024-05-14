package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

	private int width,height;
	private ObservableList<Acteur> acteurs;
	private IntegerProperty nbToursProperty;

	private int[][] tableauMap = {
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
			{9,9,9,9,9,9,9,9,9,},
	};

	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.nbToursProperty = new SimpleIntegerProperty(0);
		this.acteurs = FXCollections.observableArrayList();
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

	public void ajouter(Acteur a){
		acteurs.add(a);
	}

	public boolean estPositionValide(int x, int y) {
		// les limites de la map
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return false;
		}
		// vérifications pour les obstacles
		return true;
	}



}