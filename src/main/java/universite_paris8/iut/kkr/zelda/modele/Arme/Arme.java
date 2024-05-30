package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Arme extends ObjetEnvironnement {
    private int ptAttaque;
    private int porteeArme;

    public Arme(String nom, int ptAttaque, int x, int y, int porteeArme){
        super(nom,x,y);
        this.ptAttaque = ptAttaque;
        this.porteeArme = porteeArme;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public int getPtAttaque() {return ptAttaque;}

    public void setPortee(int portee) {this.porteeArme = portee;}

    public int getPortee() {return porteeArme;}

    public void attaquer(Ennemis ennemi) {
        if (ennemi == null) {
            System.out.println("Aucun ennemi ciblé.");
            return;
        }
        if (ennemi.estMort()) {
            System.out.println("L'ennemi est déjà mort.");
            return;
        }
        if (estAProximite(ennemi)) {
            ennemi.recevoirDegats(ptAttaque);
            System.out.println("Attaque réussie! Ennemi à " + ennemi.getX() + ", " + ennemi.getY() + " reçoit " + ptAttaque + " points de dégâts.");
        } else {
            System.out.println("Ennemi hors de portée.");
        }
    }

    public boolean estAProximite(Ennemis ennemi) {
        int diffX = Math.abs(ennemi.getX() - getX());
        int diffY = Math.abs(ennemi.getY() - getY());
        return (diffX <= porteeArme && diffY <= porteeArme);
    }


    //peut etre utiliser une methode utiliser abstract dans la classe armes pour que Link les prenne differemment
}
