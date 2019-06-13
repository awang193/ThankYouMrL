import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

/**
 * New Window to view messages
 * @author Matthew Oh,
 * Thanks for being an awesome teacher!
 */
public class MessageView
{
    ListView<msg> names;
    Label message;
    public void display()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("potato");
        
        names = new ListView();
        names.getItems().addAll(
            new msg("name1", "msg1"), new msg("name2", "msg2"),
            new msg("name3", "msg3"));
        names.setMinWidth(200);
        names.setMaxWidth(200);
        
        names.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                msg m = (msg)names.getSelectionModel().getSelectedItems().get(0);
                //System.out.println(m);
                message.setText(m.getNote());
            }
        });
        
        message = new Label("Mr L, thanks for allowing me into APCS my sophomore year. I’ve had such a wonderful time in both the class and developing my skills and interacting with my fellow c0d3rs in CS Club. I hope you love your new job as much as you loved us!");
        message.setWrapText(true);
        message.setMinWidth(300);
        message.setMinWidth(300);
        
        HBox h = new HBox();
        h.getChildren().addAll(names,message);
        Scene s = new Scene(h, 500,500);
        
        window.setScene(s);
        window.show();
    }
}
