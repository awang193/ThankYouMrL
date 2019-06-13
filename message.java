/** @author manseej Khatri
 *
 * represents a message written by a student or teacher
 */


public class message
{
    //instant variables
    private String author, message;

    //constructor
    public message(String author, String message)
    {
        this.author = author;
        this.message = message;
    }

    //getter for message
    public String getMessage()
    {
        return message;
    }

    //getter for author
    public String getAuthor()
    {
        return author;
    }

}