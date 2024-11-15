package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import java.util.List;

public class figer extends Pouvoir{

    public figer(Environnement environnement, int portee) {
        super(environnement, portee);
    }


    @Override
    public void utiliser() {
        List<Ennemis> ennemisProches = getEnvironnement().listeEnnemisProcheDeLink(getModificateur());
        if (!ennemisProches.isEmpty()){
            for(Ennemis ennemiProche : ennemisProches){
                ennemiProche.figer(34);// equivalant à 5 sec vu que la gameLoop se réitère toutes les 0.15 secondes
                System.out.println(ennemiProche + " est figé pour 5 secondes par la Flûte de Calliopé.");
            }
        }
    }
}
