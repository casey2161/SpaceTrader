/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spacetrader.Ui.PlayerConfigurationController;
import spacetrader.Ui.WelcomeScreenController;
import spacetrader.Ui.GameController;
import spacetrader.Universe.SolarSystem;
import spacetrader.Universe.Planet;

/**
 *
 * @author andikaputra
 */
public class SpaceTrader extends Application {
    // Object instances in the game.
    private static Player player;
    private static Ship ship;
    private static SolarSystem[] solarSystem;
    private static Planet planet;
    
    // Total number of scenes implemented in the game.
    public static final int NUMBER_OF_SCENES = 9;
    
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

    public static void setPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public static void setShip(Ship newShip) {
        ship = newShip;
    }

    public static void setSolarSystem(SolarSystem[] newSolarSystem) {
        solarSystem = newSolarSystem;
    }

    public static void setPlanet(Planet newPlanet) {
        planet = newPlanet;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Ship getShip() {
        return ship;
    }

    public static SolarSystem[] getSolarSystem() {
        return solarSystem;
    }

    public static Planet getPlanet() {
        return planet;
    }
}
