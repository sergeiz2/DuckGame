/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckgamegui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Serge Zvenigorodsky
 */
public class Game extends Application {
    
    private Stage mainStage;
    private Scene gameScene;
   
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage mainStage) 
    {
        this.mainStage = mainStage;
        mainStage.setTitle("Duck Hunter 1.0.0 - Game");
        mainStage.setMinWidth(500);
        mainStage.setMinHeight(500);
        mainStage.centerOnScreen();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(25, 10, 25, 10));
        
        
        //GAMESCENE
        gameScene = new Scene(grid);
        mainStage.setScene(gameScene);
        
        Button shootButton = new Button("Shoot");
        shootButton.setOnAction(new EventHandler<ActionEvent>()
        { 
            @Override public void handle(ActionEvent e)
            {
                
            }
            
        });
        
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(new EventHandler<ActionEvent>()
        { 
            @Override public void handle(ActionEvent e)
            {
                //popup with "exit to menu" and "keep playing" buttons 
            }
            
        });
        
        grid.add(shootButton, (int)((grid.getWidth()-4.0)*2.0), (int)((grid.getHeight()-4.0)*2.0));
        grid.add(pauseButton, (int)((grid.getWidth()-6.0)*2.0), (int)((grid.getHeight()-6.0)*2.0));
        
        //gameScene.getStylesheets().add(Menu.class.getResource("Menu.css").toExternalForm());
        
        mainStage.show();   
    }
}
