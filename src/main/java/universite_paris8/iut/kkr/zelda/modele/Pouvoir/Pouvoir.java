package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public abstract class Pouvoir {
    private Environnement environnement;
    private int modificateur;

    public Pouvoir(Environnement e, int modif){
        this.environnement = e;
        this.modificateur = modif;
    }

    public int getModificateur() {
        return modificateur;
    }

    public void setModificateur(int modificateur) {
        this.modificateur = modificateur;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public abstract void utiliser();

}
