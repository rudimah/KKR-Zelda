package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionBleue;

public class Boomerang extends Arme {
    private int zoneDegats;
    private Environnement environnement;

    public Boomerang(int x, int y, Environnement env) {
        super("Boomerang du Vent Marin", 50, x, y, 30);
        this.zoneDegats = 10;
        this.environnement = env;
    }

    public void attaquer(Ennemis ennemi) {
        super.attaquerAvecArme(ennemi);
        for (Ennemis e : environnement.getEnnemisProches(getX(), getY(), zoneDegats)) {
            e.recevoirDegats(getPtAttaque());
            System.out.println("Boomerang inflige des dégâts à tous les ennemis proches dans la zone de " + zoneDegats);
        }
    }

    @Override
    public String toString() {
        return "le boomerang"  + super.toString();
    }
}