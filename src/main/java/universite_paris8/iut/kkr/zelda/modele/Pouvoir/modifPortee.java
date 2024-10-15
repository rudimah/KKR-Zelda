package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class modifPortee implements Pouvoir{
    ObjetEnvironnement objet;
    int portee;
    public modifPortee(ObjetEnvironnement objetEnvironnement, int portee) {
        objet = objetEnvironnement;
        this.portee = portee;
    }

    @Override
    public void utiliser() {
        objet.getEnv().getLink().getArme().setPortee(objet.getEnv().getLink().getArme().getPortee()+portee);
    }
}
