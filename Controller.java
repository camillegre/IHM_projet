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
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.beans.property.*;
import java.sql.*;
import javafx.collections.*;
import java.io.IOException;
import javafx.scene.input.*;
import javafx.scene.control.TableView;

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
    private TableColumn<Etudiant, String> columnID = new TableColumn();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_etudiant.fxml"));
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
        displayTable();
        stage.show();
        
    }
    @FXML
    private void refresh() throws SQLException{
        displayTable();
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
     private void displayTable() {
        
        try{
            listEtudiant=FXCollections.observableArrayList(getEtudiant());
            columnID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
            columnNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
            columnPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
            columnParcours.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getParcours()));
            columnPromo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPromo()));
            tableEtudiant.setItems(listEtudiant);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public ArrayList<Etudiant> getEtudiant() throws SQLException
    {
        ArrayList<Etudiant> listeEtudiant = new ArrayList();
    
        try {
            Class.forName("org.sqlite.JDBC");
            String sql = "SELECT * FROM Etudiant";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:BDD.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Id_Etudiant");
                String Nom = rs.getString("Nom");
                String Prenom = rs.getString("Prenom");
                String Promo = rs.getString("Promotion");
                String Parcours = rs.getString("Parcours");
                System.out.println(Nom+Prenom);
                Etudiant etu = new Etudiant(id,Nom,Prenom,Promo,Parcours);
                listeEtudiant.add(etu);
            }
            rs.close();
            stmt.close();
            conn.close(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return(listeEtudiant);
    }  
}