package universite_paris8.iut.kkr.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
    private ObservableList<Item> inventaire;

    public Inventaire(){
        inventaire = FXCollections.observableArrayList();
    }

    public ObservableList<Item> getInventaire() {return inventaire;}

    public Item selectionnerItem(String id){
        for (Item item : inventaire){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public void ajouterItemAInventaire(Item a){
        inventaire.add(a);
    }
}
