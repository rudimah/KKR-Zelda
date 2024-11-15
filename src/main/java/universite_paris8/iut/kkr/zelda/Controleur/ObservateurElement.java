package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;


public class ObservateurElement implements ListChangeListener<ObjetEnvironnement> {
    private final Pane panneauJeu;


    public ObservateurElement(Pane panneauJeu) {
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends ObjetEnvironnement> change) {

        while(change.next()){

            if (change.wasAdded()){
                for (ObjetEnvironnement a: change.getAddedSubList()) {
                    creerItem(a);
                }
            } else if (change.wasRemoved()) {
                for (ObjetEnvironnement a : change.getRemoved()){
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }

    private void creerItem(ObjetEnvironnement a) {
        Image image = null;
        ImageView element = new ImageView();
        element.setFitWidth(30);
        element.setFitHeight(30);

        try {
            switch (a.getNom()) {
                case "Potion Acide":
                    image = new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
                    break;
                case "Potion Bleue":
                    image = new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
                    break;
                case "Potion Feu":
                    image = new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
                    break;
                case "Potion Force":
                    image = new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
                    break;
                case "Sabre":
                    image = new Image("file:src/main/resources/image/Potions & Armes/sabre.png");
                    break;
                case "Epee":
                    image = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
                    break;
                case "Arc":
                    image = new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
                    break;
                case "Boomerang":
                    image = new Image("file:src/main/resources/image/Potions & Armes/boomerang.png");
                    break;
                case "Bottes d'Arès":
                    image = new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
                    break;
                case "Bouclier":
                    image = new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");
                    break;
                default:
                    System.out.println(" Objet de l'environnement non reconnu: " + a.getNom());
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement de l'image pour l'objet: " + a.getNom());

        }

        element.setImage(image);
        element.setId(a.getId());
        element.translateXProperty().bind(a.xProperty());
        element.translateYProperty().bind(a.yProperty());
        panneauJeu.getChildren().add(element);
    }

//    private void creerItem(ObjetEnvironnement a) {
//        Image image = null;
//        ImageView element = new ImageView();
//        element.setFitWidth(30);
//        element.setFitHeight(30);
//
//        if (a.getNom() == "Potion Acide"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
//        }
//        else if (a.getNom() == "Potion Bleue"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
//        }
//        else if (a.getNom() == "Potion Feu"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
//        }
//        else if (a.getNom() == "Potion Force"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
//        }
//        else if (a.getNom() == "Sabre"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/sabre.png");
//        }
//        else if (a.getNom() == "Epee"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
//
//        }
//        else if (a.getNom() == "Arc"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
//        }
//        else if (a.getNom() == "Boomerang"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/boomerang.png");
//        }
//        else if (a.getNom() == "Bottes d'Arès"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
//        }
//        else if (a.getNom() == "Bouclier"){
//            image  = new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");
//        }
//        element.setImage(image);
//        element.setId(a.getId());
//        element.translateXProperty().bind(a.xProperty());
//        element.translateYProperty().bind(a.yProperty());
//        panneauJeu.getChildren().add(element);
//    }
}