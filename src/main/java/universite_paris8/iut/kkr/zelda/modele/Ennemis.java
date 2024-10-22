package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;

import java.util.List;

public  class Ennemis extends ActeurEnMouvement {
    private int toursFige = 0;
    private BFS bfs;
    private String nom;
    public Ennemis(String nom, int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(nom, x, y, vitesse, env, pointsDeVie, ptAttaque);
        this.nom = nom;
        this.bfs = new BFS(env);
        setEnnemiAttaque(env.getLink());
    }
    //Méthode avec lequel les ennemis se déplace
    public void seDeplacer() {
        Acteur link = env.getLink(); //cible link


        if (link != null) {
            int linkX = link.getX();
            int linkY = link.getY(); //recuperer position link

            List<int[]> chemin = bfs.cheminBFS(getX(), getY(), linkX, linkY);
            if (chemin != null && !chemin.isEmpty()) { //si chemin n'est pas vide  null si le chemin na pas ete calculer
                int[] prochaineEtape = chemin.get(1); //prochain position ennnemi car get(0) la ou est l'ennnemi

                int dx = prochaineEtape[0] - getX();  //prochaine position  positionCible- position actuel
                int dy = prochaineEtape[1] - getY();
                double distance = Math.sqrt(dx * dx + dy * dy); //distance que l'ennnemi parcours en verticale et horizontale

                // Normaliser le vecteur de déplacement permet de deplacer l'ennemi a une vitesse constante
                double nx = dx/distance;
                double ny = dy/distance;

                // Calculer la nouvelle position avec la vitesse de l'ennemi
                int nouveauX = (int)(getX()+nx*getVitesse());
                int nouveauY = (int)(getY()+ny*getVitesse());

                // Vérifier si la nouvelle position est accessible
                if (bfs.estAccessible(nouveauX, nouveauY)) {
                    setX(nouveauX);
                    setY(nouveauY);
//                    System.out.println("Ennemi se déplace" + getX() +  getY());
                } else {
                    //si position non accesible il va a droite ou a gauche pour trouver un chemin accesible
                    int[] gauche = {-1, 0}; // Déplacement d'une tuile à gauche
                    int[] droite = {1, 0};  // Déplacement d'une tuile à droite
                    int nouveauXGauche = getX() + gauche[0];
                    int nouveauXDroite = getX() + droite[0];
                    int y = getY(); //maintient la position en Y car il se deplace que en X

                    if (bfs.estAccessible(nouveauXGauche, y)) { //verifie les positions
                        setX(nouveauXGauche);
                    } else if (bfs.estAccessible(nouveauXDroite, y)) {
                        setX(nouveauXDroite);
                    }
                }
            }
        } else {
            System.out.println("Aucun chemin ");

        }
    }

    public void figer(int nbTours) {
        toursFige = nbTours;
    }

    public boolean estFige() {
        return toursFige > 0;
    }

    public void decrementerToursFige() {
        if (toursFige > 0) {
            toursFige--;
        }
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}