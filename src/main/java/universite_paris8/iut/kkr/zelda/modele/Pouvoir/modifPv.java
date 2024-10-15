package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class modifPv implements Pouvoir{
    ObjetEnvironnement objet;
    int pv;
    public modifPv(ObjetEnvironnement objetEnvironnement, int pv){
        this.objet = objetEnvironnement;
        this.pv = pv;
    }

    @Override
    public void utiliser() {
        objet.getEnv().getLink().setPv(objet.getEnv().getLink().getPv()+pv);
    }
}
