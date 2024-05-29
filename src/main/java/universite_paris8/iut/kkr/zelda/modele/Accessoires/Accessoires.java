package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Accessoires extends ObjetEnvironnement {
    private int reductionDegats;
    private int augmentationVitesse;
    private int augmentationPortee;

    public Accessoires(String nom, int x, int y, int reductionDegats, int augmentationVitesse, int augmentationPortee) {
        super(nom, x, y);
        this.reductionDegats = reductionDegats;
        this.augmentationVitesse = augmentationVitesse;
        this.augmentationPortee = augmentationPortee;
    }

}
