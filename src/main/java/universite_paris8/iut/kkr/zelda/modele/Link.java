package universite_paris8.iut.kkr.zelda.modele;


import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{


    private boolean sprintAppuyer = false;
    public int tileId = 9;
    private Inventaire inventaire;


    public Link(Environnement env) {
        super(80, 50, 2, env, 40, 10);
        this.inventaire = new Inventaire();

    }


    public boolean peutsedeplacer(int x, int y){
        boolean cointHautGauche = true;
        boolean cointHautDroite = true;
        boolean cointBasDroite = true;
        boolean cointBasGauche = true;
        int xGauche, yHaut, yBas, xDroite;
        xGauche = getX();
        xDroite = getX()+29;
        yHaut = getY();
        yBas = getY()+29;

        ArrayList<Integer> obtacle = new ArrayList<Integer>();
        obtacle.add(Constantes.VOITURE_ABANDONNEE);
        obtacle.add(Constantes.ARBRES);
        tileId = 9;
        for (int obstacle: obtacle){
            if(env.getTuile(xGauche, yHaut)== obstacle){
                cointHautGauche = false;
            } else if (env.getTuile(xGauche, yHaut)== Constantes.EAU) {
                tileId = env.getTuile(xGauche, yHaut);
            }
            if(env.getTuile(xDroite, yHaut) == obstacle){
                cointHautDroite = false;
            } else if (env.getTuile(xDroite, yHaut) == Constantes.EAU) {
                tileId = env.getTuile(xDroite, yHaut);
            }
            if(env.getTuile(xGauche, yBas) == obstacle){
                cointBasGauche= false;
            }else if (env.getTuile(xGauche, yBas) == Constantes.EAU) {
                tileId = env.getTuile(xGauche, yBas);
            }
            if(env.getTuile(xDroite, yBas) == obstacle){
                cointBasDroite= false;
            }else if (env.getTuile(xDroite, yBas) == Constantes.EAU) {
                System.out.println("test"  + tileId);
                tileId = env.getTuile(xDroite, yBas);
            }
//            System.out.println("coinHG= "+cointHautGauche);
//            System.out.println("coinHD= "+cointHautDroite);
//            System.out.println("coinBG= "+cointBasGauche);
//            System.out.println("coinBD= "+cointBasDroite);
        }

        return (cointBasGauche&&cointBasDroite) && (cointHautGauche&&cointHautDroite);
    }

    public void seDeplace(int direction) {
        int nouveauX = getX(), nouveauY = getY();
        int vitesse = getVitesse();
        if (tileId == 0) { // Eau
            vitesse = 1;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
        }
        else {
            vitesse = getVitesse();
        }
        switch (direction) {
            case Constantes.Haut:
                nouveauY -= vitesse;
                break;
            case Constantes.Bas:
                nouveauY += vitesse;
                break;
            case Constantes.Droite:
                nouveauX += vitesse;
                break;
            case Constantes.Gauche:
                nouveauX -= vitesse;
                break;
            default:
                System.out.println("Direction inconnue");
        }

        if(peutsedeplacer(nouveauX, nouveauY)){
            setX(nouveauX);
            setY(nouveauY);
        }
        System.out.println(getVitesse());
        ramasserItem();
        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");

    }


    public int getTileId(){
        return tileId;
    }

    public void ramasserItem() {
        ArrayList<ObjetEnvironnement> itemsARamasser = new ArrayList<>();

        for (ObjetEnvironnement item : env.getItems()) {
            if (!item.EstRamassé() && estProcheDe(item)) {
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

    public boolean estProcheDe(ObjetEnvironnement item) {
        int distance = 15;
        return Math.abs(getX() - item.getX()) < distance && Math.abs(getY() - item.getY()) < distance;
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        if (estADistanceAttaque(acteurCible)) {
            acteurCible.decrementerPv(getPtAttaque());
        }
        System.out.println("Link attaque " + acteurCible + " ! Il reste " + acteurCible.getPv() + " pv.");
    }



}