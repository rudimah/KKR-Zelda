package universite_paris8.iut.kkr.zelda.modele;

import org.junit.jupiter.api.Test;
import universite_paris8.iut.kkr.zelda.Controleur.Controleur;
import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Arme.Arc;
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
        ObjetEnvironnement flute = new Bouclier(60, 30, environnement);
        //Element 4
        ObjetEnvironnement  bouclier  = new Bouclier(70, 30, environnement);

        //Ajout de 4 element dans l'inventaire
        inventaire.ajouterItemAInventaire(potion); inventaire.ajouterItemAInventaire(sabre); inventaire.ajouterItemAInventaire(flute);inventaire.ajouterItemAInventaire(bouclier);




        // TEST1 : En cas d'ajout d'un nouveau d'element, l'ajout est bloquer
        inventaire.ajouterItemAInventaire(flute);
        assertEquals(4, inventaire.getInventaire().size());


        //TEST2: En cas d'utilisation d'une deuxième arme, l'arme actuelle se trouve dans l'inventiare
        Link link = new Link(environnement, new DialogueController(new Controleur()));
        link.utiliser(sabre); //arme actuelle
        link.utiliser(new Arc(80,30)); //Nouvelle arme en main de Link

        assertTrue(link.getInventaire().getInventaire().contains(sabre));
    }

    @Test
    public void testAjouterItemAInventaire() {
        ObjetEnvironnement item1 = new ObjetEnvironnement("Épée", 100, 100);
        ObjetEnvironnement item2 = new ObjetEnvironnement("Bouclier", 200, 100);
        inventaire.ajouterItemAInventaire(item1);
        inventaire.ajouterItemAInventaire(item2);

        // Vérifie que les deux items ont été ajoutés à l'inventaire
        assertTrue(inventaire.getInventaire().contains(item1) && inventaire.getInventaire().contains(item2));
        assertEquals(2, inventaire.getInventaire().size(), "L'inventaire a deux items");
    }

    @Test
    public void testInventairePlein() {
        // Ajout de 4 items à l'inventaire
        for (int i = 0; i < 4; i++) {
            ObjetEnvironnement item = new ObjetEnvironnement("Potion" + i, 100, 100);
            inventaire.ajouterItemAInventaire(item);
        }

        // Essayer d'ajouter un cinquième item
        ObjetEnvironnement item5 = new ObjetEnvironnement("Arc", 100, 100);
        inventaire.ajouterItemAInventaire(item5);

        // Vérifie que le cinquième item n'a pas été ajouté
        assertFalse(inventaire.getInventaire().contains(item5), "L'inventaire est plein");
        assertEquals(4, inventaire.getInventaire().size(), "L'inventaire est limité à quatre items");
    }



    @Test
    public void testSelectionnerItem() {
        ObjetEnvironnement item = new ObjetEnvironnement("Flèche", 100, 100);
        inventaire.ajouterItemAInventaire(item);

        // Sélectionner l'item par son ID
        ObjetEnvironnement selected = inventaire.selectionnerItem(item.getId());

        // Vérifie que l'item retourné est correct
        assertNotNull(selected, "L'item sélectionné ne peut pas être nul");
        assertEquals(item.getId(), selected.getId(), "L'ID de l'item sélectionné devrait ^etre l'accesoire selectionné");
    }
}