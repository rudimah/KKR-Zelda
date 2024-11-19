package universite_paris8.iut.kkr.zelda.modele.Arme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import universite_paris8.iut.kkr.zelda.modele.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.Pouvoir;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.attaqueEnnemi;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.cumulPouvoirs;
import universite_paris8.iut.kkr.zelda.modele.Pouvoir.modifPtAttaque;

import java.util.ArrayList;


public class EnnemisTest {
    private Environnement env;
    private ObjetEnvironnement boomerang;
    private ObjetEnvironnement sabre;
    private ArrayList<Pouvoir> listPouvoirs;
    private Ennemis ennemi;
    private int initialPv;
    private Link link;

    @BeforeEach
    public void setUp(){
        env = new Environnement(800, 800);
        listPouvoirs = new ArrayList<>();
        listPouvoirs.add(new attaqueEnnemi(env,55));
        listPouvoirs.add(new attaqueEnnemi(env,15));
        boomerang = new ObjetEnvironnement(env,"boomerang",100, 100,new attaqueEnnemi(env,25),true);
        sabre = new ObjetEnvironnement(env,"sabre", 100,100,new cumulPouvoirs(env,listPouvoirs),true);
        ennemi = new Ennemis("Bonnoctus", 100, 102, 3, env, 10000, 40);
        initialPv = ennemi.getPv();
    }

    @Test
    void testBoomerangAttaque() {
        boomerang.utiliser();
        assertTrue(ennemi.getPv() < initialPv, "Boomerang should damage enemies");
    }

    @Test
    void testSabreAttaqueAvecOrbe() {
        sabre.utiliser();
        assertTrue(ennemi.getPv() < initialPv - 70, "Sabre inflige des dégat d'orbes");
    }

    @Test
    void testPotionAcide() {
        int attaqueInitiale = 70;
        ObjetEnvironnement potionAcide = new ObjetEnvironnement(env,"Potion Acide", 100,100,new modifPtAttaque(env,5),false);
        potionAcide.utiliser();
        assertEquals(attaqueInitiale + potionAcide.getPouvoir().getModificateur(), sabre.getPouvoir().getModificateur(), "Potion Acide augmente les points d'attaque du sabre de 2");
    }
}