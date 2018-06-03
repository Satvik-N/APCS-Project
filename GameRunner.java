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
    static final int moveSpeed = 4;
    // will hold the size of the window
    static int windowX, windowY;
    // border around the edge where player cannot travel
    static final int BORDER = 60;
    // size of player
    static double pWidth, pHeight;
    // Player
    static Player p;
    static int choice;
    static TimTheEnchanter tim;
    static String playerImage;
    static int scale;
    static String wol; 
    
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
        
        scale = (int)(windowX*0.9)/(200);
        
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
        p = new Player("  ");
        
        tim = new TimTheEnchanter();
        
        
        
        // When the start button is pressed
        startB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    choosePlayer(theStage);
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
    
    private static void choosePlayer(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g, windowX * 2 / 3, windowX * 1 / 3);
        
        popup.sizeToScene(); 
        
        Canvas c = new Canvas(s.getWidth() * 0.7, windowX / 5.5);
        
        
        
        theStage.close();
        
        VBox vb = new VBox(s.getWidth() / 15);
        vb.setPrefHeight(windowX / 10);
        
        
        HBox hb = new HBox(20);
        hb.setPrefHeight(c.getHeight());
        hb.setPrefWidth(c.getWidth());
        
        GraphicsContext gc = c.getGraphicsContext2D();
        
        Label title = new Label("CHOOSE YOUR PLAYER");
        Button pic1 = new Button("         n00b         ");
        Button pic2 = new Button("     Bill the Cat     ");
        Button pic3 = new Button("    The Lantsberger   ");
        Button pic4 = new Button("  Henry the Stressed  ");
        Button pic5 = new Button("  Zaphod Beeblebrox   ");
        
        Image bsp = new Image("Person.png");
        Image btc = new Image("bill the cat.png");
        Image l = new Image("mr. lantsberger.png");
        Image hs = new Image("henry.PNG");
        Image zb = new Image("Zaphod Beeblebrox.png");
        
        gc.drawImage(bsp, c.getWidth() * 0.05, c.getHeight() * 0.5, c.getWidth() / 9, c.getHeight() / 2.5);
        gc.drawImage(btc, c.getWidth() * 0.2, c.getHeight() * 0.5, c.getWidth() / 9, c.getHeight() / 2.5);
        gc.drawImage(l, c.getWidth() * 0.45, c.getHeight() * 0.5, c.getWidth() / 9, c.getHeight() / 2.5);
        gc.drawImage(hs, c.getWidth() * 0.7, c.getHeight() * 0.5, c.getWidth() / 9, c.getHeight() / 2.5);
        gc.drawImage(zb, c.getWidth() * 0.85, c.getHeight() * 0.5, c.getWidth() / 9, c.getHeight() / 2.5);
        
        hb.getChildren().addAll(pic1, pic2, pic3, pic4, pic5);
        vb.getChildren().addAll(title, hb);
        g.getChildren().addAll(c, vb);
        
        popup.setScene(s);
        
        popup.setTitle("Player");
        
        // When the pic1 button is pressed
        pic1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "Person.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic2 button is pressed
        pic2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "bill the cat.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic3 button is pressed
        pic3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "mr. lantsberger.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic4 button is pressed
        pic4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "henry.PNG";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic5 button is pressed
        pic5.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "Zaphod Beeblebrox.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        popup.show();
    }
    
    private static void startGame(Stage theStage)
    {
        System.out.println("hihihihi");
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
        Canvas c = new Canvas(windowX * .9, windowY * .9);
        
        // set size of player
        pWidth = windowX /40.0;
        pHeight = windowY / 20.0;
        
        HBox hb = new HBox(10);
        VBox vb = new VBox(20);
        
        hb.getChildren().addAll(c, vb);
        // add canvas to group
        root.getChildren().add(hb);
        
        Text health = new Text("\nHealth: " + p.getHealth() + "\n");
        Text wood = new Text("Wood: " + p.getWood());
        Text metal = new Text("Metal: " + p.getMetal());
        Text food = new Text("Food: " + p.getFood());
        Text water = new Text("Water: " + p.getWater());
        Text bAndA = new Text("Bow And Arrow: " + p.getBowAndArrow());
        Text armor = new Text("Armor: " + p.getArmor());
        Text pick = new Text("Pickaxe: " + p.getPickaxe());
        Text fireproof = new Text("Fire-Proof Shield: " + p.getFireProofShield());
        Text rope = new Text("Rope: " + p.getRope());
        Text spear = new Text("Spear: " + p.getSpear());
        
        Button craft = new Button("Craft");
        Button eat = new Button("Eat Food");
        Button drink = new Button("Drink");
        Button instruct = new Button("Instructions");
        vb.getChildren().addAll(health, wood, metal, food, water, bAndA, armor, pick, fireproof, rope, spear, craft, eat, drink, instruct);
        
        // create a graphics context
        GraphicsContext gc = c.getGraphicsContext2D();
    
        // make two new images
        // person image
        Image pImage = new Image(playerImage);
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
                    {
                        p.move((int)p.getLocation().getX() - moveSpeed, (int)p.getLocation().getY());
                        checkForStuff(game, p);
                    }
                    else
                        if(input.contains("RIGHT") && p.getLocation().getX() <= c.getWidth() - pWidth - moveSpeed - BORDER)
                        {
                            p.move((int)p.getLocation().getX() + moveSpeed, (int)p.getLocation().getY());
                            checkForStuff(game, p);
                        }
                        else
                            if(input.contains("DOWN") && p.getLocation().getY() <= c.getWidth() - pHeight - moveSpeed - BORDER)
                            {
                                p.move((int)p.getLocation().getX(), (int)p.getLocation().getY() + moveSpeed);
                                checkForStuff(game, p);
                            }
                            else
                                if(input.contains("UP") && p.getLocation().getY() >= moveSpeed + BORDER / 10.)
                                {
                                    p.move((int)p.getLocation().getX(),(int)p.getLocation().getY() - moveSpeed);
                                    checkForStuff(game, p);
                                }
        
                // draw the map and the players again        
                gc.drawImage(map, 0, 0, c.getWidth(), c.getWidth());
                if (p.playerBiome(p.getLocation()).toString().equals("desert"))
                    gc.drawImage(pImage, scale * p.getLocation().getX(), scale * p.getLocation().getY(), pWidth, pHeight);
                else
                    if (p.playerBiome(p.getLocation()).toString().equals("rainforest"))
                        gc.drawImage(pImage, scale * p.getLocation().getX(), scale * p.getLocation().getY() + c.getHeight()/2, pWidth, pHeight);
                    else
                        if (p.playerBiome(p.getLocation()).toString().equals("grassland"))
                            gc.drawImage(pImage, scale * p.getLocation().getX() + c.getHeight()/2, scale * p.getLocation().getY() + c.getHeight()/2, pWidth, pHeight);
                
                health.setText("\nHealth: " + p.getHealth() + "\n");
                wood.setText("Wood: " + p.getWood());
                metal.setText("Metal: " + p.getMetal());
                food.setText("Food: " + p.getFood());
                water.setText("Water: " + p.getWater());
                bAndA.setText("Bow And Arrow: " + p.getBowAndArrow());
                armor.setText("Armor: " + p.getArmor());
                pick.setText("Pickaxe: " + p.getPickaxe());
                fireproof.setText("Fire-Proof Shield: " + p.getFireProofShield());
                rope.setText("Rope: " + p.getRope());
                
            }
        }.start();
    
        // enteredNewBiome(Player player)
        // runIntoObstacle(Player player)
        // runIntoSupply(Player player)
        // randomGift(Player player)
        
        craft.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    showCraftMenu(theStage);
                }
            }
        );
        
        eat.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    try
                    {
                        p.addHealth(2);
                        p.subtractFood(10);
                    }
                    catch (IllegalArgumentException ex)
                    {
                        showErrorMessage(theStage, ex.toString());
                    }
                }
            }
        );
        
        drink.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    try
                    {
                        p.addHealth(1);
                        p.subtractWater(10);
                    }
                    catch (IllegalArgumentException ex)
                    {
                        showErrorMessage(theStage, ex.toString());
                    }
                }
            }
        );
        
        instruct.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // show the instructions page
                    showInstructionsOther(theStage);
                }
            });
        
        // show the window with the game
        game.show();
    }
    
    private static void checkForStuff(Stage theStage, Player p)
    {
        if(tim.runIntoObstacle(p) != null)
        {
            Obstacles ob = (Obstacles)tim.returnMaterial(p);
            String weapon = ob.weapon();
            theStage.close();
            atObstacle(theStage, tim.runIntoObstacle(p), weapon);
            theStage.show();
            theStage.toBack();
        }
        else
            if(tim.runIntoSupply(p) != null)
            {
                theStage.close();
                atSupply(theStage);
                theStage.show();
                theStage.toBack();
                Supplies su = (Supplies)tim.returnMaterial(p);
            }
        if(tim.enteredNewBiome(p) != null)
        {
            theStage.close();
            biomeChange(theStage, tim.enteredNewBiome(p));
            theStage.show();
            theStage.toBack();
        }
        if(tim.randomGift(p) != null)
        {
            theStage.close();
            giftMessage(theStage, tim.randomGift(p));
            theStage.show();
            theStage.toBack();
        }
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
        
        Image timImage = new Image("tim the enchanter.png"); // Replace with picture of Tim
        
        Canvas timSpace = new Canvas(windowX / 4, windowY / 4);
        GraphicsContext gc = timSpace.getGraphicsContext2D();
        
        gc.drawImage(timImage, 0, 20, windowX / 4, windowY / 4);

        // label the window
        Label title = new Label("Instructions:");
        // create two 'paragraphs'
        Text p1 = new Text(" I am an enchanter. ");
        Text p2 = new Text(" There are some who call me...Tim. ");

        
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
    
    private static void showInstructionsOther(Stage theStage)
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

        // create and add scene with instructions
        Scene instScene = new Scene(instG);
        instStage.setScene(instScene);
        
        Image timImage = new Image("tim the enchanter.png"); // Replace with picture of Tim
        
        Canvas timSpace = new Canvas(windowX / 4, windowY / 4);
        GraphicsContext gc = timSpace.getGraphicsContext2D();
        
        gc.drawImage(timImage, 0, 20, windowX / 4, windowY / 4);

        // label the window
        Label title = new Label("Instructions:");
        // create two 'paragraphs'
        Text p1 = new Text(" I am an enchanter. ");
        Text p2 = new Text(" There are some who call me...Tim. ");

        
        pixHB.getChildren().addAll(p1, timSpace);
        
        // add everything to VBox
        textVB.getChildren().addAll(title, pixHB, p2);
        textVB.setPrefWidth(windowX / 3);
        textVB.setPrefHeight(windowY / 3);
        
        textVB.setAlignment(Pos.CENTER_LEFT);
        
        
        // add VBox to window
        instG.getChildren().add(textVB);
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
    
    private static void atObstacle(Stage theStage, String message, String weapon)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        popup.setScene(pop);
        popup.setTitle("Obstacle");
        
        
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        if(rand < 1)
            s = "Ack! ";
        else
            s = "Oh No! ";
        
        Text obstacle = new Text(s + message); //+ p.getObstacle().toString());
        Text nope = new Text("Sorry, you don't have the weapons that can fight this one.");
        Button counterB1 = new Button(" Use Weapon "); // p.getObstacle().getOption1());
        Button counterB2 = new Button(" Don't Use Weapon "); // p.getObstacle().getOption2());
        Button close = new Button(" Close ");
        int number = 0;
        if (weapon.equals("bow and arrow"))
            number = p.getBowAndArrow();
        else
            if (weapon.equals("rope"))
                number = p.getRope();
            else
                if (weapon.equals("spear"))
                    number = p.getSpear();
                else
                    if (weapon.equals("armor"))
                        number = p.getArmor();
                    else
                        if (weapon.equals("pickaxe"))
                            number = p.getPickaxe();
                        else
                            if (weapon.equals("fire-proof shield"))
                                number = p.getFireProofShield();
        
        if (number == 0)
            vb2.getChildren().addAll(obstacle, nope, close);
        else
            vb2.getChildren().addAll(obstacle, counterB1, counterB2);
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);


        
        // when the option 1 button is pressed
        counterB1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the first option
                // System.out.println("Op 1");
                wol = tim.fightObstacle(p, true);
                if (weapon.equals("bow and arrow"))
                    p.subtractBowAndArrow(1);
                else
                    if (weapon.equals("rope"))
                        p.subtractRope(1);
                    else
                        if (weapon.equals("spear"))
                            p.subtractSpear(1);
                        else
                            if (weapon.equals("armor"))
                                p.subtractArmor(1);
                            else
                                if (weapon.equals("pickaxe"))
                                    p.subtractPickaxe(1);
                                else
                                    if (weapon.equals("fire-proof shield"))
                                        p.subtractFireProofShield(1);
                popup.close();
            }
        });
        
        counterB2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the second option
                wol = tim.fightObstacle(p, false);
                popup.close();
            }
        });
        
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the second option
                popup.close();
            }
        });
        
        // p.getObstacle().succeedOrFail(p);
        
        popup.show();
    }
    
    private static void atSupply(Stage theStage)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        popup.setScene(pop);
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        if(rand < 1)
            s = "Cool! ";
        else
            s = "Awesome! ";
        
        Text obstacle = new Text(s + " =) You found a some supplies");
        
        Button supplyB1 = new Button("Take and Leave");
        Button supplyB2 = new Button("Leave");
        
        vb2.getChildren().addAll(supplyB1, supplyB2);
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);

        
        
        // when the option 1 button is pressed
        supplyB1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                
            }
        });
        
        supplyB2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                
            }
        });
        
        
        popup.showAndWait();
    }
    
    private static void showCraftMenu(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        popup.setScene(s);
        
        
        Button close = new Button("Close");
        Button bowArrow = new Button("Bow and Arrow");
        Button spear = new Button("Spear");
        Button armor = new Button("Armor");
        Button pick = new Button("Pickaxe");
        Button fireproof = new Button("Fire-Proof Shield");
        Button rope = new Button("Rope");
        
        HBox buttons = new HBox(20);
        VBox vb = new VBox(30);
        
        buttons.getChildren().addAll(bowArrow, spear, armor, pick, fireproof, rope);
        vb.getChildren().addAll(buttons, close);
        g.getChildren().add(vb);
           
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
            }
        });
        
        bowArrow.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addBowAndArrow(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        spear.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addSpear(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        armor.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addArmor(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        pick.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addPickaxe(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        fireproof.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addFireProofShield(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        rope.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addRope(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        popup.showAndWait();
    }
    
    private static void showErrorMessage(Stage theStage, String err)
    {
        Group g = new Group();
        Stage s = new Stage();
        Scene error = new Scene(g);
        s.setScene(error);
        s.setTitle("Error");
        
        VBox vB = new VBox(20);
        
        err = err.substring(36);
        
        Text msg = new Text("Oops. Unfortunately, you can't do that.");
        Text msg1 = new Text(err);
        
        vB.getChildren().addAll(msg, msg1);
        
        g.getChildren().add(vB);
        
        s.showAndWait();
    }
    
    private static void biomeChange(Stage theStage, String biome)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        popup.setScene(s);
        popup.setTitle("Biome Changing");
        
        Button close = new Button("Close");
        
        VBox vb = new VBox();
        Label title = new Label("MESSAGE:");
        Text warning = new Text(biome);
        vb.getChildren().addAll(title, warning, close);
        g.getChildren().add(vb);
        
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
            }
        });
        
        popup.showAndWait();
    }
    
    private static void giftMessage(Stage theStage, String gift)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        popup.setScene(s);
        
        Button close = new Button("Close");
        
        VBox vb = new VBox();
        Label title = new Label("MESSAGE:");
        Text msg = new Text("Tim granted you a gift. You got " + gift);
        vb.getChildren().addAll(title, msg, close);
        g.getChildren().add(vb);
           
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
            }
        });
        
        popup.show();
    }
    
    private static void finalObstacle(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene confirmScene = new Scene(g);
        
        popup.setScene(confirmScene);
        
        Button confirm = new Button("Yes");
        Button deny = new Button("Nah");
        
        VBox vb = new VBox(10);
        HBox buttonHB = new HBox(15);
        
        Label title = new Label("MESSAGE:");
        Text msg = new Text("Are you sure you want to enter the final battle?");
        Text msg2 = new Text("Once you accept, there is no going back.");
        
        buttonHB.getChildren().addAll(confirm, deny);
        
        vb.getChildren().addAll(title, msg, msg2, buttonHB);
        g.getChildren().add(vb);
           
        deny.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
            }
        });
        
        confirm.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                theStage.close();
                
                Scene finalBoss = new Scene(g);
                popup.setScene(finalBoss);
                
                popup.setTitle("Final Boss");
                
                
                
                popup.show();
            }
        });
        
        popup.showAndWait();
    }
} 
