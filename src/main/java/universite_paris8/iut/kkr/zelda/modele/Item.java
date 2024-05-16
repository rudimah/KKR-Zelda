package universite_paris8.iut.kkr.zelda.modele;

public class Item extends Objet {
    private boolean estRamassé;

    public Item(String nom, int x, int y) {
        super(nom, x, y);
        this.estRamassé = false;
    }

    public boolean EstRamassé() {return estRamassé;}

    public void setEstRamassé(boolean estRamassé) {this.estRamassé = estRamassé;}
}
