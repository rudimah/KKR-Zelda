package universite_paris8.iut.kkr.zelda.Vue;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class TerrainVue {
    Environnement env;

    private TilePane tilepane;

    public TerrainVue(Environnement env, TilePane tilepane) {
        this.tilepane = tilepane;
        this.env = env;
    }



    public void afficherMap() {
        int[][] map = this.env.getTableauMap();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                StackPane stackPane = new StackPane();

                ImageView imageDeFond = new ImageView();
                ImageView images = new ImageView();

                // Par défaut, définir l'image de fond comme de l'herbe
                Image herbe = new Image("file:src/main/resources/image/herbe.png");
                imageDeFond.setImage(herbe);

                switch (map[x][y]) {
                    case 0: // Eau
                        Image eau = new Image("file:src/main/resources/image/eau.jpg");
                        imageDeFond.setImage(eau);
                        break;
                    case 1: // Immeubles abandonnés
                        Image maison = new Image("file:src/main/resources/image/maison.png");
                        images.setImage(maison);

                        break;
                    case 2: // Arbres
                        Image arbre = new Image("file:src/main/resources/image/arbre.png");
                        images.setImage(arbre);

                        break;
                    case 3: // Buisson
                        Image buisson = new Image("file:src/main/resources/image/buisson.png");
                        images.setImage(buisson);
                        break;
                    case 4: //coffre
                        Image coffre = new Image("file:src/main/resources/image/coffre.png");
                        images.setImage(coffre);
                        break;
                    case 5: // Rocher
                        Image rocher = new Image("file:src/main/resources/image/rocher.png");
                        images.setImage(rocher);
                        break;
                    case 6: // Poubelle
                        Image poubelle = new Image("file:src/main/resources/image/poubelle.png");
                        images.setImage(poubelle);
                        break;
                    case 7: // Rocher en Lave
                        Image rocher_lave = new Image("file:src/main/resources/image/rocher_lave.png");
                        images.setImage(rocher_lave);
                        break;
                    case 8: // Voiture abandonnée
                        Image voiture = new Image("file:src/main/resources/image/voiture.png");
                        images.setImage(voiture);
                        break;

                    case 10: // Lave
                        Image lave = new Image("file:src/main/resources/image/lave.png");
                        images.setImage(lave);
                        break;
                    case 11: // Pavé pour route
                        Image pavé = new Image("file:src/main/resources/image/pavé.png");
                        images.setImage(pavé);
                        break;
                    case 12: // Gros rocher
                        Image gros_rocher = new Image("file:src/main/resources/image/gros-rocher.png");
                        images.setImage(gros_rocher);
                        break;
                    case 13: // Pont
                        Image Pont = new Image("file:src/main/resources/image/pont.png");
                        Image lave2 = new Image("file:src/main/resources/image/lave.png");
                        imageDeFond.setImage(lave2);
                        images.setImage(Pont);
                        images.setRotate(90);
                    default:
                        // Déjà défini comme herbe
                        break;
                }

                stackPane.getChildren().add(imageDeFond);
                stackPane.getChildren().add(images);


                this.tilepane.getChildren().add(stackPane);
            }
        }
    }

}
