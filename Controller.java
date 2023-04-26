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
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.LocalDateTime;
import javafx.scene.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javax.swing.Spring;
import javafx.collections.ObservableList;

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
    @FXML
    private TableView<Etudiant> tableEtudiant = new TableView();
    @FXML
    private TableColumn<Etudiant, String> columnNom = new TableColumn();
    @FXML
    private TableColumn<Etudiant, String> columnPrenom = new TableColumn();
    @FXML
    private TableColumn<Etudiant, String> columnPromo = new TableColumn();
    @FXML
    private TableColumn<Etudiant, String> columnParcours = new TableColumn();
    @FXML
    private TableColumn<Etudiant, Integer> columnDDN = new TableColumn();
    
    private static ObservableList<Etudiant> listEtudiant;
    
    
    
    
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
    @FXML
     private void back(ActionEvent event) throws IOException
    {
        System.out.println("Bouton pour la modification");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Template.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
     public void getEtudiant()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            String sql = "SELECT * FROM Etudiant";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:BDD.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listEtudiant.add(new Etudiant(rs.getInt("Id_Etudiant"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Promotion"),rs.getString("Parcours")));
            }
            rs.close();
            stmt.close();
            conn.close(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }   
    
    public void Initialise(){
        columnNom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Prenom"));
        columnPromo.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Promotion"));
        columnParcours.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Parcours"));
    }
    @FXML
    public  void afficheListe(ActionEvent event) throws IOException{
        Initialise();
        getEtudiant();
        tableEtudiant.setItems(listEtudiant);
    }   
}