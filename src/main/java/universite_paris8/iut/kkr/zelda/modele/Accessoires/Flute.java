package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class Flute extends Accessoires {
    public Flute(int x, int y) {
        super("Flûte de Calliopé", x, y, 0, 0, 5); // Portée de base de 5
    }

    public void appliquerEffet(Link link) {
        Ennemis ennemiProche = (Ennemis) link.getEnv().trouverEnnemiLePlusProche(link.getX(), link.getY());
        if (ennemiProche != null) {
            ennemiProche.figer(5);
            System.out.println("Ennemi le plus proche figé pour 5 tours par la Flûte de Calliopé.");
        }
    }
}

