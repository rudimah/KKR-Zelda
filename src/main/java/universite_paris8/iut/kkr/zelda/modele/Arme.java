package universite_paris8.iut.kkr.zelda.modele;

public class Arme extends Objet {
    private int ptAttaque;

    public Arme(String nom, int ptAttaque,int x, int y){
        super(nom,x,y);
        this.ptAttaque = ptAttaque;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public int getPtAttaque() {return ptAttaque;}
}
