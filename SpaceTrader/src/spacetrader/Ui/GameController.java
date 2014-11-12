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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import spacetrader.*;
import spacetrader.Universe.Planet;
import spacetrader.Universe.Universe;
import javafx.scene.control.ListView;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
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

    // Shipyard
    @FXML private ListView shipyard;
    @FXML private Text shipName;
    @FXML private Text shipSize;
    @FXML private Text cargoBays;
    @FXML private Text maxRange;
    @FXML private Text shipQuality;
    @FXML private Text shipPrice;
    @FXML private Text shipNotification;
    @FXML private Button buyShip;
    @FXML private Button buyFuel;
    @FXML private Button repairShip;
    @FXML private Tab shipyardTab;
    private HashMap<String, Ship> shipMap;
    private HashMap<String, Integer> shipPrices;

    //Upgrades
    @FXML private ListView upgrades;
    @FXML private Text weaponName;
    @FXML private Text damageVal;
    @FXML private Text maxChargeVal;
    @FXML private Text qualityReqVal;
    @FXML private Button buyUpgrade;
    @FXML private Button rechargeWeapon;
    @FXML private Text weaponSlots;
    @FXML private Text upgradePrice;
    @FXML private Text damage;
    @FXML private Text qualityReq;
    @FXML private Text isExplosive;
    @FXML private Text isExplosiveValue;
    @FXML private Text shieldSlots;


    @FXML
    private void saveGameAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(SpaceTrader.stage);
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
            File file = fileChooser.showOpenDialog(SpaceTrader.stage);
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
        System.out.println("Retire feature has not been implemented yet.");
    }

    @FXML
    private void quitGameAction(ActionEvent event) {
        SpaceTrader.stage.setScene(SpaceTrader.allScenes[0]);
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
            String selectedItem = marketplace.getSelectionModel()
                    .getSelectedItem() + "";
            Player.getInstance().buy(selectedItem + "", Integer
                    .parseInt(quantity.getText()));
            inventory.setText(Player.getInstance().ship()
                    .getAmount(selectedItem) + "");
            available.setText(Player.getInstance().location()
                    .getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship()
                    .getCurrentCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
        } else if (event.getSource().equals(sell)) {
            String selectedItem = marketplace.getSelectionModel()
                    .getSelectedItem() + "";
            Player.getInstance().sell(selectedItem + "", Integer
                    .parseInt(quantity.getText()));
            inventory.setText(Player.getInstance().ship()
                    .getAmount(selectedItem) + "");
            available.setText(Player.getInstance().location()
                    .getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance()
                    .ship().getCurrentCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
        }     
    }

    private void refreshMarketplace() {
        try {
            String selectedItem = marketplace.getSelectionModel()
                    .getSelectedItem() + "";
            inventory.setText(Player.getInstance().ship()
                    .getAmount(selectedItem) + "");
            buyingPrice.setText(Player.getInstance().location()
                    .getPrice(selectedItem) + " cr.");
            sellingPrice.setText(Player.getInstance().location()
                    .getPrice(selectedItem) + " cr.");
            available.setText(Player.getInstance().location()
                    .getAmount(selectedItem) + "");
            currentCapacity.setText(Player.getInstance().ship()
                    .getCurrentCargo() + "");
            maximumCapacity.setText(Player.getInstance().ship()
                    .getMaxCargo() + "");
            cash.setText(Player.getInstance().money() + " cr.");
            quantity.setVisible(true);
            buy.setVisible(true);
            sell.setVisible(true);
        }
        catch (NullPointerException e){
            String selectedItem = marketplace.getSelectionModel()
                    .getSelectedItem() + "";
            inventory.setText(Player.getInstance().ship()
                    .getAmount(selectedItem) + "");
            buyingPrice.setText("N/A");
            sellingPrice.setText("N/A");
            available.setText("Not Available");
            currentCapacity.setText(Player.getInstance().ship()
                    .getCurrentCargo() + "");
            maximumCapacity.setText(Player.getInstance().ship()
                    .getMaxCargo() + "");
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
       for (int i = 0; i < Universe.getInstance().getSolarSystems()
               .length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i)
                    .getNumPlanets(); j++) {
                Planet currentPlanet = Universe.getInstance().getSolarSystem(i)
                        .getPlanet(j);
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
                pirates = "High";
            } else {
                pirates = "Low";
            }
            spawnspirates.setText(pirates);
        }
    }

    @FXML
    private void travelAction(ActionEvent event) {
        Planet destination = Player.getInstance().location();
        for (int i = 0; i < Universe.getInstance().getSolarSystems()
                .length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i)
                    .getNumPlanets(); j++) {
                String traversePlanet = Universe.getInstance().getSolarSystem(i)
                        .getPlanet(j).getName();
                String selectedPlanet = selectedDestination.getText();
                if (traversePlanet.equals(selectedPlanet)) {
                    destination = Universe.getInstance().getSolarSystem(i)
                            .getPlanet(j);
                }
            }
        }

        if(!Player.getInstance().canTravel(destination)) {
            notification.setVisible(true);
        } else {
            Player.getInstance().travel(destination);
            if (Player.getInstance().location().getTechLevel() > 3) {
                shipyardTab.setDisable(false);
            } else {
                shipyardTab.setDisable(true);
            }
            refreshMap();
        }
        refreshMap();

        if (Player.getInstance().location().isEncounter()) {
            RandomEncounterController.initializeEncounter(Player.getInstance()
                    .location().getEncounterShip());
            SpaceTrader.stage.setScene(SpaceTrader.allScenes[3]);
        }
    }

    private void refreshMap() {
        mapPane.getChildren().clear();
        Group circles = new Group();
        Circle circle;
        Color color;

        for (int i = 0; i < Universe.getInstance().getSolarSystems()
                .length; i++) {
            for(int j = 0; j < Universe.getInstance().getSolarSystem(i)
                    .getNumPlanets(); j++) {
                Planet currentPlanet = Universe.getInstance().getSolarSystem(i)
                        .getPlanet(j);
                if (Player.getInstance().location().equals(currentPlanet)) {
                    color = Color.rgb(255, 0, 0);
                } else if (Player.getInstance().canTravel(currentPlanet)) {
                    color = Color.rgb(0, 255, 0);
                } else {
                    color = Color.rgb(0, 0, 255);
                }
                circle = new Circle(currentPlanet.getX() * 2,
                        currentPlanet.getY() * 2, 2, color);
                circle.setId(currentPlanet.getName());
                circles.getChildren().add(circle);
            }
        }
        mapPane.getChildren().add(circles);

        currentLocation.setText(Player.getInstance().location().getName());
        selectedDestination.setText(Player.getInstance().location().getName());
        techLevel.setText(Player.getInstance().location()
                .tchlvlString(Player.getInstance().location().getTechLevel()));
        resources.setText(Player.getInstance().location()
                .rscString(Player.getInstance().location().getResources()));
        String pirates;
        if (Player.getInstance().location().spawnsPirates()) {
            pirates = "High";
        } else {
            pirates = "Low";
        }
        spawnspirates.setText(pirates);
        fuel.setText(Player.getInstance().ship().getCurrRange() + "");
    }



    // Shipyard

    @FXML
    private void shipyardSelectedAction(Event event) {
        List<String> list = Arrays.asList("Flea", "Gnat", "Firefly", "Mosquito",
                "Bumblebee", "Beetle", "Hornet", "Grasshopper", "Termite", "Wasp");
        List<String> upgradesList = Arrays.asList("Lo-power Lazer", "Mid-Power Lazer",
                "Hi-Power Lazer", "Shield Level 1", "Shield Level 2");
        shipyard.setItems(FXCollections.observableList(list));
        upgrades.setItems(FXCollections.observableList(upgradesList));

        if (Player.getInstance().ship().getCurrRange()
                != Player.getInstance().ship().getMaxRange()) {
            buyFuel.setVisible(true);
        } else {
            buyFuel.setVisible(false);
        }

        if (Player.getInstance().ship().getHull()
                != Player.getInstance().ship().getMaxHull()) {
            repairShip.setVisible(true);
        } else {
            repairShip.setVisible(false);
        }
    }

    @FXML
    private void shipyardAction(MouseEvent event) {
        refreshShipyard();
    }

    @FXML
    private void buyFuelAction(ActionEvent event) {
        int price = Player.getInstance().ship().getMaxRange()
                - Player.getInstance().ship().getCurrRange();
        Player.getInstance().subtractMoney(price * 2);

        Player.getInstance().ship().refuel();
        buyFuel.setVisible(false);
    }

    @FXML
    private void repairShipAction(ActionEvent event) {
        int price = Player.getInstance().ship().getMaxHull()
                - Player.getInstance().ship().getHull();
        Player.getInstance().subtractMoney(price * 5);
        Player.getInstance().ship().repair();
        repairShip.setVisible(false);
    }

    @FXML
    private void buyShipAction(ActionEvent event) {
        String selectedItem = shipyard.getSelectionModel()
                .getSelectedItem() + "";
        Ship selectedShip = shipMap.get(selectedItem);
        int price = shipPrices.get(selectedItem);
        if (Player.getInstance().money() >= price && !Player.getInstance()
                .ship().getName().equals(selectedShip.getName())) {
            Player.getInstance().setShip(selectedShip);
            Player.getInstance().subtractMoney(price);
            shipNotification.setVisible(true);
        }
    }

    private void refreshShipyard() {
        String selectedItem = shipyard.getSelectionModel()
                .getSelectedItem() + "";
        shipName.setText(selectedItem);
        String sizeString = "";
        if (shipMap.get(selectedItem).getSize() == 10) {
            sizeString = "Tiny";
        } else if (shipMap.get(selectedItem).getSize() == 20) {
            sizeString = "Small";
        } else if (shipMap.get(selectedItem).getSize() == 30) {
            sizeString = "Medium";
        } else if (shipMap.get(selectedItem).getSize() == 40) {
            sizeString = "Large";
        } else if (shipMap.get(selectedItem).getSize() == 50) {
            sizeString = "Huge";
        }
        shipSize.setText(sizeString);
        cargoBays.setText(shipMap.get(selectedItem).getMaxCargo() + "");
        maxRange.setText(shipMap.get(selectedItem).getMaxRange() + "");
        String qualityString = "";
        if (shipMap.get(selectedItem).getQuality() == 1) {
            qualityString = "Standard";
        } else if (shipMap.get(selectedItem).getQuality() == 2) {
            qualityString = "Better";
        } else if (shipMap.get(selectedItem).getQuality() == 3) {
            qualityString = "Best";
        }
        shipQuality.setText(qualityString);

        if (Player.getInstance().ship().getCurrRange()
                != Player.getInstance().ship().getMaxRange()) {
            buyFuel.setVisible(true);
        } else {
            buyFuel.setVisible(false);
        }

        if (Player.getInstance().ship().getHull()
                != Player.getInstance().ship().getMaxHull()) {
            repairShip.setVisible(true);
        } else {
            repairShip.setVisible(false);
        }

        shipNotification.setVisible(false);
        shipPrice.setText(shipPrices.get(selectedItem).toString() + " cr.");
    }

    //Upgrade Action Handlers
    @FXML 
    private void refreshUpgrades() {
        HashMap<String, Object> upgradeMap = Player.getInstance()
                .location().getUpgrades();
        String selectedUpgrade = upgrades.getSelectionModel()
                .getSelectedItem() + "";
        Object selection = upgradeMap.get(selectedUpgrade);
        weaponSlots.setText(Player.getInstance().ship().getWeaponSlots() + "");
        shieldSlots.setText(Player.getInstance().ship().getShieldSlots() + "");
        if (selection instanceof Weapon) {
            damage.setText("Damage");
            qualityReq.setText("Ship Quality Required");
            isExplosive.setVisible(false);
            isExplosiveValue.setVisible(false);
            Weapon weapon = (Weapon) selection;
            damageVal.setText(weapon.getDamage() + "");
            upgradePrice.setText(weapon.getPrice() + "");
            qualityReqVal.setText(weapon.getMinQuality() + "");
            weaponName.setText(weapon.getName());
            
        } else {
            isExplosive.setVisible(true);
            isExplosiveValue.setVisible(true);
            Shield shield = (Shield) selection;
            upgradePrice.setText(shield.getPrice() + "");
            damage.setText("Max Charge");
            damageVal.setText(shield.getMaxCharge() + "");
            qualityReq.setText("Reflective");
            if (shield.isReflective()) {
                qualityReqVal.setText("Yes");
            } else {
                qualityReqVal.setText("No");
            }
            if (shield.isExplosive()) {
                isExplosiveValue.setText("Yes");
            } else {
                isExplosiveValue.setText("No");
            }
                    
        }
    }

    @FXML
    private void upgradesAction() {
        refreshUpgrades();
    }
  
    @FXML
    private void buyUpgradeAction(ActionEvent event) {
        HashMap<String, Object> upgradeMap = Player.getInstance()
                .location().getUpgrades();
        String selectedUpgrade = upgrades.getSelectionModel()
                .getSelectedItem() + "";
        Object selection = upgradeMap.get(selectedUpgrade);
        int money = Player.getInstance().money();
        if (selection instanceof Weapon) {
            Weapon weapon = (Weapon) selection;
            if (money > weapon.getPrice()){
                if (Player.getInstance().ship().getWeaponSlots() != 0) {
                    Player.getInstance().ship().addWeapon(weapon);
                    Player.getInstance().setMoney(money - weapon.getPrice());
                    weaponSlots.setText(Player.getInstance().ship()
                            .getWeaponSlots() + "");
                }
            }
        } else {
           Shield shield = (Shield) selection;
            if (money > shield.getPrice()){
                if (Player.getInstance().ship().getShieldSlots() != 0) {
                    Player.getInstance().ship().addShield(shield);
                    Player.getInstance().setMoney(money - shield.getPrice());
                    shieldSlots.setText(Player.getInstance().ship()
                            .getShieldSlots() + "");
                }
            }
        }
    }


    // Others

    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        List<String> list = Arrays.asList("Water", "Fur", "Food", "Ore",
                "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots");
        marketplace.setItems(FXCollections.observableList(list));

        shipMap = new HashMap<String, Ship>();
        shipMap.put("Flea", new Flea());
        shipMap.put("Gnat", new Gnat());
        shipMap.put("Firefly", new FireFly());
        shipMap.put("Mosquito", new Mosquito());
        shipMap.put("Bumblebee", new Bumblebee());
        shipMap.put("Beetle", new Beetle());
        shipMap.put("Hornet", new Hornet());
        shipMap.put("Grasshopper", new Grasshopper());
        shipMap.put("Termite", new Termite());
        shipMap.put("Wasp", new Wasp());
        shipPrices = new HashMap<String, Integer>();
        shipPrices.put("Flea", new Integer(1000));
        shipPrices.put("Gnat", new Integer(2000));
        shipPrices.put("Firefly", new Integer(3500));
        shipPrices.put("Mosquito", new Integer(5000));
        shipPrices.put("Bumblebee", new Integer(7000));
        shipPrices.put("Beetle", new Integer(10000));
        shipPrices.put("Hornet", new Integer(15000));
        shipPrices.put("Grasshopper", new Integer(20000));
        shipPrices.put("Termite", new Integer(30000));
        shipPrices.put("Wasp", new Integer(45000));
    }
}
