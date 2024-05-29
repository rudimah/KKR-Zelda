package universite_paris8.iut.kkr.zelda.modele;

public class Epee extends Arme {
    public Epee(int x, int y) {
        super("Épée de Guerrier", x, y, 15, 0);
    }

    public void appliquerPotionFeu(PotionFeu potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
}
