package universite_paris8.iut.kkr.zelda.modele.Potion;


import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionForce extends Potion {

    public PotionForce(int x, int y, Environnement env) {
        super("Potion de Force", x, y, 0, 0, 3, env);  // Augmente la portée de 3
    }

    @Override
    public void appliquerPotion() {
        if (env.getLink().getArme()!=null){
            env.getLink().getArme().setPortee(env.getLink().getArme().getPortee()+3);
            System.out.println("Potion de Force utiliser : Point de portée augmenté de 3");
        }
        else {
            System.out.println("Vous n'avez pas d'arme : Potion gaspiller");
        }
    }
}