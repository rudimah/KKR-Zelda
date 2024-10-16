package universite_paris8.iut.kkr.zelda.modele;

import org.junit.jupiter.api.Test;
import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Accessoires;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Arme.Epee;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {
    private Environnement env= new Environnement(800, 800);

    private DialogueController dialogueController= new DialogueController(null);
    private Link link= new Link(env, dialogueController);;


    @Test
    public void testSeDeplacer() {
        int initialY = link.getY();
        link.setDirection(Constantes.Haut);
        link.seDeplacer();
        assertEquals(initialY - link.getVitesse(), link.getY(), "Link devrait se déplacer vers le haut selon la vitesse définie");
    }

    @Test
    public void testRamasserItem() {
        Epee epee = new Epee(link.getX() + 10, link.getY() + 10, env);
        env.ajouterItem(epee);
        assertFalse(epee.EstRamassé(), "Item non ramasser");
        link.ramasserItem();
        assertTrue(link.getInventaire().getInventaire().contains(epee), "Link a un item");
    }

    @Test
    public void testAttaquerAvecArme() {
        Ennemis ennemi = new Ennemis("Relith", 500, 300, 3, env, 100, 3);
        env.ajouterActeur(ennemi);
        link.utiliser(new Epee(100, 100, env)); // Équipe Link avec une épée
        link.attaquer(ennemi);

        assertTrue(ennemi.getPv() < 100, "Les PV de l'ennemi devraient être réduits après une attaque");
    }

    @Test
    public void testUtiliserAccessoire() {
        Accessoires bottesAres = new BottesAres(100, 100, env);
        env.ajouterActeur(new Link(env, dialogueController));
        int vitesseInitiale = link.getVitesse();
        link.utiliser(bottesAres);
        assertNotNull(link.getAccessoireActuel(), "Après utilisation, l'accessoire ne devrait pas être null");
        assertTrue(link.getVitesse() > vitesseInitiale, "Utiliser des bottes devrait augmenter la vitesse de Link");
    }
}
