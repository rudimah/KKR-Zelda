package universite_paris8.iut.kkr.zelda.modele;

public class ArmeADistance extends Arme{
    private int portee;
    public ArmeADistance(String nom, int ptAttaque, int x, int y, int portee) {
        super(nom, ptAttaque, x, y);
        this.portee = portee;
    }

    public void setPortee(int portee) {this.portee = portee;}

    public int getPortee() {return portee;}
}
