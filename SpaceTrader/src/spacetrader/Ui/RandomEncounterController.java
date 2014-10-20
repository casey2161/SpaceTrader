/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import spacetrader.SpaceTrader;
import spacetrader.Ship;
import spacetrader.Player;


/**
 * FXML Controller class
 *
 * @author andikaputra
 */
public class RandomEncounterController implements Initializable {
    
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button back;
    @FXML private Text title;
    @FXML private Text type;
    @FXML private Text you;
    @FXML private Text message;
    @FXML private ProgressBar youBar;
    @FXML private ProgressBar enemyBar;
    @FXML private ImageView logo;
    
    private static Ship enemy;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResourceAsStream("Warning.png"));
        logo.setImage(image);
    }
    
    public static void initializeEncounter(Ship ship) {
        enemy = ship;
    }


    @FXML
    private void encounter(MouseEvent event) {
        if (enemy.getName().equals("Pirate")) {
            encounterPirate();
        } else if (enemy.getName().equals("Police")) {
            encounterPolice();
        }
    }
    
    @FXML
    private void attackAction(ActionEvent event) {
        Player.getInstance().ship().dealDamage(enemy);
        enemy.dealDamage(Player.getInstance().ship());
        youBar.setProgress(((double) Player.getInstance().ship().getHull())
                / Player.getInstance().ship().getMaxHull());
        enemyBar.setProgress(((double) enemy.getHull()) / enemy.getMaxHull());
        type.setVisible(true);
        you.setVisible(true);
        youBar.setVisible(true);
        enemyBar.setVisible(true);
        message.setText("You have decided to fight the " + enemy.getName() + "!");
        
        if (Player.getInstance().ship().isDestroyed()) {
            SpaceTrader.stage.setScene(SpaceTrader.allScenes[4]);
        } else if (enemy.isDestroyed()) {
            finish("You have defeated the enemy.");
        }
    }
    
    @FXML
    private void fleeAction(ActionEvent event) {
        if (Math.random() >= 0.5) {
            finish("You successfully fled from your enemy.");
        } else {
            enemy.dealDamage(Player.getInstance().ship());
            youBar.setProgress(((double) Player.getInstance().ship().getHull())
                    / Player.getInstance().ship().getMaxHull());
            type.setVisible(true);
            you.setVisible(true);
            youBar.setVisible(true);
            enemyBar.setVisible(true);
            message.setText("You attempted to flee. However, the " + enemy.getName()
                    + " is attacking your ship!");
        
            if (Player.getInstance().ship().isDestroyed()) {
                SpaceTrader.stage.setScene(SpaceTrader.allScenes[4]);
            } else if (enemy.isDestroyed()) {
                finish("You have defeated the enemy.");
            }
        }
    }
    
    @FXML
    private void submitOrSurrenderAction(ActionEvent event) {
        if (enemy.getName().equals("Pirate")) {
            Player.getInstance().ship().emptyCargo();
            finish("The pirate has taken away all of your cargos.");
        } else if (enemy.getName().equals("Police")) {
            if (Player.getInstance().ship().getAmount("Firearms") == 0
                    && Player.getInstance().ship().getAmount("Narcotics") == 0) {
                finish("The police couldn't find any illegal cargo on your ship."
                        + " They let you go.");
            } else {
                int count = Player.getInstance().ship().getAmount("Firearms")
                        + Player.getInstance().ship().getAmount("Narcotics");
                Player.getInstance().ship().remove("Firearms",
                        Player.getInstance().ship().getAmount("Firearms"));
                Player.getInstance().ship().remove("Narcotics",
                        Player.getInstance().ship().getAmount("Narcotics"));
                Player.getInstance().subtractMoney(100 * count);
                finish("The police found some firearms and/or narcotics on your ship."
                        + " They took away the illegal cargos and fined you for 100 cr * the number of confiscated goods");
            }
        }
    }
    
    @FXML
    private void bribeAction(ActionEvent event) {
        Player.getInstance().subtractMoney(Player.getInstance().money() / 2);
        finish("You bribed the police by paying them half of your total money.");
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        title.setText("You encounter a Ship!");
        Image image = new Image(getClass().getResourceAsStream("Warning.png"));
        logo.setImage(image);
        youBar.setProgress(1.0);
        enemyBar.setProgress(1.0);
        message.setText("");
        logo.setDisable(false);
        back.setVisible(false);
        SpaceTrader.stage.setScene(SpaceTrader.allScenes[2]);
    }
    
    
    
    private void encounterPirate() {
        Image image = new Image(getClass().getResourceAsStream("Pirate.png"));
        logo.setImage(image);
        logo.setDisable(true);
        title.setText("You encounter a " + enemy.getName() + "!");
        type.setText(enemy.getName());
        button1.setText("Attack");
        button1.setVisible(true);
        button2.setText("Flee");
        button2.setVisible(true);
        button3.setText("Surrender");
        button3.setVisible(true);
        message.setText("A pirate ship is demanding you to hand over your cargos.");
        message.setVisible(true);
        youBar.setProgress(1.0);
        enemyBar.setProgress(1.0);
    }
    
    private void encounterPolice() {
        Image image = new Image(getClass().getResourceAsStream("Police.png"));
        logo.setImage(image);
        logo.setDisable(true);
        title.setText("You encounter a " + enemy.getName() + "!");
        type.setText(enemy.getName());
        button1.setText("Attack");
        button1.setVisible(true);
        button2.setText("Flee");
        button2.setVisible(true);
        button3.setText("Submit");
        button3.setVisible(true);
        button4.setVisible(true);
        message.setText("A police ship has ordered you to submit to a cargo inspection.");
        message.setVisible(true);
        youBar.setProgress(1.0);
        enemyBar.setProgress(1.0);
    }
    
    private void finish(String message) {
        type.setVisible(false);
        you.setVisible(false);
        youBar.setVisible(false);
        enemyBar.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        back.setVisible(true);
        this.message.setText(message);
    }
}
