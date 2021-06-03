import java.lang.Exception;

/* The following link was used as reference for this code.
https://beginnersbook.com/2013/04/user-defined-exception-in-java/
 */

public class InvalidPolynomialSyntax extends Exception{
    public InvalidPolynomialSyntax(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}
