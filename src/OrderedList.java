import javax.swing.*;
import java.util.ArrayList;

public class OrderedList {

    private ArrayList<Polynomial> polynomialList = new ArrayList<Polynomial>();

    public boolean checkSorted(ArrayList<Polynomial> polynomialList) {
        this.polynomialList = polynomialList;
        boolean isSorted = false;
        for (int i = 0; i < polynomialList.size() - 1; i++) {
            int myChecker = polynomialList.get(i).compareTo(polynomialList.get(i+1));
            if (myChecker < 0) {
                JOptionPane.showMessageDialog(null, "The list failed the strong order check. ");
                isSorted = false;
                break;
            }
            if (myChecker >= 0) {
                    isSorted = this.checkSorted(polynomialList.get(i), polynomialList.get(i+1));
            }
            if (!isSorted) {
                break;
            }
        }
        return isSorted;
    }

    public static boolean checkSorted(Polynomial p1, Polynomial p2) {
        Polynomial.WeakOrderChecker weakChecker = new Polynomial.WeakOrderChecker();
        int myChecker = weakChecker.compare(p1,p2);
        if (myChecker >= 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "The list failed the weak order check. ");
        return false;
    }
}
