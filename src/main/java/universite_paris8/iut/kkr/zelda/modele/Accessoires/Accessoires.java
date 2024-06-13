package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.*;

public abstract class Accessoires extends ObjetEnvironnement {
    private int reductionDegats;
    private int portee;

    protected Environnement env;


    public Accessoires(String nom, int x, int y, int reductionDegats,int augmentationPortee,Environnement env) {
        super(nom, x, y);
        this.reductionDegats = reductionDegats;
        this.portee = augmentationPortee;
        this.env = env;
    }

    public int getPortee() {return portee;}

    public abstract void appliquerEffet();

    public Acteur getLink() {return env.getLink();}
}
