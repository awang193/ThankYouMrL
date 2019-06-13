import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import java.util.ArrayList;

/**
 * New Window to view messages
 * @author Matthew Oh
 * Thanks for being an awesome teacher!
 */
public class MessageView
{
    ListView<Message> names;
    Label text;
    public void display()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Thank You Messages");
        
        names = new ListView();
        ArrayList<Message> messages = MessageLoader.load("messages.txt");
        for (Message m: messages)
            names.getItems().add(m);
        names.setMinWidth(200);
        names.setMaxWidth(200);
        names.setMinHeight(500);
        names.setMaxHeight(500);
        
        names.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                Message m = (Message)names.getSelectionModel().getSelectedItems().get(0);
                text.setText(m.getNote());
            }
        });
        
        text = new Label("1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
        text.setWrapText(true);
        text.setMinWidth(300);
        text.setMaxWidth(300);
        text.setMinHeight(500);
        text.setMaxHeight(500);
        
        VBox v = new VBox();
        v.getChildren().add(text);
        v.setPadding(new Insets(5));
        text.setAlignment(Pos.TOP_LEFT);
        HBox h = new HBox();
        h.getChildren().addAll(names,v);
        //compensate for non-resizable size error
        Group g = new Group();
        g.getChildren().addAll(new Rectangle(500,500, Color.WHITE), h);
        Scene s = new Scene(g);
        
        window.setScene(s);
        window.sizeToScene();
        window.setResizable(false);
        window.show();
    }
}
