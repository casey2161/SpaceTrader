/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.Ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import spacetrader.Player;
import spacetrader.SpaceTrader;
import spacetrader.Universe.Universe;

/**
 *
 * @author andikaputra
 */
public class WelcomeScreenController implements Initializable {
    
    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
        SpaceTrader.stage.setScene(SpaceTrader.allScenes[1]);
    }
    
    @FXML
    private void handleLoadGameButtonAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(SpaceTrader.stage);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Universe.setInstance((Universe) ois.readObject());
            Player.setInstance((Player) ois.readObject());
            SpaceTrader.stage.setScene(SpaceTrader.allScenes[2]);
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
}
