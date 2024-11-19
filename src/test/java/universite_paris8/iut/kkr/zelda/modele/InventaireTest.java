package universite_paris8.iut.kkr.zelda.modele;

//import org.junit.jupiter.api.Test;
//import universite_paris8.iut.kkr.zelda.Controleur.Controleur;
//import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;


import org.junit.jupiter.api.Test;
import universite_paris8.iut.kkr.zelda.Controleur.Controleur;
import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class InventaireTest {

    Inventaire inventaire = new Inventaire();
    Environnement environnement = Environnement.getInstance();

    @Test
    void testAjoutEtBlocageInventaire() {
        ArrayList<Pouvoir> pouvoirs = new ArrayList<>();
        pouvoirs.add(new attaqueEnnemi(environnement,55));
        pouvoirs.add(new attaqueEnnemi(environnement,15));
        //Element 1
        ObjetEnvironnement potionAcide = new ObjetEnvironnement(environnement,"Potion Acide", 40,30,new modifPtAttaque(environnement,2),false);
        //Element 2
        ObjetEnvironnement sabre = new ObjetEnvironnement(environnement,"sabre", 40,30,new cumulPouvoirs(environnement,pouvoirs),true);
        //Element 3
        ObjetEnvironnement bouclier = new ObjetEnvironnement(environnement,"bouclier", 40,30,new modifPv(environnement,2),false);
        //Element 4
        ObjetEnvironnement flute = new ObjetEnvironnement(environnement,"flute", 40,30,new figer(environnement,2),false);
        //Element 5
        ObjetEnvironnement bottesAres = new ObjetEnvironnement(environnement,"bottes d'arès", 40,30,new modifVitesse(environnement,10),false);

        //Ajout de 4 element dans l'inventaire
        inventaire.ajouterItemAInventaire(potionAcide);
        inventaire.ajouterItemAInventaire(sabre);
        inventaire.ajouterItemAInventaire(bouclier);
        inventaire.ajouterItemAInventaire(flute);


        // TEST1 : En cas d'ajout d'un nouveau d'element, l'ajout est bloquer
        inventaire.ajouterItemAInventaire(bottesAres);
        assertEquals(4, inventaire.getInventaire().size());

        //TEST2: En cas d'utilisation d'une deuxième arme, l'arme actuelle se trouve dans l'inventiare
        Link link = new Link(environnement, new DialogueController(new Controleur()));
        environnement.ajouterActeur(link);
        link.utiliser(sabre); //arme actuelle
        link.utiliser(new ObjetEnvironnement(environnement,"epee", 40,30,new attaqueEnnemi(environnement,25),true)); //Nouvelle arme en main de Link
        assertTrue(link.getInventaire().getInventaire().contains(sabre));
    }

    @Test
    public void testSelectionnerItem() {
        ObjetEnvironnement item = new ObjetEnvironnement(environnement,"bouclier", 40,30,new modifPv(environnement,10),false);
        inventaire.ajouterItemAInventaire(item);

        // Sélectionner l'item par son ID
        ObjetEnvironnement selected = inventaire.selectionnerItem(item.getId());

        // Vérifie que l'item retourné est correct
        assertNotNull(selected, "L'item sélectionné ne peut pas être nul");
        assertEquals(item.getId(), selected.getId(), "L'ID de l'item sélectionné devrait ^etre l'accesoire selectionné");
    }
}