/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckgamegui;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
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
        mainStage.setMinWidth(700);
        mainStage.setMinHeight(500);
        mainStage.centerOnScreen();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(25, 10, 25, 10));
        
        
        //MENUSCENE
        menuScene = new Scene(grid);
        mainStage.setScene(menuScene);
        Text menuTitle = new Text("Menu  ");
        //menu title
        menuTitle.setId("menu");
        grid.add(menuTitle, 25, 0);
        //menu labels
        Label gun = new Label("Gun");
        gun.setId("submenu");
        grid.add(gun, 25, 10);
        
        Label shot = new Label("Shot");
        shot.setId("submenu");
        grid.add(shot, 38, 10);
        
        Label difficulty = new Label("Difficulty");
        difficulty.setId("submenu");
        grid.add(difficulty, 50, 10);
        
        //menu drop-down lists (ChoiceBox)es
        ChoiceBox chooseGunType = new ChoiceBox();
        ObservableList<String> gunList;
        gunList = FXCollections.observableArrayList("Double-barrel" );
        chooseGunType.setItems(gunList);
        chooseGunType.getSelectionModel().selectFirst();
        
        ChoiceBox chooseGauge = new ChoiceBox();
        ObservableList<String> gaugeList;
        gaugeList = FXCollections.observableArrayList("20" );
        chooseGauge.setItems(gaugeList);
        chooseGauge.getSelectionModel().selectFirst();
        
        ChoiceBox chooseChoke = new ChoiceBox();
        ObservableList<String> chokeList;
        chokeList = FXCollections.observableArrayList("-choke-" );
        chooseChoke.setItems(chokeList);
        chooseChoke.getSelectionModel().selectFirst();
        
        TextField chooseShotSize = new TextField("-shot size-");
        chooseShotSize.setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
             @Override
             public void handle(MouseEvent me)
             {
                 if(me.getEventType().equals(MouseEvent.MOUSE_CLICKED))
                 {
                     //chooseShotSize = new TextField(""); <---How can I do this?
                 }
             }

        });
        Text shotSizeInstructs = new Text ("*Please enter the decimal equivalent.");
        shotSizeInstructs.setId("instructions");
        
        ChoiceBox chooseShotMaterial = new ChoiceBox();
        ObservableList<String> materialList;
        materialList = FXCollections.observableArrayList("Lead" );
        chooseShotMaterial.setItems(materialList);
        chooseShotMaterial.getSelectionModel().selectFirst();
        
        ChoiceBox chooseDifficulty = new ChoiceBox();
        ObservableList<String> difficultyList;
        difficultyList = FXCollections.observableArrayList("Easy" );
        chooseDifficulty.setItems(difficultyList);
        chooseDifficulty.getSelectionModel().selectFirst();
        
        Button okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>()
        { //figurethisout.
            @Override public void handle(ActionEvent e)
            {
                if(checkInputs())
                    getInputs();
            }
            
            private boolean checkInputs() //Size "B" and greater shot is not possible. Buckshot is not possible.
            {
                try
                {
                    if (!(Double.parseDouble(chooseShotSize.getText().trim()) % .5 == 0 && 
                          Double.parseDouble(chooseShotSize.getText().trim()) >= 0 &&
                          Double.parseDouble(chooseShotSize.getText().trim()) <= 12))
                    {
                        return showAlert("Shot size must be between 0" + "\n" +
                                  "and 12, (inclusive) and be a factor of 1/2.");
                    }
                }
                
                catch (NullPointerException e)
                {
                    return showAlert("Please specify a shot size.");
                }
                
                catch (NumberFormatException e)
                {
                    return showAlert("Please only use numerical characters" + "\n" +
                              "when specifying a shot size.");
                }
                
                return true;
            }
            
            private boolean showAlert(String text)
            {
                Alert wrongShotSize = new Alert(AlertType.ERROR);
                wrongShotSize.setTitle("Not a valid Shot size");
                wrongShotSize.setContentText(text);
                wrongShotSize.showAndWait();
                return false;
            }
            
            private void getInputs()
            {
                
                String gunType;
                int gauge;
                String choke;
                double shotSize;
                String shotMaterial;
                int difficulty;
                
                gunType = chooseGunType.getSelectionModel().getSelectedItem().toString();
                gauge = Integer.parseInt(chooseGauge.getSelectionModel().getSelectedItem().toString());
                choke = chooseChoke.getSelectionModel().getSelectedItem().toString();
                shotSize = Double.parseDouble(chooseShotSize.getText());
                shotMaterial = chooseShotMaterial.getSelectionModel().getSelectedItem().toString();
                difficulty = chooseDifficulty.getSelectionModel().getSelectedIndex();
                
                Runner runner;
                runner = new Runner(gunType, gauge, choke, shotSize, shotMaterial, difficulty);
            }
        });
        
        grid.add(chooseGunType, 25, 17);
        grid.add(chooseGauge, 25, 19);
        grid.add(chooseChoke, 25, 27);
        grid.add(chooseShotSize, 38, 17);
        grid.add(shotSizeInstructs, 38, 18);
        grid.add(chooseShotMaterial, 38, 19);
        grid.add(chooseDifficulty, 50, 17);
        grid.add(okButton, 50, 70);
        
        menuScene.getStylesheets().add
        (DuckGameGUI.class.getResource("DuckGameGUI.css").toExternalForm());
        
        mainStage.show();   
    }
}
