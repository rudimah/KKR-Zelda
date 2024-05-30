package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
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
        super.attaquer(ennemi); // Appelle la méthode attaquer de la superclasse Arme
        for (Ennemis e : getE().getEnnemisProches(getX(), getY(), zoneDegats)) { // Utilise la méthode getEnv() de Arme, qui doit être implémentée pour retourner l'environnement
            e.recevoirDegats(getPtAttaque());
            System.out.println("Boomerang inflige des dégâts à tous les ennemis proches dans la zone de " + zoneDegats);
        }
    }

    @Override
    public Environnement getE() {
        return super.getE();
    }

    public void setZoneDegats(int zoneDegats) {
        this.zoneDegats = zoneDegats;
    }
}
