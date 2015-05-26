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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
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
        
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(new EventHandler<ActionEvent>()
        { 
            @Override public void handle(ActionEvent e)
            {
                //popup with "exit to menu" and "keep playing" buttons 
            }
            
        });
        
        //Ground, sky, and bind to scene.
        
        Rectangle grass = new Rectangle(gameScene.getWidth(), gameScene.getHeight(), Paint.valueOf("blue"));
        grass.xProperty().bind(gameScene.xProperty());
        grass.yProperty().bind(gameScene.yProperty());
        grass.widthProperty().bind(gameScene.widthProperty());
        grass.heightProperty().bind(gameScene.heightProperty());
        Rectangle sky = new Rectangle(gameScene.getWidth()/(1.6), gameScene.getHeight()/(1.6), Paint.valueOf("green"));
        sky.xProperty().bind(gameScene.xProperty());
        sky.yProperty().bind(gameScene.yProperty());
        sky.widthProperty().bind(gameScene.widthProperty());
        sky.heightProperty().bind(gameScene.heightProperty());
        
        grid.add(grass, 1, 1);
        grid.add(sky, 1, 1);
        grid.add(pauseButton, (int)((grid.getWidth()-6.0)*2.0), (int)((grid.getHeight()-6.0)*2.0));
        
        //gameScene.getStylesheets().add(Menu.class.getResource("Menu.css").toExternalForm());
        
        mainStage.show();   
    }
}
