/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import spacetrader.Player;
import spacetrader.Ship;
import spacetrader.Universe.Planet;
import spacetrader.Universe.SolarSystem;
import spacetrader.Universe.Universe;
import javafx.scene.control.ListView;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.event.Event;

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class GameController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;
    private Player player;
    private SolarSystem[] solarSystem = Universe.getInstance().getSolarSystems();
    private Planet planet;
    private Ship ship;
    private Universe universe;
    
    // Top menu
    @FXML private Button saveGame;
    @FXML private Button loadGame;
    @FXML private Button retire;
    
    // Goods
    @FXML private Pane mapPane;
    @FXML private ListView marketplace;
    @FXML private Text available;
    @FXML private Text inventory;
    @FXML private Text buyingPrice;
    @FXML private Text sellingPrice;
    @FXML private TextField quantity;
    @FXML private Text currentCapacity;
    @FXML private Text maximumCapacity;
    @FXML private Text cash;
    @FXML private Button buy;
    @FXML private Button sell;
    private Scene currentScene;
    private Random rand;

    
    // Top menu
    
    @FXML
    private void saveGameAction(ActionEvent event) {
        System.out.println("Save Game feature has not been implemented yet."); // Replace later.
    }

    @FXML
    private void loadGameAction(ActionEvent event) {
        System.out.println("Load Game feature has not been implemented yet."); // Replace later.
    }

    @FXML
    private void retireAction(ActionEvent event) {
        // Moon purchase happens here.
        System.out.println("Retire feature has not been implemented yet."); // Replace later.
    }

    @FXML
    private void quitGameAction(ActionEvent event) {
        stage.setScene(allScenes[0]);
    }

    
    // Goods Tab
    
    @FXML
    private void listViewAction(MouseEvent event) {
        try {
            String selectedItem = marketplace.getSelectionModel().getSelectedItem() + "";
            inventory.setText(Player.getInstance().ship().getAmount(selectedItem) + "");
            buyingPrice.setText(Player.getInstance().location().getPrice(selectedItem) + " cr.");
            sellingPrice.setText(Player.getInstance().location().getPrice(selectedItem) / 2 + " cr.");
            available.setText(Player.getInstance().location().getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship().getCurrentCargo() + "");
            maximumCapacity.setText(Player.getInstance().ship().getMaxCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
        }
        catch (NullPointerException e){
            System.out.println("NULL!");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        // Goods
        List<String> list = Arrays.asList("Water", "Fur", "Food", "Ore",
                "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots");
        marketplace.setItems(FXCollections.observableList(list));
       
        //------------Begin Travel Tab Code----------------------------
        /*currentScene = allScenes[1];
        Pane mapPane;
        mapPane = (Pane) currentScene.lookup("mapPane");*/
        rand = new Random();
        int redInt, greenInt, blueInt;
        SolarSystem system;
        Group circles = new Group();
        Circle circle;
        Color color;
        for(int i = 0; i < solarSystem.length; i++) {
            system = solarSystem[i];
            for(int j = 0; j < system.getNumPlanets(); j++) {
                Planet currPlanet = system.getPlanet(j);
                redInt = rand.nextInt(256);
                greenInt = rand.nextInt(256);
                blueInt = rand.nextInt(256);
                color = Color.rgb(redInt, greenInt, blueInt);
                circle = new Circle(currPlanet.getX(), currPlanet.getY(), 5, color);
                circle.setId(currPlanet.getName());
                circles.getChildren().add(circle);
            }
        }
        mapPane.getChildren().add(circles);
    }

    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
