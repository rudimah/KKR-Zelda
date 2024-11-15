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
    private ObjetEnvironnement armeActuel;
    private DialogueController dialogue;
    private Ennemis ennemisAttaqués;
    private DeplacementStrategy dep;
    public Link(Environnement env, DialogueController dialogue) {
        super("Link", 80, 10, 10, env, 150, 10);
        this.inventaire = new Inventaire();
        this.dialogue = dialogue;
        this.dep = new DeplacementLinkStrategy(this);//ininitialiser la stratégie ici
    }

    public int getVitesse(){
        return super.getVitesse();
    }

    public DeplacementStrategy getDep() {
        return dep;
    }
    public int getDirection(){return Direction;}
    public void setDirection(int d){Direction = d;}
    public ObjetEnvironnement getArmeActuel() {
        return armeActuel;
    }
    public void setArmeActuel(ObjetEnvironnement armeActuel) {
        this.armeActuel = armeActuel;
    }

    public ObjetEnvironnement getObjetActuel() {
        return objetActuel;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }
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

    @Override
    public void attaquer(ActeurEnMouvement acteurEnMouvement) {
        if (armeActuel != null) {
            acteurEnMouvement.recevoirDegats(armeActuel.getPouvoir().modificateur());
            System.out.println("Link attaque " + acteurEnMouvement + " avec " + armeActuel.getNom() + "\n Il lui reste " + acteurEnMouvement.getPv() + " pv ");
        }
        else {
            acteurEnMouvement.recevoirDegats(getPtAttaque());
            System.out.println("Link attaque " + acteurEnMouvement + " à mains nues ! Il lui reste " + acteurEnMouvement.getPv() + " pv ");
        }
    }

    public void utiliser(ObjetEnvironnement a){
        objetActuel = a;
        System.out.println(a.getNom() + " est utilisé");
        if (armeActuel!= null && a.isReutilisable()){
            getInventaire().getInventaire().add(armeActuel);
        }
        a.utiliser();
        getInventaire().getInventaire().remove(a);
    }
}