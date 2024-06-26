package universite_paris8.iut.kkr.zelda.modele.Ennemis;


import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Simonus extends Ennemis {
    public Simonus(Environnement env) {
        super(360, 450, 3, env, 100, 3);
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Simonus attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }

    @Override
    public String toString() {return "un Simonus";}
}
