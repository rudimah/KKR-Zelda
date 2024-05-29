package universite_paris8.iut.kkr.zelda.modele;

public class Sabre extends Armes {
    private int degatsOrbe;

    public Sabre(int x, int y) {
        super("Sabre", x, y, 50, 1);
        this.degatsOrbe = 5;
    }

    public void appliquerPotionAcide() {
        setPtAttaque(getPtAttaque() + 2);
    }

    public int getDegatsOrbe() {
        return degatsOrbe;
    }
}
