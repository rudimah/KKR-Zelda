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
                ImageView foregroundImageView = new ImageView();

                // Par défaut, définir l'image de fond comme de l'herbe
                Image herbe = new Image("file:src/main/resources/image/grass.png");
                imageDeFond.setImage(herbe);

                switch (map[x][y]) {
                    case 0: // Eau
                        Image eau = new Image("file:src/main/resources/image/eau.jpg");
                        imageDeFond.setImage(eau);
                        break;
                    case 1: // Immeubles abandonnés
                        // Ajouter une image pour immeubles abandonnés si nécessaire
                        break;
                    case 2: // Arbres
                        Image arbre = new Image("file:src/main/resources/image/arbre.png");
                        foregroundImageView.setImage(arbre);
                        break;
                    case 3: // Buisson
                        Image buisson = new Image("file:src/main/resources/image/buisson.png");
                        foregroundImageView.setImage(buisson);
                        break;
                    case 4: //coffre
                        Image coffre = new Image("file:src/main/resources/image/coffre.png");
                        foregroundImageView.setImage(coffre);
                        break;
                    case 5: // Rocher
                        // Logique pour rocher
                        break;
                    case 6: // Poubelle
                        // Logique pour poubelle
                        break;
                    case 7: // Rocher en Lave
                        // Logique pour rocher en lave
                        break;
                    case 8: // Voiture abandonnée
                        // Logique pour voiture abandonnée
                        break;
                    case 10: // Lave
                        // Logique pour lave
                        break;
                    case 9:
                        // Logique pour autre élément si nécessaire
                        break;
                    default:
                        // Déjà défini comme herbe
                        break;
                }



                
                stackPane.getChildren().add(imageDeFond);
                stackPane.getChildren().add(foregroundImageView);


                this.tilepane.getChildren().add(stackPane);
            }
        }
    }
}
