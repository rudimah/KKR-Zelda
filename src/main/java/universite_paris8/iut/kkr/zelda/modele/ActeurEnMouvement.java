package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;

public abstract class   ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int ptAttaque;
    private IntegerProperty pv ;
    private int largeur, hauteur; //taille tuile (hitbox)
    private ActeurEnMouvement ennemiAttaque;


    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pv, int ptAttaque) {
        super(x, y, env);
        this.vitesse = vitesse;
        this.ptAttaque = ptAttaque;
        this.pv = new SimpleIntegerProperty(pv);
        this.largeur=20;
        this.hauteur =30; //renommage
    }

    public abstract void seDeplacer();

    public abstract void attaquer(ActeurEnMouvement acteurCible);

    public int getVitesse() {
        return vitesse;
    }

    public ActeurEnMouvement getEnnemiAttaque() {return ennemiAttaque;}

    public void setEnnemiAttaque(ActeurEnMouvement ennemiAttaque) {this.ennemiAttaque = ennemiAttaque;}

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPtAttaque() {return ptAttaque;}

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public final void setPv(int pv) {this.pv.setValue(pv);}

    public final int getPv() {return pv.getValue();}

    public int getLargeur(){
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public IntegerProperty pointDeVieProperty(){
        return pv;
    }

    public void decrementerPv(int pointAttaque){
        setPv(getPv() - pointAttaque);
    }

    public boolean VerifierActeurMort(){ //Vérification s'il est mort
        boolean estmort=false;
        if(getPv() <= 0){
            env.retirerActeur(this);
            estmort=true;
        }
        return estmort;
    }


    //TODO:
    public abstract void attaquer();


    public boolean procheDe(int x, int y, int portee){
        /* Cette méthode regarde si les cordonnées passées en paramètre (qui correspond à des objets ou acteur) est proche de l’acteur.  */
        return Math.abs(getX() - x) < portee && Math.abs(getY() - y )< portee;
    }

    //cette methode sert a savoir si des acteurs en mouvement est a porté d'une attaque.

    public void recevoirDegats(int degats) {
        setPv(getPv() - degats);
        if (VerifierActeurMort()) {
            System.out.println("Ennemi tué!");
        } else {
            System.out.println("Ennemi a maintenant " + getPv() + " points de vie.");
        }
    }


}