/**
 *
 * @author Manseej Khatri, Andrew Wang, Kelechi Uhegbu
 */

import java.util.Scanner;
import java.io.File;


public class Quiz
{
    boolean started;
    private Question[] questions;
    private int currentQuestion;
    private int totalQuestions;

    public Quiz()
    {
        this.questions = load("QuestionData.txt");
        this.currentQuestion = 1;
        this.totalQuestions = questions.length;
    }

    public boolean isStarted()
    {
        return started;
    }

    public void start()
    {
        started = true;
    }

    public void checkCurrentQuestion(int answer)
    {
        questions[currentQuestion - 1].check(answer);
    }

    // Method to create an array of questions for the quiz
    private Question[] load(String filename)
    {
        // Initialize array of questions
        Question QuestionArray[] = null;

        // Declare scanner to read file
        try (Scanner sc = new Scanner(new File(filename)))
        {
            // Read number of lines to calculate number of questions (5 lines per question)
            int numQuestions = sc.nextInt() / 5;

            // Initialize question array
            QuestionArray = new Question[numQuestions];

            // Move to next line (first question)
            sc.nextLine();

            // Read until the end of the file
            for (int i = 0; i < numQuestions; i++)
            {
                // Read first line as question text
                String questionText = sc.nextLine();
                // Read next four lines (answer choices A-D) into an array
                String[] choices = {sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()};

                // Create a new question and modify array at current position
                QuestionArray[i] = createQuestion(questionText, choices);
            }
        }
        catch(java.io.FileNotFoundException e)
        {
            // Print stack trace if exception thrown
            System.out.println(e.getMessage());
        }

        // Return created array of questions
        return QuestionArray;
    }

    // Helper method to assist load which creates questions from a prompt and an array of answer choices
    private Question createQuestion(String QuestionText, String[] choiceArray)
    {
        // Set correctNum to -1 by default to ensure initialization
        int correctNum = -1;

        // Loop through choices
        for(String choice : choiceArray)
        {
            // Get answer choice after letter and check if it is the correct answer
            String temp = choice.substring(3);

            // If correct answer found, set correctNum
            if (temp.indexOf("(correct)")>=0)
            {
                correctNum = ((int)choice.charAt(0))-65;
            }
        }

        // Return created question
        return new Question(QuestionText, correctNum, choiceArray[0], choiceArray[1], choiceArray[2], choiceArray[3]);
    }

    public void nextQuestion()
    {
        currentQuestion++;
    }

    public int getCurrentQuestionNumber()
    {
        return currentQuestion;
    }

    public int getTotalQuestions()
    {
        return totalQuestions;
    }

    public Question getCurrentQuestion()
    {
        Question ret = null;

        try
        {
            ret = questions[currentQuestion - 1];
        }
        catch (Exception e)
        {
            ret = new Question("Easter egg!", 0, "A", "B", "C", "D");
        }

        return ret;
    }

    public boolean isComplete()
    {
        return currentQuestion > totalQuestions;
    }

}
