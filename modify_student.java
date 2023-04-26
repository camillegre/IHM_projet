import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Tortank
 * @version 22/03/2023
 */
public class modify_student extends Application
{
 
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) throws Exception
    {
        // Building the FXML hierarchy
        Parent root = FXMLLoader.load(getClass().getResource("modify.fxml"));
        
        // JavaFX must have a Scene (window content) inside a Stage (window)       
        Scene scene = new Scene (root);
        
        stage.setTitle("Etudiant Master IDLS");
        //stage.getIcons().add(new Image("file:ressources/img/world-map.png"));

        stage.setScene(scene);
        // Show the Stage (window)
        stage.show();

    }

}