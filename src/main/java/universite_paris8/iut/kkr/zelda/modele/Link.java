package universite_paris8.iut.kkr.zelda.modele;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Link extends ActeurEnMouvement{


    private Pane panneauDeJeu;

    public Link( Environnement env, Pane pj) {
        super(50, 50, 5, env, 40, 20);
        this.panneauDeJeu = pj;
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);
    }

    private void gererTouch(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse()*2);
        }
        System.out.println("Touche pressé " + event.getCode());
        seDeplacer(event.getCode());
        event.consume();
    }
    private void handleKeyRelease(KeyEvent event) {
        // Reset the direction when shift is released
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse()/2);
            System.out.println("MAJ relâchée, vitesse normalisée.");
        }
    }

    public void seDeplacer(KeyCode key) {

        int newX = getX(), newY = getY();


        switch (key) {
            case Z:
                newY = getY()-getVitesse();
                break;
            case S:
                newY = getY()+getVitesse();
                break;
            case D:
                newX = (getX()+getVitesse());
                break;
            case Q:
                newX = (getX()-getVitesse());
                break;

        }
        System.out.println("Essaye de passer de " + getX() + ", " + getY() );

        if (env.estPositionValide(newX, newY)) {
            setX(newX);
            setY(newY);
            System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
        } else {
            System.out.println("Mouvement bloqué par un élément de l'environnement.");
        }


    }
}
