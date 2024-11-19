package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class modifPtAttaque extends Pouvoir{

    public modifPtAttaque(Environnement environnement, int ptAttaque) {
        super(environnement, ptAttaque);
    }
    @Override
    public void utiliser() {
        Link link = getEnvironnement().getLink();
        if (link.getArmeActuel()!=null){
            link.getArmeActuel().getPouvoir().setModificateur(link.getArmeActuel().getPouvoir().getModificateur() + getModificateur());
        }
        else {
            link.setPtAttaque(getEnvironnement().getLink().getPtAttaque() + getModificateur());
        }
    }

}
