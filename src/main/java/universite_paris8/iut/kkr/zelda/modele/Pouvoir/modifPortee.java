package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifPortee implements Pouvoir{
    Environnement environnement;
    int portee;
    public modifPortee(Environnement objetEnvironnement, int portee) {
        environnement = objetEnvironnement;
        this.portee = portee;
    }
    @Override
    public void utiliser() {
        environnement.getLink().getArme().setPortee(environnement.getLink().getArme().getPortee()+portee);
    }
}
