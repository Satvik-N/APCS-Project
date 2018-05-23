import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.awt.Rectangle;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import java.util.ArrayList;


/**
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * 
 * Class GameRunner
 * Includes all GUI parts
 */



// Animation of Earth rotating around the sun. (Hello, world!)
public class GameRunner extends Application 
{
    static double moveSpeed = 5;
    static double windowX, windowY;
    
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        windowX = bounds.getWidth() * 2.0 / 3;
        windowY = bounds.getHeight() * 2.0 / 3;
        
        VBox vb = new VBox(10);
        
        Group r1 = new Group();
        Scene startScreen = new Scene(r1);
        Canvas startC = new Canvas(windowX / 5, windowY / 5);
        theStage.setScene(startScreen);
        
        Button startB = new Button("Start");
        Button instB = new Button("Instructions");
        
        // r1.getChildren().add(startC);
        
        vb.getChildren().addAll(startB, instB);
        
        r1.getChildren().add(vb);
        
        //r1.getChildren().add(startB);
        //r1.getChildren().add(instB);
        
        
        
        
        startB.setOnAction(new EventHandler<ActionEvent>()
        {
        @Override public void handle(ActionEvent e)
        {
            
            theStage.close();
            
            Stage game = new Stage();
            
            game.setTitle("Survivor");
            Group root = new Group();
            Scene theScene = new Scene(root);
            game.setScene(theScene);
            
            Canvas c = new Canvas(windowX, windowY);
            root.getChildren().add(c);
            
            
            GraphicsContext gc = c.getGraphicsContext2D();
            
            Image pImage = new Image("Person.jpeg");
            Image map = new Image("FakeMap.gif");
            
            Player p = new Player();
            p.move(0,0);
            p.setWidthAndHeight(windowX /80.0, windowY / 30.0);
            
            Rectangle mapBox = new Rectangle((int)map.getWidth(), (int)map.getHeight());
            
            ArrayList<String> input = new ArrayList<String>();
            
            
            theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
     
                        // only add once... prevent duplicates
                        if (!input.contains(code))
                            input.add(code);
                    }
                }
            );
     
            theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                }
            );
            
            
                
            new AnimationTimer()
            {
                public void handle(long currentNanoTime)
                {
                    gc.setFill(new Color(0, 0, 0, 0));
                    gc.fillRect(0, 0, windowX, windowY);
                    
                    if(input.contains("LEFT") && p.getX() >= moveSpeed)
                    {
                        p.move(p.getX() - moveSpeed, p.getY());
                    } else
                        if(input.contains("RIGHT") && p.getX() <= windowX - p.getWidth() - moveSpeed)
                        {
                            p.move(p.getX() + moveSpeed, p.getY());
                        } else
                            if(input.contains("DOWN") && p.getY() <= windowY - p.getHeight() - moveSpeed)
                            {
                                p.move(p.getX(), p.getY() + moveSpeed);
                            } else
                                if(input.contains("UP") && p.getY() >= moveSpeed)
                                {
                                    p.move(p.getX(), p.getY() - moveSpeed);
                                }
                    
                    
                                
                    gc.drawImage(map, 0, 0, windowX, windowY);
                    gc.drawImage(pImage, p.getX(), p.getY(), p.getWidth(), p.getHeight());
                }
            }.start();
         
            game.show();
            
        }
        });
        
        instB.setOnAction(new EventHandler<ActionEvent>()
        {
        @Override public void handle(ActionEvent e)
        {
            
            theStage.close();
            
            Group instG = new Group();
            Stage instStage = new Stage();
            
            instStage.setTitle("Instructions");
            
            VBox textVB = new VBox();
            
            Button backB = new Button("Back");
            
            Scene instScene = new Scene(instG);
            instStage.setScene(instScene);
            
            Label title = new Label("Instructions:");
            Text p1 = new Text(" 1  ");
            Text p2 = new Text(" 2  ");
            
            textVB.getChildren().addAll(title, p1, p2, backB);
            
            instG.getChildren().add(textVB);
            
            backB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    instStage.close();
                    theStage.show();
                }
            }
            );
            
        
            instStage.show();
        }
        });
        
        theStage.show();
    }
}