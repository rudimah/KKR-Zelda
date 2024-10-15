package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifVitesse implements Pouvoir{
    Environnement environnement;
    int vitesse;
    public modifVitesse(Environnement objetEnvironnement, int vitesse) {
        environnement = objetEnvironnement;
        this.vitesse = vitesse;
    }
    public void utiliser() {
        environnement.getLink().setVitesse(environnement.getLink().getVitesse() + vitesse);
    }
}
