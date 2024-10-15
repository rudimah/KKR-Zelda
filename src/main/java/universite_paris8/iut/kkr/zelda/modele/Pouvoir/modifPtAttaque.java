package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class modifPtAttaque implements Pouvoir{
    ObjetEnvironnement objet;
    int ptAttaque;
    public modifPtAttaque(ObjetEnvironnement objetEnvironnement, int ptAttaque) {
        objet = objetEnvironnement;
        this.ptAttaque = ptAttaque;
    }
    @Override
    public void utiliser() {
        objet.getEnv().getLink().setPtAttaque( objet.getEnv().getLink().getPtAttaque() + ptAttaque);
    }
}
