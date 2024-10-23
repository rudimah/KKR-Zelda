package universite_paris8.iut.kkr.zelda.modele.Deplacement;

public interface DeplacementStrategy {
    public void deplacementDeBase();
    public boolean verificationObstacles(int x, int y);
}
