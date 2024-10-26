package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class attaqueEnnemi implements Pouvoir{
    Environnement environnement;
    int ptAttaque;
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
        if(environnement.getLink().getArmeActuel()!= null){
            if (environnement.getLink().getArmeActuel().isReutilisable()){
                environnement.getLink().getInventaire().getInventaire().add(environnement.getLink().getArmeActuel());
            }
        }
        environnement.getLink().setArmeActuel(environnement.getLink().getArmeActuel());

    }
}
