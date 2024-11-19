package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

import java.util.ArrayList;

public class cumulPouvoirs extends Pouvoir{
    ArrayList<Pouvoir> pouvoirs;
    public cumulPouvoirs(Environnement env, ArrayList<Pouvoir> pouvoirs) {
        super(env, 0);
        this.pouvoirs = pouvoirs;

    }

    public int getModificateur(){
        int cumulModificateur = 0;
        for (Pouvoir pouvoir : pouvoirs) {
            cumulModificateur += pouvoir.getModificateur();
        }
        return cumulModificateur;
    }



    @Override
    public void utiliser() {
        for (Pouvoir pouvoir : pouvoirs) {
            pouvoir.utiliser();
        }
    }
}
