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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import spacetrader.Player;
import spacetrader.SpaceTrader;
import spacetrader.Universe.Planet;
import spacetrader.Universe.Universe;
 

/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class PlayerConfigurationController implements Initializable {
    @FXML private TextField playerName;
    @FXML private Text startFailed;
    @FXML private Text skillPointsRemaining;
    @FXML private Text pilot;
    @FXML private Text fighter;
    @FXML private Text trader;
    @FXML private Text engineer;
    @FXML private Text playerNameTitle;
    @FXML private Button addPilot;
    @FXML private Button addFighter;
    @FXML private Button addTrader;
    @FXML private Button addEngineer;
    @FXML private Button subtractPilot;
    @FXML private Button subtractFighter;
    @FXML private Button subtractTrader;
    @FXML private Button subtractEngineer;
    @FXML private Button reset;
    @FXML private Button startNewGame;
    
    public static boolean multiplayerMode;

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
        subtractPilot.setVisible(true);

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
    private void subtractPilotAction(ActionEvent event) {
        int currentText = Integer.parseInt(pilot.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText--;
        currentPoints++;

        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        pilot.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText <= 1) {
            subtractPilot.setVisible(false);
        }

        if (Integer.parseInt(pilot.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addPilot.setVisible(true);
        }
        if (Integer.parseInt(fighter.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addFighter.setVisible(true);
        }
        if (Integer.parseInt(trader.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addTrader.setVisible(true);
        }
        if (Integer.parseInt(engineer.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addEngineer.setVisible(true);
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
        subtractFighter.setVisible(true);

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
    private void subtractFighterAction(ActionEvent event) {
        int currentText = Integer.parseInt(fighter.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText--;
        currentPoints++;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        fighter.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText <= 1) {
            subtractFighter.setVisible(false);
        }
        
        if (Integer.parseInt(pilot.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addPilot.setVisible(true);
        }
        if (Integer.parseInt(fighter.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addFighter.setVisible(true);
        }
        if (Integer.parseInt(trader.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addTrader.setVisible(true);
        }
        if (Integer.parseInt(engineer.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addEngineer.setVisible(true);
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
        subtractTrader.setVisible(true);

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
    private void subtractTraderAction(ActionEvent event) {
        int currentText = Integer.parseInt(trader.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText--;
        currentPoints++;

        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        trader.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText <= 1) {
            subtractTrader.setVisible(false);
        }
        if (Integer.parseInt(pilot.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addPilot.setVisible(true);
        }
        if (Integer.parseInt(fighter.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addFighter.setVisible(true);
        }
        if (Integer.parseInt(trader.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addTrader.setVisible(true);
        }
        if (Integer.parseInt(engineer.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addEngineer.setVisible(true);
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
        subtractEngineer.setVisible(true);

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
    private void subtractEngineerAction(ActionEvent event) {
        int currentText = Integer.parseInt(engineer.getText());
        int currentPoints = Integer.parseInt(skillPointsRemaining.getText());
        currentText--;
        currentPoints++;
        
        String newText = String.valueOf(currentText);
        String newPoints = String.valueOf(currentPoints);
        engineer.setText(newText);
        skillPointsRemaining.setText(newPoints);

        if (currentText <= 1) {
            subtractEngineer.setVisible(false);
        }
        if (Integer.parseInt(pilot.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addPilot.setVisible(true);
        }
        if (Integer.parseInt(fighter.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addFighter.setVisible(true);
        }
        if (Integer.parseInt(trader.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addTrader.setVisible(true);
        }
        if (Integer.parseInt(engineer.getText()) < 10 && Integer
                .parseInt(skillPointsRemaining.getText()) > 0) {
            addEngineer.setVisible(true);
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
        subtractPilot.setVisible(false);
        subtractFighter.setVisible(false);
        subtractTrader.setVisible(false);
        subtractEngineer.setVisible(false); 
    }

    @FXML
    private void startNewGameAction(ActionEvent event) {
        Player.clearInstance();
        Universe.recreateInstance();
        if(!skillPointsRemaining.getText().equals("0") || playerName.getText()
                .equals("")) {
            startFailed.setVisible(true);
        } else {
            if (multiplayerMode && !Player.isPlayerTwo()) {
                Planet spawn = Universe.getInstance().getSolarSystem(0).getPlanet(0);
                Player.updateInstance(playerName.getText(), 1, Integer
                    .parseInt(pilot.getText()), 
                Integer.parseInt(fighter.getText()), Integer.parseInt(trader.getText()),
                Integer.parseInt(engineer.getText()), spawn);
                Player.setMultiplayer(true);
                Player.setPlayerTwo(true);

                playerNameTitle.setText("Second Player Name");
                skillPointsRemaining.setText("16");
                pilot.setText("1");
                fighter.setText("1");
                trader.setText("1");
                engineer.setText("1");
                addPilot.setVisible(true);
                addFighter.setVisible(true);
                addTrader.setVisible(true);
                addEngineer.setVisible(true);
                subtractPilot.setVisible(false);
                subtractFighter.setVisible(false);
                subtractTrader.setVisible(false);
                subtractEngineer.setVisible(false);
            } else if (multiplayerMode && Player.isPlayerTwo()) {
                Planet spawn = Universe.getInstance().getSolarSystem(0).getPlanet(0);
                Player.updateInstance(playerName.getText(), 1, Integer
                    .parseInt(pilot.getText()), 
                Integer.parseInt(fighter.getText()), Integer.parseInt(trader.getText()),
                Integer.parseInt(engineer.getText()), spawn);
                Player.setMultiplayer(true);
                Player.setPlayerTwo(false);
                SpaceTrader.stage.setScene(SpaceTrader.allScenes[2]);
            } else {
                Planet spawn = Universe.getInstance().getSolarSystem(0).getPlanet(0);
                Player.updateInstance(playerName.getText(), 1, Integer
                    .parseInt(pilot.getText()), 
                Integer.parseInt(fighter.getText()), Integer.parseInt(trader.getText()),
                Integer.parseInt(engineer.getText()), spawn);
                Player.setMultiplayer(false);
                Player.setPlayerTwo(false);
                SpaceTrader.stage.setScene(SpaceTrader.allScenes[2]);
            }
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        SpaceTrader.stage.setScene(SpaceTrader.allScenes[0]);
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
