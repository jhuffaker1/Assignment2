public class OrderedList {

    public boolean checkSorted(Polynomial[] polynomialList) {
        boolean isSorted = false;
        for (int i = 0; i < polynomialList.length - 1; i++) {
            int myChecker = polynomialList[i].compareTo(polynomialList[i + 1]);
            System.out.println(myChecker);
            if (myChecker > 0) {
                    isSorted = this.checkSorted(polynomialList[i], polynomialList[i + 1]);
            }
            System.out.println("made it here 002");
            if (!isSorted) {
                break;
            }
        }
        return isSorted;
    }

    public static boolean checkSorted(Polynomial p1, Polynomial p2) {
        System.out.println("doing a print");
        Polynomial.WeakOrderChecker weakChecker = new Polynomial.WeakOrderChecker();
        int myChecker = weakChecker.compare(p1,p2);
        System.out.println("made it here 003");
        System.out.println(myChecker);
        if (myChecker > 0) {
            return true;
        }
        return false;
    }
}
