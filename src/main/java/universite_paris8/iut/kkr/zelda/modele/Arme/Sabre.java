package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;

public class Sabre extends Arme {
    private int degatsOrbe;

    public Sabre(int x, int y, Environnement env) {
        super("Sabre", 50,x, y, 2,env);
        this.degatsOrbe = 5;
    }

    public void utiliser(PotionAcide potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }

    public int getDegatsOrbe() {
        return degatsOrbe;
    }

    //méthode visant à implémenter les spécificités d'attaques du sabre
    public void attaquer(ActeurEnMouvement ennemi) {
        ennemi.recevoirDegats(getPtAttaque() + degatsOrbe);
        System.out.println("Sabre inflige des dégâts d'orbe supplémentaires à l'ennemi");
    }
    @Override
    public String toString() {
        return "le sabre" + super.toString();
    }
}
