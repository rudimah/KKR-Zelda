package universite_paris8.iut.kkr.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.kkr.zelda.modele.DeplacementStrategy.DeplacementBFSStrategy;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.*;
import universite_paris8.iut.kkr.zelda.utils.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environnement {

	private int largeur, hauteur;
	private ObservableList<Acteur> listeActeurs;
	private ObservableList<ObjetEnvironnement> listeItems;
	private int tourActuel = 0;
	private Carte m;
	private DeplacementBFSStrategy deplacement;//assigner la carte a un environnement


	//Constructeur
	public Environnement(int largeur, int hauteur, Carte carte1) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.listeActeurs = FXCollections.observableArrayList();
		this.listeItems = FXCollections.observableArrayList();
		this.m = carte1;
	}


	//getters et setter

	public ObservableList<Acteur> getListeActeurs() {
		return listeActeurs;
	}
	public ObservableList<ObjetEnvironnement> getItems() { //liste d'item
		return listeItems;
	}
	public int getLargeur() {
		return largeur;
	}
	public int getHauteur() {
		return hauteur;
	}

	public Link getLink() {
		for (Acteur a : listeActeurs) {
			if (a instanceof Link) {
				return (Link) a;
			}
		}
		return null;
	}


	//Ajouts et suppression dans les listes
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




	//Méthode principaux de cette classe

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
						} else if (deplacement.verificationObstacles(link.getX(), link.getY())) { //Deplacement des ennemis si j'ai bien compris alors coté DEplacementBFSSrategy
							ennemi.seDeplacer();
						}
					}
				}
			}
		}
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
		} while (!deplacement.verificationObstacles(x, y) || ADistanceDeLink(x, y)<15*15); //vu que cest que cest les ennemis qui vérifie les obstacles jai mis la méthode verifObstacle avec BFS

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