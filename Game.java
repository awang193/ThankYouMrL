import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application
{
    private Quiz quiz;
    private CryptoChallenge finalChallenge;

    public Game()
    {
        this.quiz = new Quiz();

        String encrypted = "71 117 110 103 39 102 32 115 104 121 121 32 99 98 118 97 103 102 33 32 71 117 110 97 120 32 108 98 104 32 90 101 46 32 89 33 32 74 114 32 110 99 99 101 114 112 118 110 103 114 32 110 121 121 32 103 117 114 32 106 98 101 120 32 110 97 113 32 103 118 122 114 32 108 98 104 32 99 104 103 32 11897 32 115 98 101 32 104 102 32 114 105 114 101 108 32 113 110 108 33";
        String decrypted = "That's full points! Thank you Mr. L! We appreciate all the work and time you put in for us every day!";

        this.finalChallenge = new CryptoChallenge(encrypted, decrypted);
    }

    @Override
    public void start(Stage stage)
    {
        Game g = new Game();

        // Quiz scene
        Question currentQ = null;
        Label header = null, question = null;
        GridPane questionGrid = null;

        currentQ = quiz.getCurrentQuestion();

        header = new Label("Question " + quiz.getCurrentQuestionNumber() + ":");
        question = new Label(currentQ.getQuestionText());

        Button choiceA = new Button(currentQ.getChoiceText(0));
        Button choiceB = new Button(currentQ.getChoiceText(1));
        Button choiceC = new Button(currentQ.getChoiceText(2));
        Button choiceD = new Button(currentQ.getChoiceText(3));

        questionGrid = new GridPane();
        questionGrid.add(choiceA, 0, 0);
        questionGrid.add(choiceB, 1, 0);
        questionGrid.add(choiceC, 0, 1);
        questionGrid.add(choiceD, 1, 1);

        VBox quizVBox = new VBox(header, question, questionGrid);

        Scene quizScene = new Scene(quizVBox);

        // Main menu
        Label title = new Label("Thank You Mr. L, the Game");
        Button playButton = new Button("Play");
        playButton.setOnMouseClicked(event -> stage.setScene(quizScene));

        VBox mainVBox = new VBox(title, playButton);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(100);

        Scene mainScene = new Scene(mainVBox, 500, 500);

        stage.setScene(mainScene);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
