import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Main Application for JavaFX
 * @author Matthew Oh c:
 * Thanks for being such an awesome teacher
 */
public class Main extends Application
{
    public static void main(String[] args) {launch(args);}
    
    public void start(Stage stage)
    {
        Group quizLayout = new Group();
        Scene quiz = new Scene(quizLayout);
        initilize(quizLayout);
        
        //Group layout = new Group();
        //Button b = new Button("test");
        //View view = new View(layout);
        //Rectangle r = new Rectangle(500,500,Color.WHITE);
        //layout.getChildren().addAll(r);
        //layout.getChildren().addAll(b);
        //Scene scene = new Scene(layout);
        stage.setScene(quiz);
        stage.sizeToScene();
        stage.setTitle("THANK YOU MR. L");
        stage.setResizable(false);
        stage.show();
    }
    
    private static void initilize(Group layout)
    {
        Rectangle r = new Rectangle(500,500,Color.WHITE);
        Button b1 = new Button("answer1");
        b1.relocate(10,280);
        b1.setMinWidth(235);
        b1.setMinHeight(100);
        Button b2 = new Button("answer2");
        b2.relocate(255,280);
        b2.setMinWidth(235);
        b2.setMinHeight(100);
        Button b3 = new Button("answer3");
        b3.relocate(10,390);
        b3.setMinWidth(235);
        b3.setMinHeight(100);
        Button b4 = new Button("answer4");
        b4.relocate(255,390);
        b4.setMinWidth(235);
        b4.setMinHeight(100);
        Label que = new Label("question");
        que.relocate(10,10);
        que.setMinWidth(480);
        que.setMinHeight(200);
        Label result = new Label("Correct!");
        result.relocate(10,240);
        result.setMinWidth(480);
        result.setMinHeight(30);
        Button cont = new Button("Continue");
        cont.relocate(390,240);
        cont.setMinWidth(100);
        cont.setMinHeight(30);
        cont.setMaxHeight(30);
        //Rectangle res = new Rectangle(480, 30, Color.BLUE);
        //res.relocate(10,240);
        layout.getChildren().addAll(r,b1,b2,b3,b4,que,result,cont);
        //still need to set up button functionality
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                
            }
        });
    }
}
