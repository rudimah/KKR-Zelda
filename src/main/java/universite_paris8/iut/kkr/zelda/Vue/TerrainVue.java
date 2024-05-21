package universite_paris8.iut.kkr.zelda.Vue;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class TerrainVue  {
    Environnement env;

    private TilePane tilepane;

    public TerrainVue(Environnement env, TilePane tilepane){
        this.tilepane = tilepane;this.env = env;
    }

    public void afficherMap(){

        int[][] map = this.env.getTableauMap();
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y<map[x].length; y++){
                ImageView imageView = new ImageView();
                switch (map[x][y]){
                    case 9:
                        Image image = new Image("file:src/main/resources/image/grass.png");
                        imageView.setImage(image);
                        break;
                    case 1:
                        Image image1 = new Image("file:src/main/resources/image/eau.jpg");
                        imageView.setImage(image1);
                }
            this.tilepane.getChildren().add(imageView);
            }
        }
    }

}
