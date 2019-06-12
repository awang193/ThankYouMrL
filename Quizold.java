/** @author Kelechi Uhegbu
 *  My contribution to end of the year project with questionable object oriented design.
 *  Thank you for being our teacher and mentor for these great years.
 */
public class Quiz
{
    Question questions[];
    public Quiz()
    {
        questions = new Questions[15];
        for(int i = 0; i < questions.length; i++)
        {
            Question quest = new Question(); //change this
            questions[i] = quest;
        }
    }

    public void run()
    {
        for(question q: questions)
        {
            boolean stay = true;
            while(stay)
            {
                System.out.println(q);
                Object inAnswer; //get input in some way
                if (q.isCorrect(inAnswer))
                {
                    stay = false;
                }
                else
                {
                    System.out.println("ACK! Try again");
                }
            }
            

        }
    }
}