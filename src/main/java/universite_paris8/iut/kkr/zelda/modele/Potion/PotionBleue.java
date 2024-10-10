package universite_paris8.iut.kkr.zelda.modele.Potion;


import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionBleue extends Potion {

    public PotionBleue(int x, int y, Environnement env) {
        super("Potion Bleue", x, y, 5, 0, 5, env);  // +5 à ptAttaque et +5 à la portée
    }

    @Override
    public void appliquerPotion() {
        env.getLink().setPtAttaque(env.getLink().getPtAttaque()+2);

        System.out.println("Potion Bleu utilisée : Point d'attaque augmenté de 2");

        if (env.getLink().getArme()!=null) {
            env.getLink().getArme().setPortee(env.getLink().getArme().getPortee() + 5);
        }
        else {
            System.out.println("Vous n'avez pas d'arme : pas d'amélioration de portée");
        }

    }
}