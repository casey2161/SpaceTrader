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
import javafx.scene.input.MouseEvent;
import spacetrader.SpaceTrader;

/**
 * FXML Controller class
 *
 * @author 
 */
public class TravelTransitionController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickedAction(MouseEvent event) {
        SpaceTrader.stage.setScene(SpaceTrader.allScenes[2]);
    }
}
