package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{
    private DeplacementStrategy dep;
    public int tileId = Constantes.HERBE; //renommage en constante Herbe
    private Inventaire inventaire;
    private ObjetEnvironnement objetActuel;
    private int vitesse;
    private DialogueController dialogue;
    private Ennemis ennemisAttaqués;


    //Constructeur
    public Link(Environnement env, DialogueController dialogue) {
        super(80, 50, 10, env, 150, 10);
        this.inventaire = new Inventaire();
        this.dialogue=dialogue;
    }

    //getter et setters
    public int getDirection(){return Direction;}
    public void setDirection(int d){Direction = d;}
    public Arme getArme() {
        return armeActuelle;
    }
    public Accessoires getAccessoireActuel() {
        return accessoireActuel;
    }
    public Inventaire getInventaire() {
        return inventaire;
    }


    //méthodes qui émet une action

    public void demanderDialogue() {
        if (dialogue!= null) {
            dialogue.roueDialogue();
        }
    }

    public void seDeplacer() {
        dep.deplacementDeBase();
        if (inventaire.getInventaire().size() < 4) {
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
        System.out.println("Link attaque " + acteurCible + " à mains nues ! Il lui reste " + acteurCible.getPv() + " pv ");
    }
    @Override
    public void attaquer() {
        if (objetActuel != null) {
            objetActuel.utiliser(); // Utilise l'arme actuelle pour attaquer l'ennemi
            System.out.println("Link utlise " + objetActuel.toString());
        }
        else {
//            attaquerAMainsNues(ennemi);
        }
    }


    public ObjetEnvironnement getObjetActuel() {
        return objetActuel;
    }


    public Inventaire getInventaire() {
        return inventaire;
    }


    public void utiliser(ObjetEnvironnement a){
        a.utiliser();
        if (a.isReutilisable()) inventaire.getInventaire().add(a);
    }
}