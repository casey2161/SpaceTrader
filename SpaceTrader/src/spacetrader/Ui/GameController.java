/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import spacetrader.Universe.Planet;
import spacetrader.Universe.Universe;
import javafx.scene.control.ListView;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.event.Event;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class GameController implements Initializable {
    // Statics
    private static Stage stage;
    private static Scene[] allScenes;
    
    // Top menu
    @FXML private Button saveGame;
    @FXML private Button loadGame;
    @FXML private Button retire;
    
    // Marketplace
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
    
    // Travel
    @FXML private Pane mapPane;
    @FXML private Text currentLocation;
    @FXML private Text selectedDestination;
    @FXML private Text notification;
    @FXML private Text techLevel;
    @FXML private Text resources;
    @FXML private Text spawnspirates;
    @FXML private Text fuel;
    private Scene currentScene;
    

    
    // Top menu
    
    @FXML
    private void saveGameAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Universe.getInstance());
            oos.writeObject(Player.getInstance());
            oos.close();
            fos.close();
        } catch(IOException ioe) {
            //This should never happen
        }
    }

    @FXML
    private void loadGameAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Universe.setInstance((Universe) ois.readObject());
            Player.setInstance((Player) ois.readObject());
            refreshMap();
        } catch(Exception e) {
            //Shouldn't happen
            e.printStackTrace();
        }
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

    
    // Marketplace Tab
    
    @FXML
    private void marketplaceSelectedAction(Event event) {
        refreshMarketplace();
    }
    
    @FXML
    private void listViewAction(MouseEvent event) {
        refreshMarketplace();
    }
    
    @FXML
    private void tradeAction(ActionEvent event) {
        if (event.getSource().equals(buy)) {
            String selectedItem = marketplace.getSelectionModel().getSelectedItem() + "";
            Player.getInstance().buy(selectedItem + "", Integer.parseInt(quantity.getText()));
            inventory.setText(Player.getInstance().ship().getAmount(selectedItem) + "");
            available.setText(Player.getInstance().location().getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship().getCurrentCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
        } else if (event.getSource().equals(sell)) {
            String selectedItem = marketplace.getSelectionModel().getSelectedItem() + "";
            Player.getInstance().sell(selectedItem + "", Integer.parseInt(quantity.getText()));
            inventory.setText(Player.getInstance().ship().getAmount(selectedItem) + "");
            available.setText(Player.getInstance().location().getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship().getCurrentCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
        }     
    }
    
    private void refreshMarketplace() {
        try {
            String selectedItem = marketplace.getSelectionModel().getSelectedItem() + "";
            inventory.setText(Player.getInstance().ship().getAmount(selectedItem) + "");
            buyingPrice.setText(Player.getInstance().location().getPrice(selectedItem) + " cr.");
            sellingPrice.setText(Player.getInstance().location().getPrice(selectedItem) + " cr.");
            available.setText(Player.getInstance().location().getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship().getCurrentCargo() + "");
            maximumCapacity.setText(Player.getInstance().ship().getMaxCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
            quantity.setVisible(true);
            buy.setVisible(true);
            sell.setVisible(true);
        }
        catch (NullPointerException e){
            String selectedItem = marketplace.getSelectionModel().getSelectedItem() + "";
            inventory.setText(Player.getInstance().ship().getAmount(selectedItem) + "");
            buyingPrice.setText("N/A");
            sellingPrice.setText("N/A");
            available.setText("Not Available");
            currentCapacity.setText(Player.getInstance().ship().getCurrentCargo() + "");
            maximumCapacity.setText(Player.getInstance().ship().getMaxCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
            quantity.setVisible(false);
            buy.setVisible(false);
            sell.setVisible(false);
        }
    }
    

    //Travel
    
    @FXML
    private void travelSelectedAction(Event event) {
        refreshMap();
    }
    
    
    @FXML
    private void mapClickedAction(MouseEvent event) {
       refreshMap();
       notification.setVisible(false);
       double mouseX = event.getX();
       double mouseY = event.getY();
       boolean planetIsSelected = false;
       
       Planet planet = Player.getInstance().location();
       for (int i = 0; i < Universe.getInstance().getSolarSystems().length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i).getNumPlanets(); j++) {
                Planet currentPlanet = Universe.getInstance().getSolarSystem(i).getPlanet(j);
                int planetX = currentPlanet.getX() * 2;
                int planetY = currentPlanet.getY() * 2;
                if (mouseX >= planetX - 2 && mouseX <= planetX + 2 &&
                        mouseY >= planetY - 2 && mouseY <= planetY + 2) {
                    planet = currentPlanet;
                    planetIsSelected = true;
                }
            }
        }
        if (planetIsSelected) {
            selectedDestination.setText(planet.getName());
            techLevel.setText(planet.tchlvlString(planet.getTechLevel()));
            resources.setText(planet.rscString(planet.getResources()));
            String pirates;
            if (planet.spawnsPirates()) {
                pirates = "Yes";
            } else {
                pirates = "No";
            }
            spawnspirates.setText(pirates);
        }
    }
    
    @FXML
    private void travelAction(ActionEvent event) {
        Planet destination = Player.getInstance().location();
        for (int i = 0; i < Universe.getInstance().getSolarSystems().length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i).getNumPlanets(); j++) {
                String traversePlanet = Universe.getInstance().getSolarSystem(i).getPlanet(j).getName();
                String selectedPlanet = selectedDestination.getText();
                if (traversePlanet.equals(selectedPlanet)) {
                    destination = Universe.getInstance().getSolarSystem(i).getPlanet(j);
                }
            }
        }
        
        if(!Player.getInstance().canTravel(destination)) {
            notification.setVisible(true);
        } else {
            Player.getInstance().travel(destination);
            refreshMap();
        }
        refreshMap();
    }
    
    private void refreshMap() {
        mapPane.getChildren().clear();
        Group circles = new Group();
        Circle circle;
        Color color;

        for (int i = 0; i < Universe.getInstance().getSolarSystems().length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i).getNumPlanets(); j++) {
                Planet currentPlanet = Universe.getInstance().getSolarSystem(i).getPlanet(j);
                if (Player.getInstance().location().equals(currentPlanet)) {
                    color = Color.rgb(255, 0, 0);
                } else if (Player.getInstance().canTravel(currentPlanet)) {
                    color = Color.rgb(0, 255, 0);
                } else {
                    color = Color.rgb(0, 0, 255);
                }
                circle = new Circle(currentPlanet.getX() * 2, currentPlanet.getY() * 2, 2, color);
                circle.setId(currentPlanet.getName());
                circles.getChildren().add(circle);
            }
        }
        mapPane.getChildren().add(circles);

        currentLocation.setText(Player.getInstance().location().getName());
        selectedDestination.setText(Player.getInstance().location().getName());
        techLevel.setText(Player.getInstance().location().tchlvlString(Player.getInstance().location().getTechLevel()));
        resources.setText(Player.getInstance().location().rscString(Player.getInstance().location().getResources()));
        String pirates;
        if (Player.getInstance().location().spawnsPirates()) {
            pirates = "Yes";
        } else {
            pirates = "No";
        }
        spawnspirates.setText(pirates);
        fuel.setText(Player.getInstance().ship().getCurrRange() + "");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
       List<String> list = Arrays.asList("Water", "Fur", "Food", "Ore",
                "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots");
        marketplace.setItems(FXCollections.observableList(list));
    }
            
    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
