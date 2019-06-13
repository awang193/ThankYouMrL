import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application
{
    private boolean quizStarted;
    private Quiz quiz;
    private CryptoChallenge finalChallenge;

    private Question currentQ;
    private Label header, question;

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

        // Crypto scene
        VBox cryptoVBox = new VBox();
        cryptoVBox.setAlignment(Pos.CENTER);
        cryptoVBox.setSpacing(50);

        Scene cryptoScene = new Scene(cryptoVBox, 650, 500);
        cryptoScene.getStylesheets().add(Game.class.getResource("resources/Styles.css").toExternalForm());

        Label prompt = new Label("That's full points. To advance to the end, decrypt this message from Ascus II to get the password:");

        TextField copyable = new TextField(finalChallenge.getEncrypted());
        copyable.setEditable(false);
        copyable.setId("copyable-label");

        prompt.setWrapText(true);

        TextField answerBox = new TextField();
        answerBox.setPromptText("Enter your answer here!");
        Button answerButton = new Button("submit!");

        answerButton.setOnMouseClicked(event ->
        {
            System.out.println(answerBox.getText());
            String answer = answerBox.getText();
            if(answer != null)
            {
                if(answer.equals(finalChallenge.getDecrypted()))
                {
                    MessageView finalMessages = new MessageView();
                    finalMessages.display();
                    ((Stage)answerButton.getScene().getWindow()).close();
                }
            }
        });

        cryptoVBox.getChildren().addAll(prompt, copyable ,answerBox,answerButton);


        // Quiz scene
        VBox quizVBox = new VBox();
        Scene quizScene = new Scene(quizVBox, 650, 500);
        quizScene.getStylesheets().add(Game.class.getResource("resources/Styles.css").toExternalForm());

        GridPane questionGrid;

        currentQ = quiz.getCurrentQuestion();

        header = new Label("Question " + quiz.getCurrentQuestionNumber() + " of " + quiz.getTotalQuestions() + ":");
        question = new Label(currentQ.getQuestionText());
        question.setWrapText(true);

        Button choiceA = new Button(currentQ.getChoiceText(0));
        Button choiceB = new Button(currentQ.getChoiceText(1));
        Button choiceC = new Button(currentQ.getChoiceText(2));
        Button choiceD = new Button(currentQ.getChoiceText(3));

        choiceA.wrapTextProperty().setValue(true);
        choiceB.wrapTextProperty().setValue(true);
        choiceC.wrapTextProperty().setValue(true);
        choiceD.wrapTextProperty().setValue(true);

        choiceA.setOnMouseClicked(event -> {
            quiz.checkCurrentQuestion(0);
        });

        choiceB.setOnMouseClicked(event -> {
            quiz.checkCurrentQuestion(1);
        });

        choiceC.setOnMouseClicked(event -> {
            quiz.checkCurrentQuestion(2);
        });

        choiceD.setOnMouseClicked(event -> {
            quiz.checkCurrentQuestion(3);
        });

        questionGrid = new GridPane();
        questionGrid.add(choiceA, 0, 0);
        questionGrid.add(choiceB, 1, 0);
        questionGrid.add(choiceC, 0, 1);
        questionGrid.add(choiceD, 1, 1);

        questionGrid.setAlignment(Pos.CENTER);
        questionGrid.setHgap(15);
        questionGrid.setVgap(15);
        questionGrid.setPadding(new Insets(15));

        quizVBox.getChildren().addAll(header, question, questionGrid);
        quizVBox.setAlignment(Pos.TOP_CENTER);
        quizVBox.setSpacing(10);
        quizVBox.setPadding(new Insets(20));

        // more_code.Main menu
        VBox mainVBox = new VBox();
        Scene mainScene = new Scene(mainVBox, 500, 500);
        mainScene.getStylesheets().add(Game.class.getResource("resources/Styles.css").toExternalForm());

        Label title = new Label("Thank You Mr. L, the Game");
        Label authors = new Label ("Written with care by Andrew Wang, Manseej Khatri, Matthew Oh, Kelechi Uhegbu, Darshan Parekh, Phoenix Dimagiba, Jason Giese, and Thomas Joel\n\nFeaturing messages from many others from your classes.");
        authors.setWrapText(true);
        authors.setId("label-small");
        authors.setAlignment(Pos.CENTER);

        VBox titleBox = new VBox(title, authors);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(25);

        Button playButton = new Button("Play");
        playButton.setOnMouseClicked(event -> {
            stage.setScene(quizScene);
            quiz.start();
        });

        mainVBox.getChildren().addAll(titleBox, playButton);

        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(50);


        mainScene.getStylesheets().add(Game.class.getResource("resources/Styles.css").toExternalForm());

        stage.setScene(mainScene);

        stage.show();

        AnimationTimer timer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if (!quiz.isComplete())
                {
                    if (currentQ.isFinished())
                    {
                        quiz.nextQuestion();
                        currentQ = quiz.getCurrentQuestion();

                        header.setText("Question " + quiz.getCurrentQuestionNumber() + " of " + quiz.getTotalQuestions() + ":");
                        question.setText(currentQ.getQuestionText());

                        choiceA.setText(currentQ.getChoiceText(0));
                        choiceB.setText(currentQ.getChoiceText(1));
                        choiceC.setText(currentQ.getChoiceText(2));
                        choiceD.setText(currentQ.getChoiceText(3));
                    }
                }
                else
                {
                    stage.setScene(cryptoScene);
                    this.stop();
                }
            }
        };

        timer.start();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
