import java.lang.Math;
import java.util.*;
public class StringStringer {

    public StringStringer() {

    }


    public String stringify(String s) {
        Queue<Double> myCoefficients = new LinkedList<Double>();;
        Queue<Integer> myExponents = new LinkedList<Integer>();;
        String[] newStringArr = s.split(" ");
        for (int i =0; i < newStringArr.length; i = i+2) {
            myCoefficients.add(Double.parseDouble(newStringArr[i]));
        }
        for (int i =1; i < newStringArr.length; i = i+2) {
            myExponents.add(Integer.parseInt(newStringArr[i]));
        }
        String myOutput = "";
        String nextPosOrNeg = "";
        if (myExponents.peek() < 0){
            nextPosOrNeg = "-";
        }

        while (!myExponents.isEmpty()) {
            try{
                if (myExponents.peek() > 1) {
                    myOutput = myOutput + " " + nextPosOrNeg + " " + Double.toString(Math.abs(myCoefficients.remove())) + "x^" + Integer.toString(myExponents.remove());
                } else if (myExponents.peek() == 1) {
                    myOutput = myOutput + " " + nextPosOrNeg + " " + Double.toString(Math.abs(myCoefficients.remove())) + "x";
                    myExponents.remove();
                } else if (myExponents.peek() == 0) {
                    myOutput = myOutput + " " + nextPosOrNeg + " " + Double.toString(Math.abs(myCoefficients.remove()));
                    myExponents.remove();
                }
            } catch (NoSuchElementException e1) {
                myExponents.remove();
            }
            try{
                if (myCoefficients.peek() >= 0) {
                    nextPosOrNeg = "+";
                } else if (myCoefficients.peek() < 0) {
                    nextPosOrNeg = "-";
                }
            } catch (NullPointerException e2) {

            }
        }
        return myOutput;
    }
}


