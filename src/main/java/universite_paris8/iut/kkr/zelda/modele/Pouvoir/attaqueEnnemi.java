package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class attaqueEnnemi implements Pouvoir{
    Environnement environnement;
    int ptAttaque;
    public attaqueEnnemi(Environnement objetEnvironnement, int ptAttaque) {
        environnement = objetEnvironnement;
        this.ptAttaque = ptAttaque;
    }

    @Override
    public void utiliser() {
        for (ActeurEnMouvement ennemis:environnement.getLink().getEnnemisAttaquer() ){
            ennemis.setPv(ennemis.getPv()-ptAttaque);
        }
    }
}
