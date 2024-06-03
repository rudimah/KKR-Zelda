package universite_paris8.iut.kkr.zelda.modele;

public abstract class ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int ptAttaque;
    private int pv;

    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pv, int ptAttaque) {
        super(x, y, env);
        this.vitesse = vitesse;
        this.ptAttaque = ptAttaque;
        this.pv = pv;
    }

    public abstract void seDeplacer();

    public int getVitesse() {
        return vitesse;
    }

    public int getPtAttaque() {return ptAttaque;}

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public void setPv(int pv) {this.pv = pv;}

    public int getPv() {return pv;}

    public void decrementerPv(int pointAttaque){
        setPv(getPv() - pointAttaque);
    }

    public void VerifEstVivant(){
        if(estMort()){
            env.retirerActeur(this);
        }
    }

    public boolean estMort(){return getPv() <= 0;}
    public boolean estADistanceAttaque(Acteur ActeurCible) {
        int distanceX = Math.abs(getX() - ActeurCible.getX());
        int distanceY = Math.abs(getY() - ActeurCible.getY());
        int distanceManhattan = distanceX + distanceY;

        // Par exemple, l'ennemi peut attaquer si la distance est de 5 case ou moins
        return distanceManhattan <= 5;
    }
    public void recevoirDegats(int degats) {
        setPv(getPv() - degats);
        if (estMort()) {
            System.out.println("Ennemi tué!");
        } else {
            System.out.println("Ennemi a maintenant " + getPv() + " points de vie.");
        }
    }

    public abstract void attaquer(ActeurEnMouvement acteurCible);


}