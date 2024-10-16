package universite_paris8.iut.kkr.zelda.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnnemisTest {
    private Environnement env= new Environnement(800, 800);
    private Ennemis ennemi= new Ennemis("Marcos", 200,350 , 3, env, 150, 5);


    @Test
    public void testSeDeplacerVersLink() {
        Link link = new Link(env, null);
        env.ajouterActeur(link);
        ennemi.seDeplacer();
        // Vérifiez que l'ennemi s'est rapproché de Link
        assertTrue(Math.abs(ennemi.getX() - link.getX()) < 100);
        assertTrue(Math.abs(ennemi.getY() - link.getY()) < 100);
    }

    @Test
    public void testFigerEnnemi() {
        ennemi.figer(3);
        assertTrue(ennemi.estFige(), "L'ennemi doit être figé");
        ennemi.decrementerToursFige();
        ennemi.decrementerToursFige();
        assertTrue(ennemi.estFige(), "L'ennemi doit toujours être figé");
        ennemi.decrementerToursFige();
        assertFalse(ennemi.estFige(), "L'ennemi ne doit plus être figé");
    }
    @Test
    public void seDeplacer() {
        int nouvposX = ennemi.getX();
        int nouvposY = ennemi.getY();

        //  vérifier si le nouvel emplacement est accessible
        if (env.verifObstacle(nouvposX, nouvposY, ennemi)) {
            ennemi.setX(nouvposX);
            ennemi.setY(nouvposY);
        }
    }


    @Test
    public void testObstacleBloqueEnnemi() {
        Environnement Env = new Environnement(800, 800) {
            @Override
            public boolean verifObstacle(int x, int y, ActeurEnMouvement a) {
                return false; // Bloque tous les mouvements
            }
        };
        Ennemis ennemi = new Ennemis("Cataltos", 680, 45, 2, env, 150, 5);
        Link link = new Link(Env, null);
        ennemi.attaquer(link);

        int posX = ennemi.getX();
        int posY = ennemi.getY();

        ennemi.seDeplacer();


        assertEquals(posX, ennemi.getX(), "L'ennemi ne doit pas se déplacer en X");
        assertEquals(posY, ennemi.getY(), "L'ennemi ne doit pas se déplacer en Y");
    }

}