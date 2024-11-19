package universite_paris8.iut.kkr.zelda.modele;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import universite_paris8.iut.kkr.zelda.Controleur.Controleur;
import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.attaqueEnnemi;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.cumulPouvoirs;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.modifPtAttaque;

import java.util.ArrayList;


public class ArmesPotionsTest {
    private Environnement env;
    private ObjetEnvironnement boomerang;
    private ObjetEnvironnement sabre;
    private ObjetEnvironnement epee;
    private ArrayList<Pouvoir> listPouvoirs;
    private Ennemis ennemi;
    private int initialPv;
    private Link link;

    @BeforeEach
    public void setUp(){
        env = Environnement.getInstance();
        link = new Link(env,new DialogueController(new Controleur()));
        listPouvoirs = new ArrayList<>();
        listPouvoirs.add(new attaqueEnnemi(env,55));
        listPouvoirs.add(new attaqueEnnemi(env,15));
        epee = new ObjetEnvironnement(env,"epee",100, 100,new attaqueEnnemi(env,35),true);
        boomerang = new ObjetEnvironnement(env,"boomerang",100, 100,new attaqueEnnemi(env,25),true);
        sabre = new ObjetEnvironnement(env,"sabre", 100,100,new cumulPouvoirs(env,listPouvoirs),true);
        ennemi = new Ennemis("Bonnoctus", 100, 102, 3, env, 10000, 40);
        initialPv = ennemi.getPv();
        env.ajouterActeur(link);
        env.ajouterActeur(ennemi);
        link.ramasserItem();
        link.ramasserItem();
        link.ramasserItem();
    }
    @Test
    void testBoomerangAttaque() {
        link.utiliser(boomerang);
        link.attaquer(ennemi);
        assertEquals(initialPv - boomerang.getPouvoir().getModificateur(), ennemi.getPv(),  "Boomerang inflige des dégats à l'ennemi");
    }

    @Test
    void testSabreAttaqueAvecOrbe() {
        link.utiliser(sabre);
        link.attaquer(ennemi);
        assertEquals(initialPv - sabre.getPouvoir().getModificateur(),ennemi.getPv(),  "Sabre inflige des dégat d'orbes");
    }

    @Test
    void testPotionAcide() {
        ObjetEnvironnement potionAcide = new ObjetEnvironnement(env,"Potion Acide", 100,100,new modifPtAttaque(env,2),false);
        link.utiliser(epee);
        link.utiliser(potionAcide);
        link.attaquer(ennemi);
        assertEquals(initialPv - epee.getPouvoir().getModificateur(),ennemi.getPv(), "Potion Acide augmente les points d'attaque de l'epee de 2");
    }
}