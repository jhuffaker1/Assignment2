import java.util.Iterator;
public class Main {


    public static void main(String[] args) {
        String myString = "5.6 3 -4 1 8.3 0";
        String myString2 = "5.6 3 1 1";
        try {
            Polynomial myPoly = new Polynomial(myString);
            Polynomial myPoly2 = new Polynomial(myString2);
            System.out.println(myPoly.toString());
            System.out.println(myPoly2.toString());
            //Iterator itr = myPoly.iterator();
            //PolyNodeData currentData;
            //while(itr.hasNext()){
            //    currentData = (PolyNodeData) itr.next();
            //    System.out.println(currentData.getCoefficient() + " " + currentData.getExponent());
            //}
            //System.out.println(myPoly.compareTo(myPoly2));
        } catch (InvalidPolynomialSyntax e) {
            System.out.println("try again doofus");
        }
    }
}