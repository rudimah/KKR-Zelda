package universite_paris8.iut.kkr.zelda.modele.Pouvoir;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class modifPortee implements Pouvoir{
    Environnement environnement;
    int portee;
    public modifPortee(Environnement env, int portee) {
        environnement = env;
        this.portee = portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }
    public int getPortee() {
        return portee;
    }

    @Override
    public void utiliser() {
        setPortee(getPortee()+portee);
    }
}
