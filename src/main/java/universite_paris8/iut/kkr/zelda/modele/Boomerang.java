package universite_paris8.iut.kkr.zelda.modele;

public class Boomerang extends Armes {
    private int zoneDegats;

    public Boomerang(int x, int y) {
        super("Boomerang du Vent Marin", x, y, 80, 30);
        this.zoneDegats = 10;
    }

    public void appliquerPotionBleue() {
        setPtAttaque(getPtAttaque() + 5);
        setPortee(getPortee() + 5);
        setZoneDegats(getZoneDegats() + 5);
    }

    public int getZoneDegats() {
        return zoneDegats;
    }

    public void setZoneDegats(int zoneDegats) {
        this.zoneDegats = zoneDegats;
    }
}
