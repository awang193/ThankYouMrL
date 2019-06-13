/**
 * @author Manseej Khatri, Kelechi Uhegbu
 *
 * Static class to load all messages from a file
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class messageLoader
{
    // loads messages from a file and returns an array
    public static ArrayList<message> load(String filename)
    {
        ArrayList<message> messages = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filename)))
        {
            String author = (sc.nextLine()).substring("(author)".length());
            while(sc.hasNextLine())
            {
                String message = "";
                boolean authorFlag = false;
                while(sc.hasNextLine() && !authorFlag)
                {
                    String templine = sc.nextLine();
                    if(!sc.hasNextLine() || templine.indexOf("(author)")>=0)
                    {
                        authorFlag = true;
                        if(!sc.hasNextLine())
                            message += templine;
                        messages.add(new message(author,message));
                        if(sc.hasNextLine())
                            author = templine.substring("(author)".length());
                        message = "";
                    }
                    else
                    {
                        message += templine + "\n";
                    }
                }
            }


        }
        catch (java.io.FileNotFoundException e)
        {
            //prints the stacktrace
            System.out.println(e.getMessage());
        }
        return messages;
    }
}