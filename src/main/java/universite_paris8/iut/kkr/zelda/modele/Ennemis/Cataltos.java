package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Cataltos extends Ennemis {

    public Cataltos(Environnement env) {
        super(680, 45, 2, env, 150, 5);
    }

    @Override
    public void attaquer() {
        getEnnemiAttaque().decrementerPv(getPtAttaque());
        System.out.println("Un Marcos lance un projectile !");
    }

    @Override
    public String toString() {return "un Cataltos";}
}