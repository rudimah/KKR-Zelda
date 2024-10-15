package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifPtAttaque implements Pouvoir{
    Environnement objet;
    int ptAttaque;
    public modifPtAttaque(Environnement environnement, int ptAttaque) {
        objet = environnement;
        this.ptAttaque = ptAttaque;
    }
    @Override
    public void utiliser() {
        objet.getLink().setPtAttaque( objet.getLink().getPtAttaque() + ptAttaque);
    }
}
