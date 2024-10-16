package universite_paris8.iut.kkr.zelda.modele.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class attaqueEnnemi implements Pouvoir{
    Environnement environnement;
    int ptAttaque;
    public attaqueEnnemi(Environnement environnement, int ptAttaque) {
        environnement = environnement;
        this.ptAttaque = ptAttaque;
    }

    @Override
    public void utiliser() {
        ActeurEnMouvement ennemi = environnement.getLink().getEnnemiAttaque();
        ennemi.setPv(ennemi.getPv()-ptAttaque);
    }
}
