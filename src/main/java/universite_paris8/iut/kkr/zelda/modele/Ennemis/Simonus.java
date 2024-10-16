package universite_paris8.iut.kkr.zelda.modele.Ennemis;


import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Simonus extends Ennemis {
    public Simonus(Environnement env) {
        super(360, 450, 3, env, 100, 3);
    }

    @Override
    public void attaquer() {
        getEnnemiAttaque().decrementerPv(getPtAttaque());
        System.out.println("Un Marcos lance un projectile !");
    }

    @Override
    public String toString() {return "un Simonus";}
}
