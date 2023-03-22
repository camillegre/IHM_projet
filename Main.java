
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
    
    // Point d'entr�e du programme
    public static void main(String[] args) {
        launch(); // Appel du point d'entr�e de l'application JavaFx (voir ci-dessous)
    }
    
    // Point d'entr�e de l'application JavaFX
    @Override
    public void start(Stage primaryStage) {

        // D�finition du titre de la fen�tre de l'application
        primaryStage.setTitle("Titre de la fen�tre");
        
        // Appel d'une m�thode permettant une fermeture propre de l'application
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        
        // Cr�ation de la sc�ne (avec des dimensions correspondant � une r�solution HD), compos� uniquement d'une �tiquette affichant du texte
        primaryStage.setScene(new Scene(new Label("Hello wold !"), 1280, 720));
        
        // Affichage de la fen�tre
        primaryStage.show();
    }
}
