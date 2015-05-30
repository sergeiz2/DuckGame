/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckgame;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Serge Zvenigorodsky
 */
public class TEMP extends Application {
    
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
        mainStage.setMinWidth(600);
        mainStage.setMinHeight(600);
        mainStage.centerOnScreen();
        
        AnchorPane root = new AnchorPane();
        //anchor to edges of mainStage.
        //root.setPadding(new Insets(50.0));
        
        gameScene = new Scene(root);
        mainStage.setScene(gameScene);
        
        //Image crosshairs = new Image("http://www.clker.com/cliparts/Z/k/h/u/K/N/black-crosshair-th.png");
        //gameScene.setCursor(new ImageCursor(crosshairs));
        gameScene.setCursor(Cursor.CROSSHAIR);
        
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(new EventHandler<ActionEvent>()
        { 
            @Override public void handle(ActionEvent e)
            {
                System.out.print("here");
                
                
                //popup with "exit to menu" and "keep playing" buttons 
            }
            
        }); 
//        pauseButton.setOnMouseEntered(new EventHandler()
//            {
//                @Override
//                public void handle(Event e)
//                {
//                    gameScene.setCursor(Cursor.HAND);
//                }
//            });
//        
//        pauseButton.setOnMouseEntered(new EventHandler()
//            {
//                @Override
//                public void handle(Event e)
//                {
//                    gameScene.setCursor(new ImageCursor(crosshairs));
//                }
//            });
        
        
        //Ground, sky, and bind to scene.
        Rectangle grass = new Rectangle(gameScene.getWidth()/2., gameScene.getHeight()/2., Paint.valueOf("green"));
        //grass.xProperty().bind(gameScene.xProperty());
        //grass.yProperty().bind(gameScene.yProperty());
        grass.widthProperty().bind(gameScene.widthProperty());
        grass.heightProperty().bind(gameScene.heightProperty());
        //Rectangle sky = new Rectangle(gameScene.getWidth(), gameScene.getHeight(), Paint.valueOf("green"));
        //sky.xProperty().bind(gameScene.xProperty());
        //sky.yProperty().bind(gameScene.yProperty());
        //sky.widthProperty().bind(gameScene.widthProperty());
        //sky.heightProperty().bind(gameScene.heightProperty());
        
        HBox buttonBox = new HBox(4.0);
        buttonBox.getChildren().add(pauseButton);
        root.getChildren().addAll(grass, /*sky,*/ buttonBox);
        AnchorPane.setRightAnchor(buttonBox, 5.0);
        AnchorPane.setBottomAnchor(buttonBox, 0.0);
        
        AnchorPane.setLeftAnchor(grass, 0.0);
        AnchorPane.setBottomAnchor(grass, 0.0);
        //AnchorPane.setLeftAnchor(sky, 0.0);
        //AnchorPane.setTopAnchor(sky, 0.0);
        
        //gameScene.getStylesheets().add(Menu.class.getResource("Menu.css").toExternalForm());
        
        System.out.println(gameScene.getWidth());
        mainStage.show();   
        System.out.println(gameScene.getWidth());
    }
}
