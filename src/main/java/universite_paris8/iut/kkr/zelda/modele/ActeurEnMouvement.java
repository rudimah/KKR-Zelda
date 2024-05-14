package universite_paris8.iut.kkr.zelda.modele;

public class ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int ptAttaque;
    private int dx, dy; // direction

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

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


    public void seDeplacer() {
        System.out.println("Essaye de passer de " + getX() + ", " + getY() + ") à (" + dx + ", " + dy + ")");
        int newX = getX() + dx;
        int newY = getY() + dy;
        if (env.estPositionValide(newX, newY)) {
            setX(newX);
            setY(newY);
            System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
        } else {
            System.out.println("Mouvement bloqué par un élément de l'environnement.");
        }
    }
}