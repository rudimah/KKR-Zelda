package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Deplacement.DeplacementLinkStrategy;
import universite_paris8.iut.kkr.zelda.modele.Deplacement.DeplacementStrategy;
import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    public int tileId = Constantes.HERBE;
    private Inventaire inventaire;
    private int Direction ;
    private ObjetEnvironnement objetActuel;
    private int vitesse;
    private DialogueController dialogue;
    private Ennemis ennemisAttaqués;
    private DeplacementStrategy dep;
    public Link(Environnement env, DialogueController dialogue) {
        super("Link", 80, 50, 10, env, 150, 10);
        this.inventaire = new Inventaire();
        this.dialogue = dialogue;
        this.dep = new DeplacementLinkStrategy(this);//ininitialiser la stratégie ici
    }



    public DeplacementStrategy getDep() {
        return dep;
    }
    public int getDirection(){return Direction;}
    public void setDirection(int d){Direction = d;}

    public ObjetEnvironnement getObjetActuel() {
        return objetActuel;
    }


    public Inventaire getInventaire() {
        return inventaire;
    }


    //-----------------------------

    public void demanderDialogue() {
        if (dialogue!= null) {
            dialogue.roueDialogue();
        }
    }
    public void seDeplacer() {
        dep.deplacementDeBase();
        if(inventaire.getInventaire().size()<4){
            ramasserItem();
        }
    }

    public void ramasserItem() {
        ArrayList<ObjetEnvironnement> itemsARamasser = new ArrayList<>();
        for (ObjetEnvironnement item : env.getItems()) {
            if (!item.EstRamassé() && procheDe(item.getX(), item.getY(), 15) ) {
                itemsARamasser.add(item);
            }
        }
        for (ObjetEnvironnement item : itemsARamasser) {
            inventaire.ajouterItemAInventaire(item);
            item.setEstRamassé(true);
            env.retirerItem(item);
            System.out.println("Item ramassé : " + item.getNom());
            inventaire.afficherInventaire();
        }
    }


    public void attaquerAMainsNues(ActeurEnMouvement acteurCible) {
        acteurCible.recevoirDegats(getPtAttaque());
        System.out.println("Link attaque " + acteurCible + " à mains nu !!! Il lui reste " + acteurCible.getPv() + " pv ");
    }
    @Override
    public void attaquer(ActeurEnMouvement acteurEnMouvement) {
        if (objetActuel != null) {
            objetActuel.utiliser(); // Utilise l'arme actuelle pour attaquer l'ennemi
            System.out.println("Link utlise " + objetActuel.toString());
        }
        else {
//            attaquerAMainsNues(ennemi);
        }
    }




    public void utiliser(ObjetEnvironnement a){
        a.utiliser();
        if (a.isReutilisable()) inventaire.getInventaire().add(a);
    }
}