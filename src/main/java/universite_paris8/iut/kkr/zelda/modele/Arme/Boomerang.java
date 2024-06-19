package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class Boomerang extends Arme {
    private int zoneDegats;


    public Boomerang(int x, int y, Environnement env) {
        super("Boomerang du Vent Marin", 50, x, y, 30, env);
        this.zoneDegats = 10;

    }

    public void attaquer(Ennemis ennemi) {
        super.attaquerAvecArme(ennemi);
        for (Ennemis e : env.getEnnemisProches(getX(), getY(), zoneDegats)) {
            e.recevoirDegats(getPtAttaque());
            System.out.println("Boomerang inflige des dégâts à tous les ennemis proches dans la zone de " + zoneDegats);
        }
    }

    @Override
    public String toString() {
        return "le boomerang"  + super.toString();
    }
}