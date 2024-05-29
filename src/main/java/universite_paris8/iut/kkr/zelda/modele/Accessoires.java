package universite_paris8.iut.kkr.zelda.modele;

public class Accessoires extends Objet{
<<<<<<< HEAD
    private int reductionDegats;
=======
    private int reductionDegats ;
>>>>>>> origin/feature/Inventaire
    private int augmentationVitesse;
    private int augmentationPortee;

    public Accessoires(String nom, int x, int y, int reductionDegats, int augmentationVitesse, int augmentationPortee) {
        super(nom, x, y);
        this.reductionDegats = reductionDegats;
        this.augmentationVitesse = augmentationVitesse;
        this.augmentationPortee = augmentationPortee;
    }

}
