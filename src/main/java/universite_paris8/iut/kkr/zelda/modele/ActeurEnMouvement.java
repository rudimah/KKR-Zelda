package universite_paris8.iut.kkr.zelda.modele;

public class ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int dx, dy; // direction

    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pv) {
        super(x, y, vitesse, env, pv);
        this.vitesse = vitesse;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }


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