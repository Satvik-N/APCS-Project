import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
 
public class GUI extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        Player p1 = new Player();
        
        primaryStage.setTitle("Welcome to Survive");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        
        
        Scene s = new Scene(grid, 300, 275);
        primaryStage.setScene(s);
        
        Label usernameL = new Label("Enter name here:");
        TextField usernameTF = new TextField();
        grid.add(usernameL, 0, 1);
        grid.add(usernameTF, 1, 1);
        
        Button startGame = new Button("Start Game");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(startGame);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        startGame.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e)
            {
                actiontarget.setText("Starting Game...");
                p1.setName(usernameTF.getText());
            }
        }
        );
        
        
        Button inst = new Button("Instructions");
        HBox hbInst = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(inst);
        grid.add(hbBtn, 1, 4);
        
        
        inst.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    showInstructions();
                }
            }
        );
        
        // startGame.setLayoutY(100);
        // startGame.setLayoutX(50);
        // inst.setLayoutY(200);
        // inst.setLayoutX(500);
        StackPane root = new StackPane();
        root.getChildren().add(startGame);
        root.getChildren().add(inst);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    private void startGame(Stage primaryStage)
    {
        
        
        
        
    }
    
    private void showInstructions()
    {
        
    }
}