package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

import java.util.ArrayList;

public class ObservateurInventaire implements ListChangeListener<ObjetEnvironnement> {
    private ArrayList<ImageView> cases;

    //observe les ajout et les supressions des elements que link peut avoir dans l'inventaire
    public ObservateurInventaire(ArrayList<ImageView> cases){
        this.cases = cases;
    }

    //images des items dans les cases de l'inventaire
    private Image getImage(String nom){
        switch (nom){
            case "Potion Acide":
                return new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
            case "Potion Bleue":
                return new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
            case "Potion de Feu":
                return new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
            case "Potion de Force":
                return new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
            case "Sabre":
                return new Image("file:src/main/resources/image/Potions & Armes/sabre.png");
            case "Épée de Guerrier":
                return new Image("file:src/main/resources/image/Potions & Armes/epees.png");
            case "Arc du Héros":
                return new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
            case "Flûte de Calliopé":
                return new Image("file:src/main/resources/image/Potions & Armes/flute.png");
            case "Boomerang du Vent Marin":
                return new Image("file:src/main/resources/image/Potions & Armes/boomerang.png");
            case "Fleche":
                return new Image("file:src/main/resources/image/Potions & Armes/fleche.png");
            case "Bottes d'Arès":
                return new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
            case "Bouclier":
                return new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");

        }
        return null;
    }
    @Override
    public void onChanged(Change<? extends ObjetEnvironnement> change) {
        for (ImageView imageView:cases) {
            imageView.setImage(null);
        }

        for (int i = 0; i <change.getList().size(); i++){
            cases.get(i).setImage(getImage(change.getList().get(i).getNom()));
        }
    }
}