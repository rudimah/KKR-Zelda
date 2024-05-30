package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public abstract class Ennemis extends ActeurEnMouvement {

    public Ennemis(int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(x, y, vitesse, env, pointsDeVie, ptAttaque);
    }


    public void seDeplacerVersLink() {
        Acteur link = env.getLink();
        if (link != null) {
            int dx = link.getX() - getX();
            int dy = link.getY() - getY();
            if(env.estPositionValide(dx, dy)){
                setX(getX() + Integer.signum(dx) * getVitesse());
                setY(getY() + Integer.signum(dy) * getVitesse());
            }
        }
        System.out.println("Ennemi se déplace en (" + getX() + ',' + getY() +')' );
    }

    public boolean estMort(){return getPv() <= 0;}

    public void recevoirDegats(int degats) {
        setPv(getPv() - degats);
        if (estMort()) {
            System.out.println("Ennemi tué!");
        } else {
            System.out.println("Ennemi a maintenant " + getPv() + " points de vie.");
        }
    }

    @Override
    public Environnement getEnv() {
        return super.getEnv();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}