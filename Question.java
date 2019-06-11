/** @author Manseej Khatri
 *  My little contribution to the end of the year project
 *  Thank you for all that you have done for us
 */


public class Question
{
    // instant variables
    // answer choices correlate to a number (ie 0 = A, 1 = B, 2 = C, 3 = D)
    private String[] answerChoices;
    private int correctAnswerNumber;
    private String questionText;

    public Question(String questionText, int correctAnswerNumber, String choiceA, String choiceB, String choiceC,
                    String choiceD)
    {
        //sorry for the "this statement pls forgive me"
        this.answerChoices = new String[]{choiceA,choiceB,choiceC,choiceD};
        this.correctAnswerNumber = correctAnswerNumber;
        this.questionText = questionText;
    }

    // takes in the choice num and returns the choice text
    public String getChoiceText(int choiceNum)
    {
        return answerChoices[choiceNum];
    }

    // checks to see if the selected answer is equal to the correct answer
    public boolean isCorrect(Object selectedAnswer)
    {
        //to keep only one exit
        boolean equalCheck = false;

        if((int)selectedAnswer == this.correctAnswerNumber)
        {
            equalCheck = true;
        }
        else
        {
            equalCheck = false;
        }
        return equalCheck;
    }


}
