package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Potion.PotionBleue;

public class Boomerang extends Arme {
    private int zoneDegats;

    public Boomerang(int x, int y) {
        super("Boomerang du Vent Marin", x, y, 80, 30);
        this.zoneDegats = 10;
    }

    public void appliquerPotionBleue(PotionBleue potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
        setPortee(getPortee() + potion.getPortee());
        setZoneDegats(getZoneDegats() + potion.getPortee());
    }
    public int getZoneDegats() {
        return zoneDegats;
    }

    public void attaquer(Ennemis ennemi) {
        super.attaquer(ennemi);
        // Inflige des dégâts à tous les ennemis dans une zone spécifique (faire une implémentation hypothétique)
        for (Ennemis e : getEnv().getEnnemisProches(getX(), getY(), zoneDegats)) {
            e.recevoirDegats(getPtAttaque());
            System.out.println("Boomerang inflige des dégâts à tous les ennemis proches dans la zone de " + zoneDegats);
        }
    }

    public void setZoneDegats(int zoneDegats) {
        this.zoneDegats = zoneDegats;
    }
}
