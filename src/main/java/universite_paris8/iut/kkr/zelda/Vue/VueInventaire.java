//package universite_paris8.iut.kkr.zelda.Vue;
//import javafx.collections.ListChangeListener;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import universite_paris8.iut.kkr.zelda.Controleur.Observateur;
//import universite_paris8.iut.kkr.zelda.modele.Arme.Arme;
//import universite_paris8.iut.kkr.zelda.modele.Inventaire;
//import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;
//
//public class VueInventaire {
//    private GridPane inventairePane;
//    private GridPane armesPane;
//    private Inventaire inventaire;
//
//    private Observateur obs;
//
//    public VueInventaire(Pane parent, Inventaire inventaire) {
//        this.inventaire = inventaire;
//        inventairePane = new GridPane();
//        armesPane = new GridPane();
//
//
//        inventairePane.setId("inventairePane");
//        armesPane.setId("armesPane");
//
//
//        parent.getChildren().add(inventairePane);
//        parent.getChildren().add(armesPane);
//
//
//        armesPane.setLayoutX(50);
//        armesPane.setLayoutY(50);
//        inventairePane.setLayoutX(200);
//        inventairePane.setLayoutY(50);
//
//
//        inventaire.getInventaire().addListener((ListChangeListener<ObjetEnvironnement>) change -> {
//            while (change.next()) {
//                if (change.wasAdded()) {
//                    for (ObjetEnvironnement item : change.getAddedSubList()) {
//                        ajouterItem(item);
//                    }
//                }
//                if (change.wasRemoved()) {
//                    for (ObjetEnvironnement item : change.getRemoved()) {
//                        retirerItem(item);
//                    }
//                }
//            }
//        });
//    }

//    private void ajouterItem(ObjetEnvironnement item) {
//        ImageView imageView = new ImageView(obs.recupererSprite());
//        if (item instanceof Arme) {
//            armesPane.add(imageView, armesPane.getChildren().size(), 0);
//        } else {
//            inventairePane.add(imageView, inventairePane.getChildren().size() % 5, inventairePane.getChildren().size() / 5);
//        }
//    }

//    private void retirerItem(ObjetEnvironnement item) {
//
//    }
//}
