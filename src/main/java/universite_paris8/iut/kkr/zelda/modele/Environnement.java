package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.utils.ConstantesTuile;

import java.util.ArrayList;
import java.util.List;

public class Environnement {

	private int largeur, hauteur;
	private ObservableList<Acteur> acteurs;
	private ObservableList<ObjetEnvironnement> items;
	private IntegerProperty nbToursProperty;

	private int[][] tableauMap = {
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, 2, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, 2, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, 2, ConstantesTuile.HERBE, ConstantesTuile.HERBE, 3, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, 4, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.EAU},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
			{ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.EAU, ConstantesTuile.EAU, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE, ConstantesTuile.HERBE},
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

	public int getTileId(int x, int y) {

		int colonneGrille = (x) / 30; // Calculer l'indice de la colonne de la grille correspondant à la position x
		int ligneGrille = (y) / 30; // Calculer l'indice de la ligne de la grille correspondant à la position y
		System.out.println("[" + ligneGrille + "]" + "[" + colonneGrille + "]  = " + tableauMap[ligneGrille][colonneGrille]);
		return tableauMap[ligneGrille][colonneGrille];
	}

	public void retirerItem(ObjetEnvironnement a) {
		items.remove(a);
	}


	public boolean estPositionValide(int x, int y) {
		int tailleTuile = 30; // Taille d'une tuile en pixels
		int largeurPersonnage = 20; // Largeur du personnage en pixels
		int hauteurPersonnage = 20; // Hauteur du personnage en pixels

		if (x < 0 || x + largeurPersonnage > largeur || y < 0 || y + hauteurPersonnage > hauteur) {
			return false;
		}

		// Vérifier les 4 coins du personnage
		int[][] coinsPersonnage = {{x, y}, {x + largeurPersonnage, y}, {x, y + hauteurPersonnage}, {x + largeurPersonnage, y + hauteurPersonnage}};

		int tileId = getTileId(x, y);
		switch (tileId) {
			case 0: // Eau
				return true;
			case 1: // Immeubles abandonnés
			case 2: // Arbres

			case 8: // Voiture abandonnée
				return false;
			case 4: // Coffre
			case 5: // Rocher
			case 6: // Poubelle
				return false;
			case 9: // Herbe (passable)
				break;
			case 10: // Lave
				// Logique pour enlever des points de vie sera gérée dans la classe Link
				break;
			default:
				System.out.println("Où est-ce qu'on est !?");
				break;


		}


		return true;
	}

	public Acteur getLink() {
		for (Acteur a : acteurs) {
			if (a instanceof Link) {
				return a;
			}
		}
		return null;
	}


	public void miseAJour() {
		ActeurEnMouvement link = (ActeurEnMouvement) this.getLink();
		if (link != null) {
			if (!this.getActeurs().isEmpty()) {
				ArrayList<Acteur> acteurs = new ArrayList<>(this.getActeurs());
				for (Acteur acteur : acteurs) {
					if (acteur instanceof ActeurEnMouvement) {
						ActeurEnMouvement acteurEnMouvement = (ActeurEnMouvement) acteur;
						acteurEnMouvement.VerifEstVivant();
						if (acteurEnMouvement instanceof Ennemis) {
							Ennemis ennemi = (Ennemis) acteurEnMouvement;
							if (ennemi.estADistanceAttaque(link)) {
								ennemi.attaquer(link);
							} else {
								ennemi.seDeplacerVersLink();
							}
						}
					}
				}
			}
		}
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
}