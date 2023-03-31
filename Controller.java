import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import java.io.ObjectInputStream;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.IOException;
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
    private void addClick(ActionEvent event) throws IOException
    {
        System.out.println("Bouton pour l'ajout");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_student.fxml"));
        Parent root = loader.load();
    
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void listClick(ActionEvent event) throws IOException
    {
        System.out.println("Bouton pour l'affichage des étudiants");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("list_student.fxml"));
        Parent root = loader.load();
    
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void modifyClick(ActionEvent event) throws IOException
    {
        System.out.println("Bouton pour la modification");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modify.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}