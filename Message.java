/** @author Manseej Khatri, Kelechi Uhegbu
 *
 * represents a message written by a student or teacher
 */


public class Message
{
    //instance variables
    private String author, note;

    /**Constructor to initialize a message */
    public message(String author, String note)
    {
        this.author = author;
        this.note = note;
    }

    /**
    * method for obtaining the note of the message
    * @return a String containing the note that the author wrote
    */
    public String getNote()
    {
        return note;
    }

    /**
    * method for obtaining the author of the message
    * @return a String containing the name of the author
    */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @override toString in Object
     */
    public String toString()
    {
        return getAuthor();
    }

}
