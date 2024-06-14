package universite_paris8.iut.kkr.zelda.modele;

import org.junit.jupiter.api.Test;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.Arc;
import universite_paris8.iut.kkr.zelda.modele.Arme.Fleche;
import universite_paris8.iut.kkr.zelda.modele.Arme.Sabre;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;

import static org.junit.jupiter.api.Assertions.*;
class InventaireTest {

    Inventaire inventaire = new Inventaire();

    @Test
    void ajouterItemAInventaire() {
        Environnement environnement =  new Environnement(800, 800);

        //Element 1
        ObjetEnvironnement potion = new PotionForce(40, 30, environnement);
        //Element 2
        ObjetEnvironnement sabre =  new Sabre(50,30);
        //Element 3
        ObjetEnvironnement flute = new Flute(60, 30, environnement);
        //Element 4
        ObjetEnvironnement  bouclier  = new Bouclier(70, 30, environnement);

        //Ajout de 4 element dans l'inventaire
        inventaire.ajouterItemAInventaire(potion); inventaire.ajouterItemAInventaire(sabre); inventaire.ajouterItemAInventaire(flute);inventaire.ajouterItemAInventaire(bouclier);




        // TEST1 : En cas d'ajout d'un nouveau d'element, l'ajout est bloquer
        inventaire.ajouterItemAInventaire(flute);
        assertEquals(4, inventaire.getInventaire().size());


        //TEST2: En cas d'utilisation d'une deuxième arme, l'arme actuelle se trouve dans l'inventiare
        Link link = new Link(environnement);
        link.utiliser(sabre); //arme actuelle
        link.utiliser(new Arc(80,30)); //Nouvelle arme en main de Link

        assertTrue(link.getInventaire().getInventaire().contains(sabre));
    }
}