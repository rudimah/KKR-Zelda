package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class attaqueEnnemi implements Pouvoir{
    Environnement environnement;
    int ptAttaque;
    ObjetEnvironnement ancienArme = null;
    public attaqueEnnemi(Environnement environnement, int ptAttaque) {
        this.environnement = environnement;
        this.ptAttaque = ptAttaque;
    }

    @Override
    public int modificateur() {
        return ptAttaque;
    }

    @Override
    public void utiliser() {
        Link link = environnement.getLink();
        link.setArmeActuel(link.getObjetActuel());
//        if (link.getArmeActuel()!=null) {
//            link.getInventaire().getInventaire().add(link.getArmeActuel());
//            link.setArmeActuel(link.getObjetActuel());
//        }
//        else{
//            link.setArmeActuel(link.getObjetActuel());
//            System.out.println("premier");
//        }
    }
}
