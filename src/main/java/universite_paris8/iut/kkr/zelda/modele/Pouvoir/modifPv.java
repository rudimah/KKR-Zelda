package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement ;

public class modifPv extends Pouvoir{

    int pv;
    public modifPv(Environnement environnement, int pv){
        super(environnement, pv);
    }

    @Override
    public void utiliser() {
        getEnvironnement().getLink().setPv(getEnvironnement().getLink().getPv()+pv);
    }


}
