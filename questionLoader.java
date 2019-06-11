/**
 * @author manseej khatri
 * simple static class to load question array
 */

import java.util.Scanner;
import java.io.File;

public class questionLoader
{
    public static Question[] load(String filename)
    {
        //since question file should have 5 lines each this works
        Scanner sc;
        Question QuestionArray[] = null;
        try
        {
            sc = new Scanner(new File(filename));
            int numLines = sc.nextInt();
            //creates an array of questions which can then be used by quiz
            QuestionArray = new Question[numLines/5];
            //checks every 5 lines {since questions are going to take 5 lines each}
            sc.nextLine();
            for(int i = 0; i < numLines; i+=5)
            {
                String questionText = sc.nextLine();
                String[] choiceArray = new String[4];
                for(int j = 0; j < 4; j++)
                {
                    choiceArray[j] = sc.nextLine();
                }
                QuestionArray[i/5] = createQuestion(questionText,choiceArray);
            }
            sc.close();
        }
        catch(java.io.FileNotFoundException e)
        {
            System.out.println("Please Enter A correct File");
        }

        return QuestionArray;
    }

    //helper class to create a question and return it
    private static Question createQuestion(String QuestionText,String[] choiceArray)
    {
        int correctNum = -1;
        Question q;
        for(String choice : choiceArray)
        {
            String temp = choice.substring(3);
            if(temp.indexOf("(correct)")>=0)
            {
                correctNum = ((int)choice.charAt(0))-65;
            }
        }
        return new Question(QuestionText,correctNum,choiceArray[0].substring(3),choiceArray[1].substring(3),
                choiceArray[2].substring(3),choiceArray[3].substring(3));
    }


}
