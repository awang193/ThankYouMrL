/** @author Manseej Khatri edited by Andrew Wang
 *  My little contribution to the end of the year project
 *  Thank you for all that you have done for us
 */

public class Question
{
    // Instance variables
    /** questionText - The actual question prompt */
    private String questionText;
    /** correctAnswerNumber - The index in the array which corresponds with the correct answer */
    private int correctAnswerNumber;
    /** answerChoices - An array holding the text for each answer choice. A - answerChoices[0], B - answerChoices[1], etc. */
    private String[] answerChoices;


    // Constructor
    /**
     * Question() - Constructor for objects of type question.
     *
     * @param questionText - Question prompt
     * @param correctAnswerNumber - Number corresponding with correct answer
     * @param choiceA - Text for choice A
     * @param choiceB - Text for choice B
     * @param choiceC - Text for choice C
     * @param choiceD - Text for choice D
     */
    public Question(String questionText, int correctAnswerNumber, String choiceA, String choiceB, String choiceC, String choiceD)
    {
        // Use of this to promote readability
        this.answerChoices = new String[]{choiceA, choiceB, choiceC, choiceD};
        this.correctAnswerNumber = correctAnswerNumber;
        this.questionText = questionText;
    }


    // Methods
    /**
     * getChoiceText() - Returns the text for a given answer choice
     * @param choiceNum - int from 0-3 corresponding with A-D
     * @return
     */
    public String getChoiceText(int choiceNum)
    {
        return answerChoices[choiceNum];
    }

    /**
     * isCorrect() - Returns true if the selected answer is correct, false otherwise
     * @param selectedAnswer - int from 0-3 corresponding with A-D
     * @return Whether the selected answer choice is correct
     */
    public boolean isCorrect(int selectedAnswer)
    {
        return selectedAnswer == correctAnswerNumber;
    }


}
