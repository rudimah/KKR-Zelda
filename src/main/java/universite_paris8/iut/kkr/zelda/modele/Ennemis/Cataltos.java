package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Cataltos extends Ennemis {

    public Cataltos(Environnement env) {
        super(700, 20, 2, env, 150, 5);
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Cataltos attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }

    @Override
    public String toString() {return "un Cataltos";}
}