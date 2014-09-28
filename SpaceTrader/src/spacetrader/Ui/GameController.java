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
import spacetrader.SpaceTrader;
import spacetrader.Weapon;

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class GameController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;
    
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
        
    }

    @FXML
    private void confirmAction(ActionEvent event) {
        /*
        if (event.getSource().equals(buyWaterConfirm))
            
        else if (event.getSource().equals(buyFursConfirm))
            
        else if (event.getSource().equals(buyFoodConfirm))
            
        else if (event.getSource().equals(buyOreConfirm))
            
        else if (event.getSource().equals(buyGamesConfirm))
            
        else if (event.getSource().equals(buyFirearmsConfirm))
            
        else if (event.getSource().equals(buyMedicineConfirm))
            
        else if (event.getSource().equals(buyMachinesConfirm))
            
        else if (event.getSource().equals(buyNarcoticsConfirm))
            
        else if (event.getSource().equals(buyRobotsConfirm))
            
        else if (event.getSource().equals(sellWaterConfirm))
            
        else if (event.getSource().equals(sellFursConfirm))
            
        else if (event.getSource().equals(sellFoodConfirm))
            
        else if (event.getSource().equals(sellOreConfirm))
            
        else if (event.getSource().equals(sellGamesConfirm))
            
        else if (event.getSource().equals(sellFirearmsConfirm))
            
        else if (event.getSource().equals(sellMedicineConfirm))
            
        else if (event.getSource().equals(sellMachinesConfirm))
            
        else if (event.getSource().equals(sellNarcoticsConfirm))
            
        else if (event.getSource().equals(sellRobotsConfirm))
            
        */
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
        if (event.getSource().equals(buyWaterMinus))
            buyWaterQuantity.setText("" + (Integer.parseInt(buyWaterQuantity.getText()) - 1));
        else if (event.getSource().equals(buyFursMinus))
            buyFursQuantity.setText("" + (Integer.parseInt(buyFursQuantity.getText()) - 1));
        else if (event.getSource().equals(buyFoodMinus))
            buyFoodQuantity.setText("" + (Integer.parseInt(buyFoodQuantity.getText()) - 1));
        else if (event.getSource().equals(buyOreMinus))
            buyOreQuantity.setText("" + (Integer.parseInt(buyOreQuantity.getText()) - 1));
        else if (event.getSource().equals(buyGamesMinus))
            buyGamesQuantity.setText("" + (Integer.parseInt(buyGamesQuantity.getText()) - 1));
        else if (event.getSource().equals(buyFirearmsMinus))
            buyFirearmsQuantity.setText("" + (Integer.parseInt(buyFirearmsQuantity.getText()) - 1));
        else if (event.getSource().equals(buyMedicineMinus))
            buyMedicineQuantity.setText("" + (Integer.parseInt(buyMedicineQuantity.getText()) - 1));
        else if (event.getSource().equals(buyMachinesMinus))
            buyMachinesQuantity.setText("" + (Integer.parseInt(buyMachinesQuantity.getText()) - 1));
        else if (event.getSource().equals(buyNarcoticsMinus))
            buyNarcoticsQuantity.setText("" + (Integer.parseInt(buyNarcoticsQuantity.getText()) - 1));
        else if (event.getSource().equals(buyRobotsMinus))
            buyRobotsQuantity.setText("" + (Integer.parseInt(buyRobotsQuantity.getText()) - 1));
        else if (event.getSource().equals(sellWaterMinus))
            sellWaterQuantity.setText("" + (Integer.parseInt(sellWaterQuantity.getText()) - 1));
        else if (event.getSource().equals(sellFursMinus))
            sellFursQuantity.setText("" + (Integer.parseInt(sellFursQuantity.getText()) - 1));
        else if (event.getSource().equals(sellFoodMinus))
            sellFoodQuantity.setText("" + (Integer.parseInt(sellFoodQuantity.getText()) - 1));
        else if (event.getSource().equals(sellOreMinus))
            sellOreQuantity.setText("" + (Integer.parseInt(sellOreQuantity.getText()) - 1));
        else if (event.getSource().equals(sellGamesMinus))
            sellGamesQuantity.setText("" + (Integer.parseInt(sellGamesQuantity.getText()) - 1));
        else if (event.getSource().equals(sellFirearmsMinus))
            sellFirearmsQuantity.setText("" + (Integer.parseInt(sellFirearmsQuantity.getText()) - 1));
        else if (event.getSource().equals(sellMedicineMinus))
            sellMedicineQuantity.setText("" + (Integer.parseInt(sellMedicineQuantity.getText()) - 1));
        else if (event.getSource().equals(sellMachinesMinus))
            sellMachinesQuantity.setText("" + (Integer.parseInt(sellMachinesQuantity.getText()) - 1));
        else if (event.getSource().equals(sellNarcoticsMinus))
            sellNarcoticsQuantity.setText("" + (Integer.parseInt(sellNarcoticsQuantity.getText()) - 1));
        else if (event.getSource().equals(sellRobotsMinus))
            sellRobotsQuantity.setText("" + (Integer.parseInt(sellRobotsQuantity.getText()) - 1));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
