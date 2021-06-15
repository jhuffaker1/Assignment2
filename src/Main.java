import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String myString = "5.6 3 -4 1 8.3 0";
        String myString2 = "5.7 3 1 1 3 0";
        Scanner myScanner = new Scanner(System.in);
        Scanner fileScanner = null;
        ArrayList<Polynomial> myPolys = new ArrayList<Polynomial>();
        File myFile = null;

        while (fileScanner == null) {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println(chooser.getSelectedFile().getAbsolutePath());
                myFile = new File(chooser.getSelectedFile().getAbsolutePath());
            }

            try {

                fileScanner = new Scanner(myFile);
            } catch (FileNotFoundException e) {
                System.out.println("The file could not be found. Please try entering the path again. ");
            }
        }
        while (fileScanner.hasNext()) {
            String currentLine = fileScanner.nextLine();
            try {
                myPolys.add(new Polynomial(currentLine));
                System.out.println(myPolys.get(myPolys.size()-1).toString());
            } catch (InvalidPolynomialSyntax e2) {
                JOptionPane.showMessageDialog(null, "The syntax of the following polynomial is incorrect: \n" + currentLine);
                System.exit(0);
            }
        }
        OrderedList myOrderChecker = new OrderedList();
        if (myOrderChecker.checkSorted(myPolys)) {
            JOptionPane.showMessageDialog(null, "The polynomials that were read in correctly are properly ordered with a strong and weak order");
        }
    }
}