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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    static final int moveSpeed = 1;
    // will hold the size of the window
    static int windowX, windowY;
    // border around the edge where player cannot travel
    static final int BORDER = 20;
    // size of player
    static double pWidth, pHeight;
    // Player
    static Player p;
    static int choice;

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
        windowY = (int)(bounds.getHeight());
        windowX = windowY;

        // create a VBox to organize the other nodes
        VBox vb = new VBox(20);

        // Group to hold the children
        Group r1 = new Group();
        // Scene with the start menu
        Scene startScreen = new Scene(r1);
        // make a new borderpane to organize buttons
        GridPane gp = new GridPane();
        
        // put the screen on the stage
        theStage.setScene(startScreen);

        // Button to start the game
        Button startB = new Button("   Start   ");
        // Button to start the instructions
        Button instB = new Button("How to play");
        // Button to show credits
        Button creditB = new Button("Credits");
        // make a welcome text
        Label welcome = new Label("Welcome to Survivor");
        
        // add the buttons to the VBox
        vb.getChildren().addAll(welcome, startB, instB, creditB);
        vb.setPrefWidth(windowX / 5);
        vb.setPrefHeight(windowY / 3);
        
        vb.setAlignment(Pos.CENTER);
        
        // add the VBox to the scene
        r1.getChildren().add(vb);

        // create a player
        p = new Player(" ");
        
        
        // set size of player
        pWidth = windowX /80.0;
        pHeight = windowY / 50.0;
        
        // When the start button is pressed
        startB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // start the game
                    startGame(theStage);
                }
            });
  
        // when the instructions button is pressed
        instB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // show the instructions page
                    showInstructions(theStage);
                }
            });
            
        // When the credits button is pressed
        creditB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // show credits
                    showCredits(theStage);
                }
            });

        // show the main menu window
        theStage.show();
    }
    
    private static void startGame(Stage theStage)
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
        Image map = new Image("map_finalfinal1.png");
    
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
    
                // if the key pressed is LEFT, RIGHT, DOWN, or UP
                // and the player will not move out of the board
                // move the player to the desired location
                if(input.contains("LEFT") && p.getLocation().getX() >= moveSpeed + BORDER)
                    p.move((int)p.getLocation().getX() - moveSpeed, (int)p.getLocation().getY());
                else
                    if(input.contains("RIGHT") && p.getLocation().getX() <= windowX - pWidth - moveSpeed - BORDER)
                        p.move((int)p.getLocation().getX() + moveSpeed, (int)p.getLocation().getY());
                    else
                        if(input.contains("DOWN") && p.getLocation().getY() <= windowY - pHeight - moveSpeed - BORDER)
                            p.move((int)p.getLocation().getX(), (int)p.getLocation().getY() + moveSpeed);
                        else
                            if(input.contains("UP") && p.getLocation().getY() >= moveSpeed + BORDER)
                                p.move((int)p.getLocation().getX(),(int)p.getLocation().getY() - moveSpeed);
    
        
                // draw the map and the players again        
                gc.drawImage(map, 0, 0, windowX, windowY);
                gc.drawImage(pImage, p.getLocation().getX(), p.getLocation().getY(), pWidth, pHeight);
            }
        }.start();
    
        // if(p.isAtObstacle())
        // {
            
        // }
    
        // show the window with the game
        game.show();

    }
    
    private static void showInstructions(Stage theStage)
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
        VBox textVB = new VBox(20);
        HBox pixHB = new HBox(10);

        // button to go back to the main menu
        Button backB = new Button("Back");

        // create and add scene with instructions
        Scene instScene = new Scene(instG);
        instStage.setScene(instScene);
        
        Image tim = new Image("map_finalfinal1.png");
        
        Canvas timSpace = new Canvas(windowX / 10, windowY / 10);
        GraphicsContext gc = timSpace.getGraphicsContext2D();
        
        gc.drawImage(tim, 0, 0, windowX / 10, windowY / 10);

        // label the window
        Label title = new Label("Instructions:");
        // create two 'paragraphs'
        Text p1 = new Text(" Don't die ");
        Text p2 = new Text(" Live ");

        
        pixHB.getChildren().addAll(p1, timSpace);
        
        // add everything to VBox
        textVB.getChildren().addAll(title, pixHB, p2, backB);
        textVB.setPrefWidth(windowX / 3);
        textVB.setPrefHeight(windowY / 3);
        
        textVB.setAlignment(Pos.CENTER_LEFT);
        
        
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
    
    private static void showCredits(Stage theStage)
    {
        theStage.close();
        
        // create a new group of nodes
        Group credG = new Group();
        // make a new window
        Stage credStage = new Stage();

        // set the title of the window
        credStage.setTitle("Credits");

        // create a VBox to organize the texts
        VBox textVB = new VBox(20);

        // button to go back to the main menu
        Button backB = new Button("Back");

        // create and add scene with instructions
        Scene credScene = new Scene(credG);
        credStage.setScene(credScene);

        // label the window
        Label title = new Label("Credits");
        // create two 'paragraphs'
        Text p1 = new Text(" 1 ");
        Text p2 = new Text(" 2 ");
        Text p3 = new Text(" 3 ");
        Text p4 = new Text(" 4 ");
        Text p5 = new Text(" 5 ");
        
        // add everything to VBox
        textVB.getChildren().addAll(title, p1, p2, p3, p4, p5, backB);
        textVB.setPrefWidth(windowX / 3);
        textVB.setPrefHeight(windowY / 3);
        
        textVB.setAlignment(Pos.CENTER_LEFT);
        
        
        // add VBox to window
        credG.getChildren().add(textVB);

        // when the back button is pressed
        backB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // close instructions window
                    credStage.close();
                    // show the main menu window
                    theStage.show();
                }
            }
        );

        // show the instructions window
        credStage.show();
    }
    
    // enteredNewBiome(Player player, Board board)
    // runIntoObstacle(Player player, Board board)
    // runIntoSupply(Player player, Board board)
    // randomGift(Player player, Board board)
    
    private static void encounter(Stage theStage)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        popup.setScene(pop);
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        
        Text obstacle = new Text("You encountered a "); //+ p.getObstacle().toString());
        
        Button counterB1 = new Button(" 1 "); // p.getObstacle().getOption1());
        Button counterB2 = new Button(" 2 "); // p.getObstacle().getOption2());
        
        vb2.getChildren().addAll(counterB1, counterB2);
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);

        
        
        // when the option 1 button is pressed
        counterB1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the first option
                // System.out.println("Op 1");
                choice = 1;
            }
        });
        
        counterB2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the second option
                // System.out.println("Op 2");
                choice = 2;
            }
        });
        
        // p.getObstacle().succeedOrFail(p);
        
        popup.showAndWait();
    }
}

