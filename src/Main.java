public class Main {


    public static void main(String[] args) {
        String myString = "5.6 3 -4 1 8.3 0";
        try {
            Polynomial myPoly = new Polynomial(myString);
        } catch (InvalidPolynomialSyntax e) {
            System.out.println("try again doofus");
        }
    }
}