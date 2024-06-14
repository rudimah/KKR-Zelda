package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.*;

public abstract class Accessoires extends ObjetEnvironnement {
    private int reductionDegats;
    private int augmentationVitesse;
    private int portee;

    protected Environnement env;


    public Accessoires(String nom, int x, int y, int reductionDegats, int augmentationVitesse, int augmentationPortee, Environnement env) {
        super(nom, x, y);
        this.reductionDegats = reductionDegats;
        this.augmentationVitesse = augmentationVitesse;
        this.portee = augmentationPortee;
        this.env = env;
    }

    public int getPortee() {return portee;} //Inutile pour l'instant

    public abstract void appliquerEffet();


}