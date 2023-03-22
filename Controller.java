
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Write a description of JavaFX class StepTwoController here.
 *
 * @author Patrick GIRARD
 * @version 22/03/2020
 */
public class Controller
{
    // We keep track of the count, and label displaying the count:
    
    @FXML
    private Label myLabel;

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    @FXML
    private void addClick(ActionEvent event)
    {
        System.out.println("Bouton pour l'ajout");
    }
    @FXML
    private void listClick(ActionEvent event)
    {
        System.out.println("Bouton pour l'affichage des étudiants");
    }
    @FXML
    private void modifyClick(ActionEvent event)
    {
        System.out.println("Bouton pour la modification");
    }
}