package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class attaqueEnnemi extends Pouvoir{

    ObjetEnvironnement ancienArme = null;
    public attaqueEnnemi(Environnement environnement, int ptAttaque) {
        super(environnement, ptAttaque);
    }

    @Override
    public void utiliser() {
        Link link = getEnvironnement().getLink();
        link.setArmeActuel(link.getObjetActuel());
    }
}
