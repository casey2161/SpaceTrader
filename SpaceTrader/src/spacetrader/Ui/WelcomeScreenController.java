/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import spacetrader.Player;
import spacetrader.Universe.Universe;

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
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Universe.setInstance((Universe) ois.readObject());
            Player.setInstance((Player) ois.readObject());
            stage.setScene(allScenes[2]);
        } catch(Exception e) {
            //Shouldn't happen
            e.printStackTrace();
        }
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
