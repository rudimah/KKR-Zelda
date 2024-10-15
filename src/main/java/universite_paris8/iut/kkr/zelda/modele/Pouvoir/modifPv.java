package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement ;

public class modifPv implements Pouvoir{
    Environnement  environnement;
    int pv;
    public modifPv(Environnement environnement, int pv){
        this.environnement = environnement;
        this.pv = pv;
    }

    @Override
    public void utiliser() {
        environnement.getLink().setPv(environnement.getLink().getPv()+pv);
    }
}
