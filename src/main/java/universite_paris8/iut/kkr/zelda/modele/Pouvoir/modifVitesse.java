package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifVitesse extends Pouvoir{

    public modifVitesse(Environnement environnement, int vitesse) {
        super(environnement, vitesse);
    }
    public void utiliser() {
        getEnvironnement().getLink().setVitesse(getEnvironnement().getLink().getVitesse() + getModificateur());
    }


}
