/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckgamegui;

import java.awt.Color;
import java.awt.Rectangle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Serge Zvenigorodsky
 */
public class DuckGameGUI extends Application 
{
    private Stage mainStage;
    private Scene menuScene;
    private Scene graphicsScene;
   
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage mainStage) 
    {
        this.mainStage = mainStage;
        mainStage.setTitle("Duck Hunter 1.0.0");
        mainStage.setMinWidth(550);
        mainStage.setMinHeight(400);
        mainStage.centerOnScreen();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        
        menuScene = new Scene(grid);
        mainStage.setScene(menuScene);
        Text menuTitle = new Text("Menu      ");
        menuTitle.setId("menu");
        grid.add(menuTitle, 25, 0);
        Label gun = new Label("Gun");
        Label shot = new Label("Shot");
        Label difficulty = new Label("Difficulty");
        grid.add(gun, 25, 10);
        grid.add(shot, 26, 10);
        grid.add(difficulty, 80, 10);
       
        menuScene.getStylesheets().add
        (DuckGameGUI.class.getResource("DuckGameGUI.css").toExternalForm());
        
        mainStage.show();   
    }
}
