/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckgame;

import java.util.Optional;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Serge Zvenigorodsky
 */
public class Game extends Application {
    
    private Stage mainStage;
    private Scene gameScene;
    private Runner runner;
    private long shootTime;
    private double duckXPos;
    private double duckYPos;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage mainStage) 
    {
        this.mainStage = mainStage;
        
        mainStage.setTitle("Duck Hunter 1.0.0 - Game");
        mainStage.setMinWidth(700);
        mainStage.setMinHeight(600);
        mainStage.centerOnScreen();
        
        AnchorPane root = new AnchorPane();
        //anchor to edges of mainStage.
        root.setPadding(new Insets(0));
        
        gameScene = new Scene(root);
        mainStage.setScene(gameScene);
        
        Image crosshair = new Image("http://www.clker.com/cliparts/Z/k/h/u/K/N/black-crosshair-th.png");
        gameScene.setCursor(new ImageCursor(crosshair, crosshair.getWidth()/2, crosshair.getHeight()/2));
        //gameScene.setCursor(Cursor.CROSSHAIR);
        
        //Ground, sky, and bind to scene.
        Rectangle sky = new Rectangle(0.0, 0.0, Paint.valueOf("blue"));
        sky.xProperty().bind(gameScene.xProperty());
        sky.yProperty().bind(gameScene.yProperty());
        sky.widthProperty().bind(gameScene.widthProperty());
        sky.heightProperty().bind(gameScene.heightProperty().multiply(1.6/2.6));
        Rectangle grass = new Rectangle(0.0, 0.0, Paint.valueOf("green"));
        grass.xProperty().bind(gameScene.xProperty());
        grass.yProperty().bind(gameScene.yProperty().add(sky.heightProperty().doubleValue()));
        grass.widthProperty().bind(gameScene.widthProperty());
        grass.heightProperty().bind(gameScene.heightProperty().divide(2.6));
        
        AnchorPane.setLeftAnchor(grass, 0.0);
        AnchorPane.setBottomAnchor(grass, 0.0);
        AnchorPane.setLeftAnchor(sky, 0.0);
        AnchorPane.setTopAnchor(sky, 0.0);
        
        Button pauseButton = new Button("Pause"); 
        pauseButton.setOnAction(new EventHandler<ActionEvent>()
        { 
            @Override public void handle(ActionEvent e)
            {
                final Stage dialog = new Stage();
                dialog.initOwner(mainStage);
                
                Button menuButton = new Button("Main Menu");
                Button quitButton = new Button("Quit");
                Button resumeButton = new Button("Resume");
                
                menuButton.setOnAction(new EventHandler<ActionEvent>()
                { 
                    @Override public void handle(ActionEvent e)
                    {
                        Alert menuAlert = new Alert(AlertType.CONFIRMATION);
                        menuAlert.setTitle("Exit to menu?");
                        menuAlert.setHeaderText("Are you sure you want to exit to the menu?");
                        menuAlert.setContentText("You will have to restart.");

                        Optional<ButtonType> result = menuAlert.showAndWait();
                        if (result.get() == ButtonType.OK)
                        {
                            Platform.runLater(new Runnable()
                            {
                                @Override
                                public void run()
                                {             
                                    mainStage.close();
                                    Menu newMenu = new Menu();
                                    newMenu.setRunner(runner);
                                    newMenu.start(new Stage());
                                }
                            });
                        }
                    }
                });
                
                quitButton.setOnAction(new EventHandler<ActionEvent>()
                { 
                    @Override public void handle(ActionEvent e)
                    {
                        Alert quitAlert = new Alert(AlertType.CONFIRMATION);
                        quitAlert.setTitle("Quit?");
                        quitAlert.setHeaderText("Are you sure you want to quit?");
                        quitAlert.setContentText("This is a wonderful simulation that no sane person would \n ever quit. Do you still want to quit?");

                        Optional<ButtonType> result = quitAlert.showAndWait();
                        if (result.get() == ButtonType.OK)
                        {
                            Platform.exit();
                        }
                    }
                });
                
                resumeButton.setOnAction(new EventHandler<ActionEvent>()
                { 
                    @Override public void handle(ActionEvent e)
                    {
                        dialog.close();
                    }
                });
                
                VBox dialogVBox = new VBox(20, menuButton, quitButton, resumeButton);
                VBox.setMargin(menuButton, new Insets(20.0, 20.0, 10.0, 20.0));
                VBox.setMargin(quitButton, new Insets(10.0, 20.0, 10.0, 20.0));
                VBox.setMargin(resumeButton, new Insets(10.0, 20.0, 20.0, 20.0));
                
                Scene dialogScene = new Scene(dialogVBox);
                
                dialog.setScene(dialogScene);
                dialog.showAndWait();
            }
            
        }); 
//        pauseButton.setOnMouseEntered(new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent me)
//                {
//                    //gameScene.setCursor(Cursor.HAND);
//                    gameScene.setCursor(new ImageCursor(crosshair));
//                    System.out.print("entered");
//                }
//            });
//        
//        pauseButton.setOnMouseExited(new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent me)
//                {
//                    //gameScene.setCursor(Cursor.CROSSHAIR);
//                    gameScene.setCursor(new ImageCursor(crosshair));
//                    System.out.print("exited");
//                }
//            });
        
        HBox buttonBox = new HBox(4.0);
        buttonBox.getChildren().add(pauseButton);
        root.getChildren().addAll(grass, sky, buttonBox);
        
        AnchorPane.setRightAnchor(buttonBox, 20.0);
        AnchorPane.setBottomAnchor(buttonBox, 20.0);
        
        ImageView duckIV = new ImageView("http://96bda424cfcc34d9dd1a-0a7f10f87519dba22d2dbc6233a731e5.r41.cf2.rackcdn.com/gds/Mallard_Flying/Mallard_Flying_250x214.png");
        duckIV.setFitWidth(30);
        duckIV.setPreserveRatio(true);
        duckIV.setSmooth(true);
        root.getChildren().add(duckIV);
        
        //gameScene.getStylesheets().add(Menu.class.getResource("Menu.css").toExternalForm());
    
       AnimationTimer animationTimer = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                double xCoord = runner.getDuck().calcReferancePoint(now - runner.getDuckCreatedTime()).getX()*10; // multiplying by 10 to compensate for duck being too far.
                double zCoord = runner.getDuck().calcReferancePoint(now - runner.getDuckCreatedTime()).getZ()*10;
                duckXPos = xCoord;
                duckYPos = zCoord;
//                System.out.println("xCoord = " + xCoord + ", yCoord = " + zCoord);
                duckIV.setX(xCoord + 15);
                duckIV.setY(zCoord + 15);
                mainStage.show();
            }
        };
        animationTimer.start();
        
        gameScene.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override public void handle(MouseEvent e)
            {
                runner.fireGun(e.getSceneX(), e.getSceneY());
                shootTime = System.nanoTime();
                if (runner.getDuckFalls())
                {
                    System.out.println("HIT!!!!!!!");
                }
            }
        });
        
        mainStage.show();
        makeDucks(); // needs to happen after scene gets it's sizes.
    }
    
    public double getWindowWidth()
    {
        System.out.println("WIDTH OF SCREEN: "  + gameScene.getWidth());
        return gameScene.getWidth();
    }
    public double getWindowHeight()
    {
        System.out.println("HEIGHT OF SCREEN: " + gameScene.getHeight());
        return gameScene.getHeight();
    }
    public double getDuckXPos()
    {
        return duckXPos;
    }
    public double getDuckYPos()
    {
        return duckYPos;
    }
    public void setRunner(Runner runner)
    {
        this.runner = runner;
    }
    
    public void makeDucks()
    {
        runner.makeDucks();
    }
}