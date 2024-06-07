package universite_paris8.iut.kkr.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
    private ObservableList<ObjetEnvironnement> inventaire;

    public Inventaire(){
        inventaire = FXCollections.observableArrayList();
    }

    public ObservableList<ObjetEnvironnement> getInventaire() {return inventaire;}

    public ObjetEnvironnement selectionnerItem(String id){
        for (ObjetEnvironnement item : inventaire){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public void ajouterItemAInventaire(ObjetEnvironnement a){
        inventaire.add(a);
    }

    public void afficherInventaire(){
        System.out.print('[');
        for (ObjetEnvironnement item : inventaire){
            System.out.print(item.getNom() + " ," );
        }
        System.out.println(']');
    }

}
