/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author andikaputra
 */
public class WelcomeScreenController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;
    
    
    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
        stage.setScene(allScenes[1]);
    }
    
    @FXML
    private void handleLoadGameButtonAction(ActionEvent event) {
        System.out.println("Loaded game has started."); // Replace later.
    }
    
    @FXML
    private void quitAction(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
    
}
