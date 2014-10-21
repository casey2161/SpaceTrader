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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;

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
        stage.setScene(allScenes[1]);
    }
    
    @FXML
    private void handleLoadGameButtonAction(ActionEvent event) {
        System.out.println("Load Game feature has not been implemented yet."); // Replace later.
    }
    
    @FXML
    private void quitAction(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void handleMouseMoved(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double imageX = bgImage.getX();
        double imageY = bgImage.getY();
        if (x <= 180 || x >= -180) {
            bgImage.setX(-x + (x/5));
        } 
        if (y <= 200 || y >= -100) {
            bgImage.setY(-y + (y/5));
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
