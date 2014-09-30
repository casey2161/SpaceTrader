/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import spacetrader.Player;
import spacetrader.Ship;
import spacetrader.Universe.Planet;
import spacetrader.Universe.SolarSystem;

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class GameController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;
    private static Player player;
    private static SolarSystem solarSystem;
    private static Planet planet;
    private static Ship ship;
    
    // Top menu
    @FXML private Button saveGame;
    @FXML private Button loadGame;
    @FXML private Button retire;
    
    // Goods tab
    @FXML private Button buyWater;
    @FXML private Button buyFurs;
    @FXML private Button buyFood;
    @FXML private Button buyOre;
    @FXML private Button buyGames;
    @FXML private Button buyFirearms;
    @FXML private Button buyMedicine;
    @FXML private Button buyMachines;
    @FXML private Button buyNarcotics;
    @FXML private Button buyRobots;
    @FXML private Button sellWater;
    @FXML private Button sellFurs;
    @FXML private Button sellFood;
    @FXML private Button sellOre;
    @FXML private Button sellGames;
    @FXML private Button sellFirearms;
    @FXML private Button sellMedicine;
    @FXML private Button sellMachines;
    @FXML private Button sellNarcotics;
    @FXML private Button sellRobots;
    @FXML private Button buyWaterPlus;
    @FXML private Button buyFursPlus;
    @FXML private Button buyFoodPlus;
    @FXML private Button buyOrePlus;
    @FXML private Button buyGamesPlus;
    @FXML private Button buyFirearmsPlus;
    @FXML private Button buyMedicinePlus;
    @FXML private Button buyMachinesPlus;
    @FXML private Button buyNarcoticsPlus;
    @FXML private Button buyRobotsPlus;
    @FXML private Button sellWaterPlus;
    @FXML private Button sellFursPlus;
    @FXML private Button sellFoodPlus;
    @FXML private Button sellOrePlus;
    @FXML private Button sellGamesPlus;
    @FXML private Button sellFirearmsPlus;
    @FXML private Button sellMedicinePlus;
    @FXML private Button sellMachinesPlus;
    @FXML private Button sellNarcoticsPlus;
    @FXML private Button sellRobotsPlus;
    @FXML private Button buyWaterMinus;
    @FXML private Button buyFursMinus;
    @FXML private Button buyFoodMinus;
    @FXML private Button buyOreMinus;
    @FXML private Button buyGamesMinus;
    @FXML private Button buyFirearmsMinus;
    @FXML private Button buyMedicineMinus;
    @FXML private Button buyMachinesMinus;
    @FXML private Button buyNarcoticsMinus;
    @FXML private Button buyRobotsMinus;
    @FXML private Button sellWaterMinus;
    @FXML private Button sellFursMinus;
    @FXML private Button sellFoodMinus;
    @FXML private Button sellOreMinus;
    @FXML private Button sellGamesMinus;
    @FXML private Button sellFirearmsMinus;
    @FXML private Button sellMedicineMinus;
    @FXML private Button sellMachinesMinus;
    @FXML private Button sellNarcoticsMinus;
    @FXML private Button sellRobotsMinus;
    @FXML private Button buyWaterConfirm;
    @FXML private Button buyFursConfirm;
    @FXML private Button buyFoodConfirm;
    @FXML private Button buyOreConfirm;
    @FXML private Button buyGamesConfirm;
    @FXML private Button buyFirearmsConfirm;
    @FXML private Button buyMedicineConfirm;
    @FXML private Button buyMachinesConfirm;
    @FXML private Button buyNarcoticsConfirm;
    @FXML private Button buyRobotsConfirm;
    @FXML private Button sellWaterConfirm;
    @FXML private Button sellFursConfirm;
    @FXML private Button sellFoodConfirm;
    @FXML private Button sellOreConfirm;
    @FXML private Button sellGamesConfirm;
    @FXML private Button sellFirearmsConfirm;
    @FXML private Button sellMedicineConfirm;
    @FXML private Button sellMachinesConfirm;
    @FXML private Button sellNarcoticsConfirm;
    @FXML private Button sellRobotsConfirm;
    @FXML private Text buyWaterPrice;
    @FXML private Text buyFursPrice;
    @FXML private Text buyFoodPrice;
    @FXML private Text buyOrePrice;
    @FXML private Text buyGamesPrice;
    @FXML private Text buyFirearmsPrice;
    @FXML private Text buyMedicinePrice;
    @FXML private Text buyMachinesPrice;
    @FXML private Text buyNarcoticsPrice;
    @FXML private Text buyRobotsPrice;
    @FXML private Text sellWaterPrice;
    @FXML private Text sellFursPrice;
    @FXML private Text sellFoodPrice;
    @FXML private Text sellOrePrice;
    @FXML private Text sellGamesPrice;
    @FXML private Text sellFirearmsPrice;
    @FXML private Text sellMedicinePrice;
    @FXML private Text sellMachinesPrice;
    @FXML private Text sellNarcoticsPrice;
    @FXML private Text sellRobotsPrice;
    @FXML private Text buyWaterQuantity;
    @FXML private Text buyFursQuantity;
    @FXML private Text buyFoodQuantity;
    @FXML private Text buyOreQuantity;
    @FXML private Text buyGamesQuantity;
    @FXML private Text buyFirearmsQuantity;
    @FXML private Text buyMedicineQuantity;
    @FXML private Text buyMachinesQuantity;
    @FXML private Text buyNarcoticsQuantity;
    @FXML private Text buyRobotsQuantity;
    @FXML private Text sellWaterQuantity;
    @FXML private Text sellFursQuantity;
    @FXML private Text sellFoodQuantity;
    @FXML private Text sellOreQuantity;
    @FXML private Text sellGamesQuantity;
    @FXML private Text sellFirearmsQuantity;
    @FXML private Text sellMedicineQuantity;
    @FXML private Text sellMachinesQuantity;
    @FXML private Text sellNarcoticsQuantity;
    @FXML private Text sellRobotsQuantity;
    @FXML private Text buyCurrentBays;
    @FXML private Text buyMaxBays;
    @FXML private Text buyCash;
    @FXML private Text sellCurrentBays;
    @FXML private Text sellMaxBays;
    @FXML private Text sellCash;

    
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
    private void tradeAction(ActionEvent event) {
        if (event.getSource().equals(buyWater)) {
            if(!buyWaterQuantity.isVisible()) {
                buyWaterQuantity.setVisible(true);
                buyWaterMinus.setVisible(true);
                buyWaterPlus.setVisible(true);
                buyWaterConfirm.setVisible(true);
            } else {
                buyWaterQuantity.setText("0");
                buyWaterQuantity.setVisible(false);
                buyWaterMinus.setVisible(false);
                buyWaterPlus.setVisible(false);
                buyWaterConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFurs)) {
            if(!buyFursQuantity.isVisible()) {
                buyFursQuantity.setVisible(true);
                buyFursMinus.setVisible(true);
                buyFursPlus.setVisible(true);
                buyFursConfirm.setVisible(true);
            } else {
                buyFursQuantity.setText("0");
                buyFursQuantity.setVisible(false);
                buyFursMinus.setVisible(false);
                buyFursPlus.setVisible(false);
                buyFursConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFood)) {
            if(!buyFoodQuantity.isVisible()) {
                buyFoodQuantity.setVisible(true);
                buyFoodMinus.setVisible(true);
                buyFoodPlus.setVisible(true);
                buyFoodConfirm.setVisible(true);
            } else {
                buyFoodQuantity.setText("0");
                buyFoodQuantity.setVisible(false);
                buyFoodMinus.setVisible(false);
                buyFoodPlus.setVisible(false);
                buyFoodConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyOre)) {
            if(!buyOreQuantity.isVisible()) {
                buyOreQuantity.setVisible(true);
                buyOreMinus.setVisible(true);
                buyOrePlus.setVisible(true);
                buyOreConfirm.setVisible(true);
            } else {
                buyOreQuantity.setText("0");
                buyOreQuantity.setVisible(false);
                buyOreMinus.setVisible(false);
                buyOrePlus.setVisible(false);
                buyOreConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyGames)) {
            if(!buyGamesQuantity.isVisible()) {
                buyGamesQuantity.setVisible(true);
                buyGamesMinus.setVisible(true);
                buyGamesPlus.setVisible(true);
                buyGamesConfirm.setVisible(true);
            } else {
                buyGamesQuantity.setText("0");
                buyGamesQuantity.setVisible(false);
                buyGamesMinus.setVisible(false);
                buyGamesPlus.setVisible(false);
                buyGamesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFirearms)) {
            if(!buyFirearmsQuantity.isVisible()) {
                buyFirearmsQuantity.setVisible(true);
                buyFirearmsMinus.setVisible(true);
                buyFirearmsPlus.setVisible(true);
                buyFirearmsConfirm.setVisible(true);
            } else {
                buyFirearmsQuantity.setText("0");
                buyFirearmsQuantity.setVisible(false);
                buyFirearmsMinus.setVisible(false);
                buyFirearmsPlus.setVisible(false);
                buyFirearmsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyMedicine)) {
            if(!buyMedicineQuantity.isVisible()) {
                buyMedicineQuantity.setVisible(true);
                buyMedicineMinus.setVisible(true);
                buyMedicinePlus.setVisible(true);
                buyMedicineConfirm.setVisible(true);
            } else {
                buyMedicineQuantity.setText("0");
                buyMedicineQuantity.setVisible(false);
                buyMedicineMinus.setVisible(false);
                buyMedicinePlus.setVisible(false);
                buyMedicineConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyMachines)) {
            if(!buyMachinesQuantity.isVisible()) {
                buyMachinesQuantity.setVisible(true);
                buyMachinesMinus.setVisible(true);
                buyMachinesPlus.setVisible(true);
                buyMachinesConfirm.setVisible(true);
            } else {
                buyMachinesQuantity.setText("0");
                buyMachinesQuantity.setVisible(false);
                buyMachinesMinus.setVisible(false);
                buyMachinesPlus.setVisible(false);
                buyMachinesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyNarcotics)) {
            if(!buyNarcoticsQuantity.isVisible()) {
                buyNarcoticsQuantity.setVisible(true);
                buyNarcoticsMinus.setVisible(true);
                buyNarcoticsPlus.setVisible(true);
                buyNarcoticsConfirm.setVisible(true);
            } else {
                buyNarcoticsQuantity.setText("0");
                buyNarcoticsQuantity.setVisible(false);
                buyNarcoticsMinus.setVisible(false);
                buyNarcoticsPlus.setVisible(false);
                buyNarcoticsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyRobots)) {
            if(!buyRobotsQuantity.isVisible()) {
                buyRobotsQuantity.setVisible(true);
                buyRobotsMinus.setVisible(true);
                buyRobotsPlus.setVisible(true);
                buyRobotsConfirm.setVisible(true);
            } else {
                buyRobotsQuantity.setText("0");
                buyRobotsQuantity.setVisible(false);
                buyRobotsMinus.setVisible(false);
                buyRobotsPlus.setVisible(false);
                buyRobotsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellWater)) {
            if(!sellWaterQuantity.isVisible()) {
                sellWaterQuantity.setVisible(true);
                sellWaterMinus.setVisible(true);
                sellWaterPlus.setVisible(true);
                sellWaterConfirm.setVisible(true);
            } else {
                sellWaterQuantity.setText("0");
                sellWaterQuantity.setVisible(false);
                sellWaterMinus.setVisible(false);
                sellWaterPlus.setVisible(false);
                sellWaterConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFurs)) {
            if(!sellFursQuantity.isVisible()) {
                sellFursQuantity.setVisible(true);
                sellFursMinus.setVisible(true);
                sellFursPlus.setVisible(true);
                sellFursConfirm.setVisible(true);
            } else {
                sellFursQuantity.setText("0");
                sellFursQuantity.setVisible(false);
                sellFursMinus.setVisible(false);
                sellFursPlus.setVisible(false);
                sellFursConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFood)) {
            if(!sellFoodQuantity.isVisible()) {
                sellFoodQuantity.setVisible(true);
                sellFoodMinus.setVisible(true);
                sellFoodPlus.setVisible(true);
                sellFoodConfirm.setVisible(true);
            } else {
                sellFoodQuantity.setText("0");
                sellFoodQuantity.setVisible(false);
                sellFoodMinus.setVisible(false);
                sellFoodPlus.setVisible(false);
                sellFoodConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellOre)) {
            if(!sellOreQuantity.isVisible()) {
                sellOreQuantity.setVisible(true);
                sellOreMinus.setVisible(true);
                sellOrePlus.setVisible(true);
                sellOreConfirm.setVisible(true);
            } else {
                sellOreQuantity.setText("0");
                sellOreQuantity.setVisible(false);
                sellOreMinus.setVisible(false);
                sellOrePlus.setVisible(false);
                sellOreConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellGames)) {
            if(!sellGamesQuantity.isVisible()) {
                sellGamesQuantity.setVisible(true);
                sellGamesMinus.setVisible(true);
                sellGamesPlus.setVisible(true);
                sellGamesConfirm.setVisible(true);
            } else {
                sellGamesQuantity.setText("0");
                sellGamesQuantity.setVisible(false);
                sellGamesMinus.setVisible(false);
                sellGamesPlus.setVisible(false);
                sellGamesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFirearms)) {
            if(!sellFirearmsQuantity.isVisible()) {
                sellFirearmsQuantity.setVisible(true);
                sellFirearmsMinus.setVisible(true);
                sellFirearmsPlus.setVisible(true);
                sellFirearmsConfirm.setVisible(true);
            } else {
                sellFirearmsQuantity.setText("0");
                sellFirearmsQuantity.setVisible(false);
                sellFirearmsMinus.setVisible(false);
                sellFirearmsPlus.setVisible(false);
                sellFirearmsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellMedicine)) {
            if(!sellMedicineQuantity.isVisible()) {
                sellMedicineQuantity.setVisible(true);
                sellMedicineMinus.setVisible(true);
                sellMedicinePlus.setVisible(true);
                sellMedicineConfirm.setVisible(true);
            } else {
                sellMedicineQuantity.setText("0");
                sellMedicineQuantity.setVisible(false);
                sellMedicineMinus.setVisible(false);
                sellMedicinePlus.setVisible(false);
                sellMedicineConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellMachines)) {
            if(!sellMachinesQuantity.isVisible()) {
                sellMachinesQuantity.setVisible(true);
                sellMachinesMinus.setVisible(true);
                sellMachinesPlus.setVisible(true);
                sellMachinesConfirm.setVisible(true);
            } else {
                sellMachinesQuantity.setText("0");
                sellMachinesQuantity.setVisible(false);
                sellMachinesMinus.setVisible(false);
                sellMachinesPlus.setVisible(false);
                sellMachinesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellNarcotics)) {
            if(!sellNarcoticsQuantity.isVisible()) {
                sellNarcoticsQuantity.setVisible(true);
                sellNarcoticsMinus.setVisible(true);
                sellNarcoticsPlus.setVisible(true);
                sellNarcoticsConfirm.setVisible(true);
            } else {
                sellNarcoticsQuantity.setText("0");
                sellNarcoticsQuantity.setVisible(false);
                sellNarcoticsMinus.setVisible(false);
                sellNarcoticsPlus.setVisible(false);
                sellNarcoticsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellRobots)) {
            if(!sellRobotsQuantity.isVisible()) {
                sellRobotsQuantity.setVisible(true);
                sellRobotsMinus.setVisible(true);
                sellRobotsPlus.setVisible(true);
                sellRobotsConfirm.setVisible(true);
            } else {
                sellRobotsQuantity.setText("0");
                sellRobotsQuantity.setVisible(false);
                sellRobotsMinus.setVisible(false);
                sellRobotsPlus.setVisible(false);
                sellRobotsConfirm.setVisible(false);
            }
        }
    }

    @FXML
    private void confirmAction(ActionEvent event) {
        if (event.getSource().equals(buyWaterConfirm)) {
            int quantity = Integer.parseInt(buyWaterQuantity.getText());
            int price = Integer.parseInt(buyWaterPrice.getText().substring(0, buyWaterPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("water", quantity);
                sellWater.setText(Integer.parseInt(sellWater.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyWaterQuantity.setText("0");
                buyWaterQuantity.setVisible(false);
                buyWaterPlus.setVisible(false);
                buyWaterMinus.setVisible(false);
                buyWaterConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFursConfirm)) {
            int quantity = Integer.parseInt(buyFursQuantity.getText());
            int price = Integer.parseInt(buyFursPrice.getText().substring(0, buyFursPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("furs", quantity);
                sellFurs.setText(Integer.parseInt(sellFurs.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyFursQuantity.setText("0");
                buyFursQuantity.setVisible(false);
                buyFursPlus.setVisible(false);
                buyFursMinus.setVisible(false);
                buyFursConfirm.setVisible(false);
            }
        } else if(event.getSource().equals(buyOreConfirm)) {
            int quantity = Integer.parseInt(buyOreQuantity.getText());
            int price = Integer.parseInt(buyOrePrice.getText().substring(0, buyOrePrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("ore", quantity);
                sellOre.setText(Integer.parseInt(sellOre.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyOreQuantity.setText("0");
                buyOreQuantity.setVisible(false);
                buyOrePlus.setVisible(false);
                buyOreMinus.setVisible(false);
                buyOreConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFoodConfirm)) {
            int quantity = Integer.parseInt(buyFoodQuantity.getText());
            int price = Integer.parseInt(buyFoodPrice.getText().substring(0, buyFoodPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("food", quantity);
                sellFood.setText(Integer.parseInt(sellFood.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyFoodQuantity.setText("0");
                buyFoodQuantity.setVisible(false);
                buyFoodPlus.setVisible(false);
                buyFoodMinus.setVisible(false);
                buyFoodConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyGamesConfirm)) {
             int quantity = Integer.parseInt(buyGamesQuantity.getText());
            int price = Integer.parseInt(buyGamesPrice.getText().substring(0, buyGamesPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("games", quantity);
                sellGames.setText(Integer.parseInt(sellGames.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyGamesQuantity.setText("0");
                buyGamesQuantity.setVisible(false);
                buyGamesPlus.setVisible(false);
                buyGamesMinus.setVisible(false);
                buyGamesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyFirearmsConfirm)) {
             int quantity = Integer.parseInt(buyFirearmsQuantity.getText());
            int price = Integer.parseInt(buyFirearmsPrice.getText().substring(0, buyFirearmsPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("firearms", quantity);
                sellFirearms.setText(Integer.parseInt(sellFirearms.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyFirearmsQuantity.setText("0");
                buyFirearmsQuantity.setVisible(false);
                buyFirearmsPlus.setVisible(false);
                buyFirearmsMinus.setVisible(false);
                buyFirearmsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyMedicineConfirm)) {
             int quantity = Integer.parseInt(buyMedicineQuantity.getText());
            int price = Integer.parseInt(buyMedicinePrice.getText().substring(0, buyMedicinePrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("medicine", quantity);
                sellMedicine.setText(Integer.parseInt(sellMedicine.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyMedicineQuantity.setText("0");
                buyMedicineQuantity.setVisible(false);
                buyMedicinePlus.setVisible(false);
                buyMedicineMinus.setVisible(false);
                buyMedicineConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyMachinesConfirm)) {
             int quantity = Integer.parseInt(buyMachinesQuantity.getText());
            int price = Integer.parseInt(buyMachinesPrice.getText().substring(0, buyMachinesPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("machines", quantity);
                sellMachines.setText(Integer.parseInt(sellMachines.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyMachinesQuantity.setText("0");
                buyMachinesQuantity.setVisible(false);
                buyMachinesPlus.setVisible(false);
                buyMachinesMinus.setVisible(false);
                buyMachinesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyNarcoticsConfirm)) {
             int quantity = Integer.parseInt(buyNarcoticsQuantity.getText());
            int price = Integer.parseInt(buyNarcoticsPrice.getText().substring(0, buyNarcoticsPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("narcotics", quantity);
                sellNarcotics.setText(Integer.parseInt(sellNarcotics.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyNarcoticsQuantity.setText("0");
                buyNarcoticsQuantity.setVisible(false);
                buyNarcoticsPlus.setVisible(false);
                buyNarcoticsMinus.setVisible(false);
                buyNarcoticsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(buyRobotsConfirm)) {
             int quantity = Integer.parseInt(buyRobotsQuantity.getText());
            int price = Integer.parseInt(buyRobotsPrice.getText().substring(0, buyRobotsPrice.getText().length() - 4)) * quantity;
            if (ship.hasRoom(quantity) && (player.getMoney() - price) >= 0) {
                ship.add("robots", quantity);
                sellRobots.setText(Integer.parseInt(sellRobots.getText()) + quantity + "");
                player.setMoney(player.getMoney() - price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                buyRobotsQuantity.setText("0");
                buyRobotsQuantity.setVisible(false);
                buyRobotsPlus.setVisible(false);
                buyRobotsMinus.setVisible(false);
                buyRobotsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellWaterConfirm)) {
            int quantity = Integer.parseInt(sellWaterQuantity.getText());
            int inventory = Integer.parseInt(sellWater.getText());
            int price = Integer.parseInt(sellWaterPrice.getText().substring(0, sellWaterPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("water", quantity) && inventory > 0) {
                ship.remove("water", quantity);
                sellWater.setText(Integer.parseInt(sellWater.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellWaterQuantity.setText("0");
                sellWaterQuantity.setVisible(false);
                sellWaterPlus.setVisible(false);
                sellWaterMinus.setVisible(false);
                sellWaterConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFursConfirm)) {
            int quantity = Integer.parseInt(sellFursQuantity.getText());
            int inventory = Integer.parseInt(sellFurs.getText());
            int price = Integer.parseInt(sellFursPrice.getText().substring(0, sellFursPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("furs", quantity) && inventory > 0) {
                ship.remove("furs", quantity);
                sellFurs.setText(Integer.parseInt(sellFurs.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellFursQuantity.setText("0");
                sellFursQuantity.setVisible(false);
                sellFursPlus.setVisible(false);
                sellFursMinus.setVisible(false);
                sellFursConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellOreConfirm)) {
            int quantity = Integer.parseInt(sellOreQuantity.getText());
            int inventory = Integer.parseInt(sellOre.getText());
            int price = Integer.parseInt(sellOrePrice.getText().substring(0, sellOrePrice.getText().length() - 4)) * quantity;
            if (ship.canSell("ore", quantity) && inventory > 0) {
                ship.remove("ore", quantity);
                sellOre.setText(Integer.parseInt(sellOre.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellOreQuantity.setText("0");
                sellOreQuantity.setVisible(false);
                sellOrePlus.setVisible(false);
                sellOreMinus.setVisible(false);
                sellOreConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFoodConfirm)) {
            int quantity = Integer.parseInt(sellFoodQuantity.getText());
            int inventory = Integer.parseInt(sellFood.getText());
            int price = Integer.parseInt(sellFoodPrice.getText().substring(0, sellFoodPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("food", quantity) && inventory > 0) {
                ship.remove("food", quantity);
                sellFood.setText(Integer.parseInt(sellFood.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellFoodQuantity.setText("0");
                sellFoodQuantity.setVisible(false);
                sellFoodPlus.setVisible(false);
                sellFoodMinus.setVisible(false);
                sellFoodConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellGamesConfirm)) {
            int quantity = Integer.parseInt(sellGamesQuantity.getText());
            int inventory = Integer.parseInt(sellGames.getText());
            int price = Integer.parseInt(sellGamesPrice.getText().substring(0, sellGamesPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("games", quantity) && inventory > 0) {
                ship.remove("games", quantity);
                sellGames.setText(Integer.parseInt(sellGames.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellGamesQuantity.setText("0");
                sellGamesQuantity.setVisible(false);
                sellGamesPlus.setVisible(false);
                sellGamesMinus.setVisible(false);
                sellGamesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellFirearmsConfirm)) {
            int quantity = Integer.parseInt(sellFirearmsQuantity.getText());
            int inventory = Integer.parseInt(sellFirearms.getText());
            int price = Integer.parseInt(sellFirearmsPrice.getText().substring(0, sellFirearmsPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("firearms", quantity) && inventory > 0) {
                ship.remove("firearms", quantity);
                sellFirearms.setText(Integer.parseInt(sellFirearms.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellFirearmsQuantity.setText("0");
                sellFirearmsQuantity.setVisible(false);
                sellFirearmsPlus.setVisible(false);
                sellFirearmsMinus.setVisible(false);
                sellFirearmsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellMedicineConfirm)) {
            int quantity = Integer.parseInt(sellMedicineQuantity.getText());
            int inventory = Integer.parseInt(sellMedicine.getText());
            int price = Integer.parseInt(sellMedicinePrice.getText().substring(0, sellMedicinePrice.getText().length() - 4)) * quantity;
            if (ship.canSell("medicine", quantity) && inventory > 0) {
                ship.remove("medicine", quantity);
                sellMedicine.setText(Integer.parseInt(sellMedicine.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellMedicineQuantity.setText("0");
                sellMedicineQuantity.setVisible(false);
                sellMedicinePlus.setVisible(false);
                sellMedicineMinus.setVisible(false);
                sellMedicineConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellMachinesConfirm)) {
            int quantity = Integer.parseInt(sellMachinesQuantity.getText());
            int inventory = Integer.parseInt(sellMachines.getText());
            int price = Integer.parseInt(sellMachinesPrice.getText().substring(0, sellMachinesPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("machines", quantity) && inventory > 0) {
                ship.remove("machines", quantity);
                sellMachines.setText(Integer.parseInt(sellMachines.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellMachinesQuantity.setText("0");
                sellMachinesQuantity.setVisible(false);
                sellMachinesPlus.setVisible(false);
                sellMachinesMinus.setVisible(false);
                sellMachinesConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellNarcoticsConfirm)) {
            int quantity = Integer.parseInt(sellNarcoticsQuantity.getText());
            int inventory = Integer.parseInt(sellNarcotics.getText());
            int price = Integer.parseInt(sellNarcoticsPrice.getText().substring(0, sellNarcoticsPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("narcotics", quantity) && inventory > 0) {
                ship.remove("narcotics", quantity);
                sellNarcotics.setText(Integer.parseInt(sellNarcotics.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellNarcoticsQuantity.setText("0");
                sellNarcoticsQuantity.setVisible(false);
                sellNarcoticsPlus.setVisible(false);
                sellNarcoticsMinus.setVisible(false);
                sellNarcoticsConfirm.setVisible(false);
            }
        } else if (event.getSource().equals(sellRobotsConfirm)) {
            int quantity = Integer.parseInt(sellRobotsQuantity.getText());
            int inventory = Integer.parseInt(sellRobots.getText());
            int price = Integer.parseInt(sellRobotsPrice.getText().substring(0, sellRobotsPrice.getText().length() - 4)) * quantity;
            if (ship.canSell("robots", quantity) && inventory > 0) {
                ship.remove("robots", quantity);
                sellRobots.setText(Integer.parseInt(sellRobots.getText()) - quantity + "");
                player.setMoney(player.getMoney() + price);
                buyCash.setText(player.getMoney() + "");
                sellCash.setText(player.getMoney() + "");
                buyCurrentBays.setText(ship.getCurrentCargo() + "");
                sellCurrentBays.setText(ship.getCurrentCargo() + "");
                buyMaxBays.setText(ship.getMaxCargo() + "");
                sellMaxBays.setText(ship.getMaxCargo() + "");
                sellRobotsQuantity.setText("0");
                sellRobotsQuantity.setVisible(false);
                sellRobotsPlus.setVisible(false);
                sellRobotsMinus.setVisible(false);
                sellRobotsConfirm.setVisible(false);
            }
        }
    }

    @FXML
    private void plusAction(ActionEvent event) {
        if (event.getSource().equals(buyWaterPlus))
            buyWaterQuantity.setText("" + (Integer.parseInt(buyWaterQuantity.getText()) + 1));
        else if (event.getSource().equals(buyFursPlus))
            buyFursQuantity.setText("" + (Integer.parseInt(buyFursQuantity.getText()) + 1));
        else if (event.getSource().equals(buyFoodPlus))
            buyFoodQuantity.setText("" + (Integer.parseInt(buyFoodQuantity.getText()) + 1));
        else if (event.getSource().equals(buyOrePlus))
            buyOreQuantity.setText("" + (Integer.parseInt(buyOreQuantity.getText()) + 1));
        else if (event.getSource().equals(buyGamesPlus))
            buyGamesQuantity.setText("" + (Integer.parseInt(buyGamesQuantity.getText()) + 1));
        else if (event.getSource().equals(buyFirearmsPlus))
            buyFirearmsQuantity.setText("" + (Integer.parseInt(buyFirearmsQuantity.getText()) + 1));
        else if (event.getSource().equals(buyMedicinePlus))
            buyMedicineQuantity.setText("" + (Integer.parseInt(buyMedicineQuantity.getText()) + 1));
        else if (event.getSource().equals(buyMachinesPlus))
            buyMachinesQuantity.setText("" + (Integer.parseInt(buyMachinesQuantity.getText()) + 1));
        else if (event.getSource().equals(buyNarcoticsPlus))
            buyNarcoticsQuantity.setText("" + (Integer.parseInt(buyNarcoticsQuantity.getText()) + 1));
        else if (event.getSource().equals(buyRobotsPlus))
            buyRobotsQuantity.setText("" + (Integer.parseInt(buyRobotsQuantity.getText()) + 1));
        else if (event.getSource().equals(sellWaterPlus))
            sellWaterQuantity.setText("" + (Integer.parseInt(sellWaterQuantity.getText()) + 1));
        else if (event.getSource().equals(sellFursPlus))
            sellFursQuantity.setText("" + (Integer.parseInt(sellFursQuantity.getText()) + 1));
        else if (event.getSource().equals(sellFoodPlus))
            sellFoodQuantity.setText("" + (Integer.parseInt(sellFoodQuantity.getText()) + 1));
        else if (event.getSource().equals(sellOrePlus))
            sellOreQuantity.setText("" + (Integer.parseInt(sellOreQuantity.getText()) + 1));
        else if (event.getSource().equals(sellGamesPlus))
            sellGamesQuantity.setText("" + (Integer.parseInt(sellGamesQuantity.getText()) + 1));
        else if (event.getSource().equals(sellFirearmsPlus))
            sellFirearmsQuantity.setText("" + (Integer.parseInt(sellFirearmsQuantity.getText()) + 1));
        else if (event.getSource().equals(sellMedicinePlus))
            sellMedicineQuantity.setText("" + (Integer.parseInt(sellMedicineQuantity.getText()) + 1));
        else if (event.getSource().equals(sellMachinesPlus))
            sellMachinesQuantity.setText("" + (Integer.parseInt(sellMachinesQuantity.getText()) + 1));
        else if (event.getSource().equals(sellNarcoticsPlus))
            sellNarcoticsQuantity.setText("" + (Integer.parseInt(sellNarcoticsQuantity.getText()) + 1));
        else if (event.getSource().equals(sellRobotsPlus))
            sellRobotsQuantity.setText("" + (Integer.parseInt(sellRobotsQuantity.getText()) + 1));
    }

    @FXML
    private void minusAction(ActionEvent event) {
        if (event.getSource().equals(buyWaterMinus)) {
            int i = Integer.parseInt(buyWaterQuantity.getText());
            if (i > 0) {
                buyWaterQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyFursMinus)) {
            int i = Integer.parseInt(buyFursQuantity.getText());
            if (i > 0) {
                buyFursQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyFoodMinus)) {
            int i = Integer.parseInt(buyFoodQuantity.getText());
            if (i > 0) {
                buyFoodQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyOreMinus)) {
            int i = Integer.parseInt(buyOreQuantity.getText());
            if (i > 0) {
                buyOreQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyGamesMinus)) {
            int i = Integer.parseInt(buyGamesQuantity.getText());
            if (i > 0) {
                buyGamesQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyFirearmsMinus)) {
            int i = Integer.parseInt(buyFirearmsQuantity.getText());
            if (i > 0) {
                buyFirearmsQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyMedicineMinus)) {
            int i = Integer.parseInt(buyMedicineQuantity.getText());
            if (i > 0) {
                buyMedicineQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyMachinesMinus)) {
            int i = Integer.parseInt(buyMachinesQuantity.getText());
            if (i > 0) {
                buyMachinesQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyNarcoticsMinus)) {
            int i = Integer.parseInt(buyNarcoticsQuantity.getText());
            if (i > 0) {
                buyNarcoticsQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(buyRobotsMinus)) {
            int i = Integer.parseInt(buyRobotsQuantity.getText());
            if (i > 0) {
                buyRobotsQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellWaterMinus)) {
            int i = Integer.parseInt(sellWaterQuantity.getText());
            if (i > 0) {
                sellWaterQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellFursMinus)) {
            int i = Integer.parseInt(sellFursQuantity.getText());
            if (i > 0) {
                sellFursQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellFoodMinus)) {
            int i = Integer.parseInt(sellFoodQuantity.getText());
            if (i > 0) {
                sellFoodQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellOreMinus)) {
            int i = Integer.parseInt(sellOreQuantity.getText());
            if (i > 0) {
                sellOreQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellGamesMinus)) {
            int i = Integer.parseInt(sellGamesQuantity.getText());
            if (i > 0) {
                sellGamesQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellFirearmsMinus)) {
            int i = Integer.parseInt(sellFirearmsQuantity.getText());
            if (i > 0) {
                sellFirearmsQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellMedicineMinus)) {
            int i = Integer.parseInt(sellMedicineQuantity.getText());
            if (i > 0) {
                sellMedicineQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellMachinesMinus)) {
            int i = Integer.parseInt(sellMachinesQuantity.getText());
            if (i > 0) {
                sellMachinesQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellNarcoticsMinus)) {
            int i = Integer.parseInt(sellNarcoticsQuantity.getText());
            if (i > 0) {
                sellNarcoticsQuantity.setText("" + (i - 1));
            }
        }
        else if (event.getSource().equals(sellRobotsMinus)) {
            int i = Integer.parseInt(sellRobotsQuantity.getText());
            if (i > 0) {
                sellRobotsQuantity.setText("" + (i - 1));
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Game object instances
        solarSystem = new SolarSystem("1", 7, 10, 10);
        planet = solarSystem.getPlanet(0); // Default starting planet
        ship = new Ship("shipName", 10, 20, 1, planet);
        
        // Goods
        buyWater.setText("∞");
        buyFurs.setText("∞");
        buyFood.setText("∞");
        buyOre.setText("∞");
        buyGames.setText("∞");
        buyFirearms.setText("∞");
        buyMedicine.setText("∞");
        buyMachines.setText("∞");
        buyNarcotics.setText("∞");
        buyRobots.setText("∞");
        sellWater.setText("0");
        sellFurs.setText("0");
        sellFood.setText("0");
        sellOre.setText("0");
        sellGames.setText("0");
        sellFirearms.setText("0");
        sellMedicine.setText("0");
        sellMachines.setText("0");
        sellNarcotics.setText("0");
        sellRobots.setText("0");
        buyWaterPrice.setText(planet.getAmount("water") + " cr.");
        buyFursPrice.setText(planet.getAmount("furs") + " cr.");
        buyFoodPrice.setText(planet.getAmount("food") + " cr.");
        buyOrePrice.setText(planet.getAmount("ore") + " cr.");
        buyGamesPrice.setText(planet.getAmount("games") + " cr.");
        buyFirearmsPrice.setText(planet.getAmount("firearms") + " cr.");
        buyMedicinePrice.setText(planet.getAmount("medicine") + " cr.");
        buyMachinesPrice.setText(planet.getAmount("machines") + " cr.");
        buyNarcoticsPrice.setText(planet.getAmount("narcotics") + " cr.");
        buyRobotsPrice.setText(planet.getAmount("robots") / 2  + " cr.");
        sellWaterPrice.setText(planet.getAmount("water") / 2 + " cr.");
        sellFursPrice.setText( planet.getAmount("furs") / 2 + " cr.");
        sellFoodPrice.setText(planet.getAmount("food") / 2 + " cr.");
        sellOrePrice.setText( planet.getAmount("ore") / 2 + " cr.");
        sellGamesPrice.setText(planet.getAmount("games") / 2 + " cr.");
        sellFirearmsPrice.setText(planet.getAmount("firearms") / 2 + " cr.");
        sellMedicinePrice.setText(planet.getAmount("medicine") / 2 + " cr.");
        sellMachinesPrice.setText(planet.getAmount("machines") / 2 + " cr.");
        sellNarcoticsPrice.setText(planet.getAmount("narcotics") / 2 + " cr.");
        sellRobotsPrice.setText(planet.getAmount("robots") / 2 + " cr.");
    }

    public static void passPlayer (String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints) {
        player = new Player(name, diff, pilotPoints, fighterPoints, traderPoints, engineerPoints);
    }

    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
