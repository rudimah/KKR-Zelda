package universite_paris8.iut.kkr.zelda.modele;

public class ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int ptAttaque;

    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pv, int ptAttaque) {
        super(x, y, vitesse, env, pv);
        this.vitesse = vitesse;
        this.ptAttaque = ptAttaque;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getPtAttaque() {return ptAttaque;}

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

}