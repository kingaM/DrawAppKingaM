package drawapp;

public class ParseException extends Exception
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ParseException()
  {
    super("Exception during parsing");
  }

  public ParseException(String message)
  {
    super(message);
  }
}
