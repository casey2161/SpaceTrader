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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import spacetrader.Player;

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class PlayerConfigurationController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;

    @FXML private TextField playerName;
    @FXML private Text startFailed;
    @FXML private Text skillPointsRemaining;
    @FXML private Text pilot;
    @FXML private Text fighter;
    @FXML private Text trader;
    @FXML private Text engineer;
    @FXML private Button addPilot;
    @FXML private Button addFighter;
    @FXML private Button addTrader;
    @FXML private Button addEngineer;
    @FXML private Button reset;
    @FXML private Button startNewGame;
    
    @FXML
    private void addPilotAction(ActionEvent event) {
        int currentText = Integer.parseInt(pilot.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText++;
        currentPoints--;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        pilot.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText >= 10 || currentPoints <= 0) {
            addPilot.setVisible(false);
            if (currentPoints <= 0) {
                addFighter.setVisible(false);
                addTrader.setVisible(false);
                addEngineer.setVisible(false);
            }
        }
    }
    
    @FXML
    private void addFighterAction (ActionEvent event) {
        int currentText = Integer.parseInt(fighter.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText++;
        currentPoints--;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        fighter.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText >= 10 || currentPoints <= 0) {
            addFighter.setVisible(false);
            if (currentPoints <= 0) {
                addPilot.setVisible(false);
                addTrader.setVisible(false);
                addEngineer.setVisible(false);
            }
        }
    }
    
    @FXML
    private void addTraderAction(ActionEvent event) {
        int currentText = Integer.parseInt(trader.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText++;
        currentPoints--;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        trader.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText >= 10 || currentPoints <= 0) {
            addTrader.setVisible(false);
            if (currentPoints <= 0) {
                addFighter.setVisible(false);
                addPilot.setVisible(false);
                addEngineer.setVisible(false);
            }
        }
    }
    
    @FXML
    private void addEngineerAction(ActionEvent event) {
        int currentText = Integer.parseInt(engineer.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText++;
        currentPoints--;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        engineer.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText >= 10 || currentPoints <= 0) {
            addEngineer.setVisible(false);
            if (currentPoints <= 0) {
                addFighter.setVisible(false);
                addTrader.setVisible(false);
                addPilot.setVisible(false);
            }
        }
    }
    
    @FXML
    private void resetAction(ActionEvent event) {
        skillPointsRemaining.setText("16");
        pilot.setText("1");
        fighter.setText("1");
        trader.setText("1");
        engineer.setText("1");
        addPilot.setVisible(true);
        addFighter.setVisible(true);
        addTrader.setVisible(true);
        addEngineer.setVisible(true);
        
    }
    
    @FXML
    private void startNewGameAction(ActionEvent event) {
        if(!skillPointsRemaining.getText().equals("0") || playerName.getText().equals("")) {
            startFailed.setVisible(true);
        } else {
            Player player = new Player (playerName.getText(), 1, Integer.parseInt(pilot.getText()), 
            Integer.parseInt(fighter.getText()), Integer.parseInt(trader.getText()),
            Integer.parseInt(engineer.getText()));
            System.out.println("New game has started."); // Replace later.
        }
    }
    
    @FXML
    private void quitAction(ActionEvent event) {
        System.exit(0);
    }
   
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
