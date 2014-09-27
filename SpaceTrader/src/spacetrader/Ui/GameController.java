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

    @FXML private Button saveGame;
    @FXML private Button loadGame;
    @FXML private Button endGame;
    @FXML private Button quit;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
}
