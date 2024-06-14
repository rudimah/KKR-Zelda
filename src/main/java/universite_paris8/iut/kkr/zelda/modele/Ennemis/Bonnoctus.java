package universite_paris8.iut.kkr.zelda.modele.Ennemis;


import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Bonnoctus extends Ennemis {


    public Bonnoctus(Environnement env) {
        super(0, 0, 3, env, 10000, 250);
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Bonnoctus attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }

    @Override
    public String toString() {return "Bonnoctus";}
}