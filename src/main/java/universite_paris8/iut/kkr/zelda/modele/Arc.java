package universite_paris8.iut.kkr.zelda.modele;

public class Arc extends Arme {
    private int degatsFeu;

    public Arc(int x, int y) {
        super("Arc du Héros", x, y, 55, 15);
        this.degatsFeu = 5;
    }
    public void appliquerPotionDeForce(PotionForce potion) {
        setPortee(getPortee() + potion.getPortee());
    }

    public int getDegatsFeu() {
        return degatsFeu;
    }
}
