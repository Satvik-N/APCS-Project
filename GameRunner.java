import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import java.awt.Rectangle;
import java.util.ArrayList;


/**
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * 
 * Class GameRunner
 * Includes all GUI parts
 */


public class GameRunner extends Application 
{
    // double to hold the speed of movement of the character
    static int moveSpeed = 10;
    // will hold the size of the window
    static int windowX, windowY;
    // border around the edge where player cannot travel
    static final int BORDER = 20;

    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    @Override
    public void start(Stage theStage) 
    {
        // returns the screen size as a Rectangle2D
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        // save the width and height of the window and scale it by 66%
        windowX = (int)((double)(bounds.getWidth() * 2) / 3);
        windowY = (int)((double)(bounds.getHeight() * 2) / 3);

        Board b = new Board();

        // create a VBox to organize the other nodes
        VBox vb = new VBox(20);

        // Group to hold the children
        Group r1 = new Group();
        // Scene with the start menu
        Scene startScreen = new Scene(r1);
        // make a new borderpane to organize buttons
        BorderPane bp = new BorderPane();
        
        // put the screen on the stage
        theStage.setScene(startScreen);

        // Button to start the game
        Button startB = new Button("Start");
        // Button to start the instructions
        Button instB = new Button("Instructions");
        
        // add the buttons to the VBox
        vb.getChildren().addAll(startB, instB);

        bp.setCenter(vb);
        bp.setTop(new Label("Welcome to Survivor"));
        
        // add the VBox to the scene
        r1.getChildren().add(bp);

        //r1.getChildren().add(startB);
        //r1.getChildren().add(instB);

        
        // When the start button is pressed
        startB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // Close the menu window
                    theStage.close();
                    // create a new window
                    Stage game = new Stage();
                    // set the window title
                    game.setTitle("Survivor");
                    // create the top of the nodes
                    Group root = new Group();
                    // create a new scene
                    Scene theScene = new Scene(root);
                    // set the scene to the window
                    game.setScene(theScene);

                    // create a canvas for the game
                    Canvas c = new Canvas(windowX, windowY);
                    // add canvas to group
                    root.getChildren().add(c);

                    // create a graphics context
                    GraphicsContext gc = c.getGraphicsContext2D();

                    // make two new images
                    // person image
                    Image pImage = new Image("Person.jpeg");
                    // map image
                    Image map = new Image("FakeMap.gif");

                    // create a player
                    Player p = new Player();
                    // set size of player
                    p.setWidthAndHeight(windowX /80.0, windowY / 30.0);

                    // Rectangle with the size of the map in it
                    Rectangle mapBox = new Rectangle((int)map.getWidth(), (int)map.getHeight());

                    // holds the inputs
                    ArrayList<String> input = new ArrayList<String>();

                    // when a key is pressed
                    theScene.setOnKeyPressed(
                        new EventHandler<KeyEvent>()
                        {
                            public void handle(KeyEvent e)
                            {
                                // keycode
                                String code = e.getCode().toString();

                                // only add once... prevent duplicates
                                if (!input.contains(code))
                                    input.add(code);
                            }
                        }
                    );

                    // when the key is released
                    theScene.setOnKeyReleased(
                        new EventHandler<KeyEvent>()
                        {
                            public void handle(KeyEvent e)
                            {
                                // remove code from arraylist
                                String code = e.getCode().toString();
                                input.remove(code);
                            }
                        }
                    );

                    // make a new AnimationTimer 
                    new AnimationTimer()
                    {
                        public void handle(long currentNanoTime)
                        {
                            // refresh the canvas
                            gc.setFill(new Color(0, 0, 0, 0));
                            gc.fillRect(0, 0, windowX, windowY);

                            // if the keypressed is LEFT, RIGHT, DOWN, or UP
                            // and the player will not move out of the board
                            // move the player to the desired location
                            if(input.contains("LEFT") && p.getX() >= moveSpeed + BORDER)
                                p.move(p.getX() - moveSpeed, p.getY());
                            else
                            if(input.contains("RIGHT") && p.getX() <= windowX - p.getWidth() - moveSpeed - BORDER)
                                p.move(p.getX() + moveSpeed, p.getY());
                            else
                            if(input.contains("DOWN") && p.getY() <= windowY - p.getHeight() - moveSpeed - BORDER)
                                p.move(p.getX(), p.getY() + moveSpeed);
                            else
                            if(input.contains("UP") && p.getY() >= moveSpeed + BORDER)
                                p.move(p.getX(), p.getY() - moveSpeed);

                    
                            // draw the map and the players again        
                            gc.drawImage(map, 0, 0, windowX, windowY);
                            gc.drawImage(pImage, p.getX(), p.getY(), p.getWidth(), p.getHeight());
                        }
                    }.start();

                    // if(p.isAtObstacle())
                    // {

                        // Group g3 = new Group();
                        // Scene pop = new Scene(g3);
                        // Stage popup = new Stage();
                        // VBox vb2 = new VBox();
                        // HBox hb = new HBox();

                        // Text obstacle = new Text(p.getObstacle().toString());
                        // Button attackB = new Button("Attack");
                        // Text damageT = new Text("" + p.getDamage());

                        // hb.getChildren().addAll(attackB, damageT);

                        // vb2.getChildren().add(hb);

                        // g3.getChildren().add(vb2);
                        // popup.showAndWait();
                    // }

                    // show the window with the game
                    game.show();

                }
            });

        // when the instructions button is pressed
        instB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // close the menu
                    theStage.close();

                    // create a new group of nodes
                    Group instG = new Group();
                    // make a new window
                    Stage instStage = new Stage();

                    // set the title of the window
                    instStage.setTitle("Instructions");

                    // create a VBox to organize the texts
                    VBox textVB = new VBox();

                    // button to go back to the main menu
                    Button backB = new Button("Back");

                    // create and add scene with instructions
                    Scene instScene = new Scene(instG);
                    instStage.setScene(instScene);

                    // label the window
                    Label title = new Label("Instructions:");
                    // create two 'paragraphs'
                    Text p1 = new Text(" 1 ");
                    Text p2 = new Text(" 2 ");

                    // add everything to VBox
                    textVB.getChildren().addAll(title, p1, p2, backB);

                    // add VBox to window
                    instG.getChildren().add(textVB);

                    // when the back button is pressed
                    backB.setOnAction(new EventHandler<ActionEvent>()
                        {
                            @Override public void handle(ActionEvent e)
                            {
                                // close instructions window
                                instStage.close();
                                // show the main menu window
                                theStage.show();
                            }
                        }
                    );

                    // show the instructions window
                    instStage.show();
                }
            });

        // show the main menu window
        theStage.show();
    }
}

