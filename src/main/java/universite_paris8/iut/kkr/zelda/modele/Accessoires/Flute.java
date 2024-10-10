package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


import java.util.List;

public class Flute extends Accessoires {
    public Flute(int x, int y, Environnement env) {
        super("Flûte de Calliopé", x, y, 0, 0, 30, env); // Portée de base de 30
    }

    @Override
    public void appliquerEffet() {
        List<Ennemis> ennemisProches = env.listeEnnemisProcheDeLink(getPortee());
        if (!ennemisProches.isEmpty()){
            for(Ennemis ennemiProche : ennemisProches){
                ennemiProche.figer(34);// equivalant à 5 sec vu que la gameLoop se réitère toutes les 0.15 secondes
                System.out.println(ennemiProche + " est figé pour 5 secondes par la Flûte de Calliopé.");
            }
        }
    }
}