module universite_paris8.iut.hrahman.KKRZelda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens universite_paris8.iut.kkr.zelda to javafx.fxml;
    exports universite_paris8.iut.kkr.zelda;
    exports universite_paris8.iut.kkr.zelda.Controleur;
    opens universite_paris8.iut.kkr.zelda.Controleur to javafx.fxml;
    exports universite_paris8.iut.kkr.zelda.modele.Pouvoir;
    opens universite_paris8.iut.kkr.zelda.modele.Pouvoir to javafx.fxml;
}