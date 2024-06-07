package universite_paris8.iut.kkr.zelda.modele.Algos;

public class Coordonnees {
    int x, y;
    Coordonnees parent;

    public Coordonnees(int x, int y, Coordonnees parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
