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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;
import javafx.stage.FileChooser;
import spacetrader.Player;
import spacetrader.SpaceTrader;
import spacetrader.Universe.Universe;

/**
 *
 * @author andikaputra
 */
public class WelcomeScreenController implements Initializable {
    private static Stage stage;
    private static Scene[] allScenes;
    @FXML private ImageView bgImage;
    @FXML private Button fontButton;
    @FXML private Button fontButton2;
    @FXML private Button fontButton3;
    
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
    
    @FXML
    private void handleMouseMoved(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double imageX = 150;
        double imageY = 0;
        if (x <= 360 || x >= 0) {
            if (imageX >= -316.00 || imageX <= 316.00) {
                bgImage.setX(imageX-(x/1.13));
                imageX = bgImage.getX();
            }
        } 
        if (y <= 640 || y >= 0) {
            bgImage.setY(imageY-(y/12.32));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Reflection reflection = new Reflection();
        fontButton.setEffect(reflection);
        fontButton2.setEffect(reflection);
        fontButton3.setEffect(reflection);
    }

    public static void passStageAndScene(Stage mainStage, Scene[] scenes) {
        stage = mainStage;
        allScenes = scenes;
    }
    
}
