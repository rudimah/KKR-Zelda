package universite_paris8.iut.kkr.zelda.modele.Ennemis;


import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Marcos extends Ennemis {

    public Marcos(Environnement env) {
        super(200,350 , 3, env, 150, 5);
    }

    @Override
    public void attaquer() {
        getEnnemiAttaque().decrementerPv(getPtAttaque());
        System.out.println("Un Marcos lance un projectile !");
    }

    @Override
    public String toString() {return "un Marcos";}
}
