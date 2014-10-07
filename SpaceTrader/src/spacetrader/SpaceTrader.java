/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spacetrader.Ui.PlayerConfigurationController;
import spacetrader.Ui.WelcomeScreenController;
import spacetrader.Ui.GameController;
import spacetrader.Universe.Universe;

/**
 *
 * @author andikaputra
 */
public class SpaceTrader extends Application { 
    // Total number of scenes implemented in the game.
    public static final int NUMBER_OF_SCENES = 3;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeScreenParent = FXMLLoader.load(getClass().getResource("Ui/WelcomeScreen.fxml"));
        Parent playerConfigurationParent = FXMLLoader.load(getClass().getResource("Ui/PlayerConfiguration.fxml"));
        Parent gameParent = FXMLLoader.load(getClass().getResource("Ui/Game.fxml"));

        Scene[] allScenes = new Scene[NUMBER_OF_SCENES];
        allScenes[0] = new Scene(welcomeScreenParent);
        allScenes[1] = new Scene(playerConfigurationParent);
        allScenes[2] = new Scene(gameParent);
        
        WelcomeScreenController.passStageAndScene(stage, allScenes);
        PlayerConfigurationController.passStageAndScene(stage, allScenes);
        GameController.passStageAndScene(stage, allScenes);
        
        stage.setScene(allScenes[0]);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}