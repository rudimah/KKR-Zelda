package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import java.util.ArrayList;

public class cumulPouvoirs implements Pouvoir{
    ArrayList<Pouvoir> pouvoirs;
    public cumulPouvoirs(ArrayList<Pouvoir> pouvoirs) {
        this.pouvoirs = pouvoirs;
    }

    @Override
    public int modificateur() {
        return 0;
    }
    @Override
    public void utiliser() {
        for (Pouvoir pouvoir : pouvoirs) {
            pouvoir.utiliser();
        }
    }
}
