package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public abstract class Ennemis extends ActeurEnMouvement {

    public Ennemis(int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(x, y, vitesse, env, pointsDeVie, ptAttaque);
    }


    public void seDeplacer() {
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


    @Override
    public String toString() {
        return super.toString();
    }
}