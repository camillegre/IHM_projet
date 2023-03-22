
/**
 * Write a description of class FirstAttempt here.
 *
 * @author Group
 * @version 22/03/2023
 */
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.Scene;

public class Main extends Application {
    
    // Point d'entrée du programme
    public static void main(String[] args) {
        launch(); // Appel du point d'entrée de l'application JavaFx (voir ci-dessous)
    }
    
    // Point d'entrée de l'application JavaFX
    @Override
    public void start(Stage primaryStage) {

        // Définition du titre de la fenêtre de l'application
        primaryStage.setTitle("Titre de la fenêtre");
        
        // Appel d'une méthode permettant une fermeture propre de l'application
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        
        // Création de la scène (avec des dimensions correspondant à une résolution HD), composé uniquement d'une étiquette affichant du texte
        primaryStage.setScene(new Scene(new Label("Hello wold !"), 1280, 720));
        
        // Affichage de la fenêtre
        primaryStage.show();
    }
}
