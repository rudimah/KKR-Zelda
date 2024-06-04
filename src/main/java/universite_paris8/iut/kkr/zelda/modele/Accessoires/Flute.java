package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class Flute extends Accessoires {
    public Flute(int x, int y, Environnement env) {
        super("Flûte de Calliopé", x, y, 0, 0, 5,env); // Portée de base de 5
    }

    public void appliquerEffet(Link link) {

    }

    @Override
    public void appliquerEffet() {
        Ennemis ennemiProche = (Ennemis) env.trouverEnnemiLePlusProche(env.getLink().getX(), env.getLink().getY());
        if (ennemiProche != null) {
            ennemiProche.figer(20);
            System.out.println(ennemiProche + " est figé pour 5 tours par la Flûte de Calliopé.");
        }
    }
}

