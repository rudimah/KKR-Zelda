package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifPtAttaque extends Pouvoir{

    public modifPtAttaque(Environnement environnement, int ptAttaque) {
        super(environnement, ptAttaque);
    }
    @Override
    public void utiliser() {
        if (getEnvironnement().getLink().getArmeActuel()!=null){
            getEnvironnement().getLink().getArmeActuel().getPouvoir().setModificateur(getModificateur());
        }
        getEnvironnement().getLink().setPtAttaque( getEnvironnement().getLink().getPtAttaque() + getModificateur());
    }

}
