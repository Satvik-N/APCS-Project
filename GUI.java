 
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class GUI extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Welcome to Survive");
        Button startGame = new Button("Start         Game");
        Button inst = new Button("Instructions");
        
        startGame.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    startGame();
                }
            }
        );
        
        inst.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    showInstructions();
                }
            }
        );
        
        startGame.setLayoutY(100);
        startGame.setLayoutX(50);
        inst.setLayoutY(200);
        inst.setLayoutX(500);
        StackPane root = new StackPane();
        root.getChildren().add(startGame);
        root.getChildren().add(inst);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    private void startGame()
    {
        JOptionPane.showMessageDialog(null, "Starting game");
    }
    
    private void showInstructions()
    {
        JOptionPane.showMessageDialog(null, "Instructions: ");
    }
}