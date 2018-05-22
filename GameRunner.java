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
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

// Animation of Earth rotating around the sun. (Hello, world!)
public class GameRunner extends Application 
{
    final double move = 5, windowX = 1600, windowY = 1000;
    
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle("Survivor");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        
        Canvas c = new Canvas(windowX, windowY);
        root.getChildren().add(c);
        
        GraphicsContext gc = c.getGraphicsContext2D();
        
        Image pImage = new Image("Person.jpeg");
        Image map = new Image("FakeMap.gif");
        
        Player p = new Player();
        p.move(0,0);
        p.setWidthAndHeight(30, 40);
        
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
                
                if(input.contains("LEFT") && p.getX() >= move)
                {
                    p.move(p.getX() - move, p.getY());
                } else
                    if(input.contains("RIGHT") && p.getX() <= windowX - p.getWidth() - move)
                    {
                        p.move(p.getX() + move, p.getY());
                    } else
                        if(input.contains("DOWN") && p.getY() <= windowY - p.getHeight() - move)
                        {
                            p.move(p.getX(), p.getY() + move);
                        } else
                            if(input.contains("UP") && p.getY() >= move + p.getHeight())
                            {
                                p.move(p.getX(), p.getY() - move);
                            }
                
                
                            
                gc.drawImage(map, 0, 0, windowX, windowY);
                gc.drawImage(pImage, p.getX(), p.getY(), p.getWidth(), p.getHeight());
            }
        }.start();
     
        theStage.show();
    }
}