package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class Boomerang extends Arme {
    private int zoneDegats;


    public Boomerang(int x, int y, Environnement env) {
        super("Boomerang du Vent Marin", 50, x, y, 30, env);
        this.zoneDegats = 10;

    }

    ////méthode visant à implémenter les spécificités d'attaques du boomerang
    public void attaquer(ActeurEnMouvement ennemi) {
        for (Ennemis e : env.listeEnnemisProcheDeLink( zoneDegats)) {
            e.recevoirDegats(getPtAttaque());
            System.out.println("Boomerang inflige des dégâts à tous les ennemis proches dans un périmètre de " + zoneDegats);
        }
    }

    @Override
    public String toString() {
        return "le boomerang"  + super.toString();
    }
}