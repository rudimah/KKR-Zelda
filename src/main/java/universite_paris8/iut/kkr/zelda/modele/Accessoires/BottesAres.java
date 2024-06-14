package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class BottesAres extends Accessoires {
    private Link link;
    public BottesAres(int x, int y, Environnement env) {
        super("Bottes d'Arès", x, y, 0, 2, env); // Augmente la vitesse de Link * 2
    }

    @Override
    public void appliquerEffet(){
        env.getLink().setVitesse(env.getLink().getVitesse()*2);
        System.out.println("Vitesse doublé grâce au Bottes");
        int vitesseActuelle = link.getVitesse();
        this.link.setVitesse(vitesseActuelle+3);
    }

}
