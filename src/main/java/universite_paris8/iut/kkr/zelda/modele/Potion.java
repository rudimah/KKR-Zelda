package universite_paris8.iut.kkr.zelda.modele;

public class Potion extends Item{
    private int ptAttaque;
    private int pv;
    private int portee;
    public Potion(String nom, int x, int y, int ptAttaque, int pv, int portee) {
        super(nom, x, y);
        this.ptAttaque = ptAttaque;
        this.pv = pv;
        this.portee = portee;
    }

    public int getPtAttaque() {return ptAttaque;}

    public int getPv() {return pv;}

    public int getPortee() {return portee;}

}
