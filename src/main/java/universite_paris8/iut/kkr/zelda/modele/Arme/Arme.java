package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Arme extends ObjetEnvironnement {
    private int ptAttaque;
    private int porteeArme;
    private Environnement e;

    public Arme(String nom, int ptAttaque, int x, int y, int porteeArme){
        super(nom,x,y);
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

    public Environnement getE() {
        return e;
    }
    //peut etre utiliser une methode utiliser abstract dans la classe armes pour que Link les prenne differemment
}
