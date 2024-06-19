package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Arme extends ObjetEnvironnement {
    //super classe des armes. chaque arme a sa facon d'attaquer
    private int ptAttaque;
    private int porteeArme;

    public Arme(String nom, int ptAttaque, int x, int y, int porteeArme, Environnement env){
        super(nom,x,y, env);
        this.ptAttaque = ptAttaque;
        this.porteeArme = porteeArme;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public int getPtAttaque() {return ptAttaque;}

    public void setPortee(int portee) {this.porteeArme = portee;}

    public int getPortee() {return porteeArme;}

    public void attaquerAvecArme(ActeurEnMouvement ennemi) {
        ennemi.recevoirDegats(ptAttaque);
    }

    public boolean estAProximite(ActeurEnMouvement ennemi) {
        int diffX = Math.abs(ennemi.getX() - getX());
        int diffY = Math.abs(ennemi.getY() - getY());
        return (diffX <= porteeArme && diffY <= porteeArme);
    }


    //peut etre utiliser une methode utiliser abstract dans la classe armes pour que Link les prenne differemment

    @Override
    public String toString() {
        return "Arme{" +
                "ptAttaque=" + ptAttaque +
                ", porteeArme=" + porteeArme +
                '}';
    }
}
