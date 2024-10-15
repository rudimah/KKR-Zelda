package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import java.util.List;

public class figer implements Pouvoir{
    Environnement environnement;
    int portee;
    public figer(Environnement objetEnvironnement, int portee) {
        environnement = objetEnvironnement;
        this.portee = portee;
    }

    @Override
    public void utiliser() {
        List<Ennemis> ennemisProches = environnement.listeEnnemisProcheDeLink(portee);
        if (!ennemisProches.isEmpty()){
            for(Ennemis ennemiProche : ennemisProches){
                ennemiProche.figer(34);// equivalant à 5 sec vu que la gameLoop se réitère toutes les 0.15 secondes
                System.out.println(ennemiProche + " est figé pour 5 secondes par la Flûte de Calliopé.");
            }
        }
    }
}
