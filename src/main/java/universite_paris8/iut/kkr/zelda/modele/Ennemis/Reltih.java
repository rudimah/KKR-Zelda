package universite_paris8.iut.kkr.zelda.modele.Ennemis;


import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Reltih extends Ennemis {

    public Reltih(Environnement env) {
        super(500, 300, 3, env, 100, 3);
    }

    public void attaquer() {
        getEnnemiAttaque().decrementerPv(getPtAttaque());
        System.out.println("Un Marcos lance un projectile !");
    }

    @Override
    public String toString() {return "un Reltih";}
}
