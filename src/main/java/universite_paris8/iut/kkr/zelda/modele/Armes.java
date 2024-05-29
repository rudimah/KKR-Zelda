package universite_paris8.iut.kkr.zelda.modele;

public class Armes extends ObjetEnvironnement{
    private int ptAttaque;
    private int porteeArme;

    public Armes(String nom, int ptAttaque, int x, int y, int porteeArme){
        super(nom,x,y);
        this.ptAttaque = ptAttaque;
        this.porteeArme = porteeArme;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public int getPtAttaque() {return ptAttaque;}

    public void setPortee(int portee) {this.porteeArme = portee;}

    public int getPortee() {return porteeArme;}
}
