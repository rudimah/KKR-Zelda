package universite_paris8.iut.kkr.zelda.modele;

public class ActeurEnMouvement extends Acteur {
    private int vitesse;
    private int ptAttaque;
    private int pointsDeVie;

    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(x, y, env);
        this.vitesse = vitesse;
        this.ptAttaque = ptAttaque;
        this.pointsDeVie = pointsDeVie;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPtAttaque() {
        return ptAttaque;
    }

    public void setPtAttaque(int ptAttaque) {
        this.ptAttaque = ptAttaque;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void decrementerPv(int nbrPv) {
        setPointsDeVie(getPointsDeVie() - nbrPv);
    }

    public void incrementerPv(int nbrPv) {
        setPointsDeVie(getPointsDeVie() + nbrPv);
    }
}
