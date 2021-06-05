import java.util.*;


/*  Used https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/ as reference for a great deal of this code.

 */
public class Polynomial implements Iterable, Comparable<Polynomial>{
    Node head = null; // the head of the list
    Node last = null;

    public Polynomial(String fileLine) throws InvalidPolynomialSyntax {
        String[] myStrArr = fileLine.split(" ");
        for (int i = 0; i < myStrArr.length; i = i + 2) {
            try {
                this.insert(Double.parseDouble(myStrArr[i]), Integer.parseInt(myStrArr[i + 1]));
            } catch (NumberFormatException e) {
                throw new InvalidPolynomialSyntax("The coefficent could not be parsed as a double.");
            }
        }
    }

    public void insert(double coefficient, int exponent) {
        Node node = new Node();
        node.data.setCoefficient(coefficient);
        node.data.setExponent(exponent);
        node.next = null;

        if (this.head == null) {
            head = node;
            last = node;

        } else {
            last.next = node;
            last = node;
        }
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data.getCoefficient() + "x^" + node.data.getExponent() + " ");
            node = node.next;
        }
        System.out.println(node.data.getCoefficient() + "x^" + node.data.getExponent());
    }

    @Override
    public Iterator iterator() {
        return new PolynomialIterator();
    }

    class PolynomialIterator implements Iterator {
        Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public PolyNodeData next() {
            if (current != null) {
                PolyNodeData currentData = current.data;
                current = current.next;
                return currentData;
            } else {
                throw new NoSuchElementException();
            }
        }
    }


    public static class Node {
        PolyNodeData data = new PolyNodeData();
        Node next;
    }

    @Override
    public int compareTo(Polynomial p) {
        int myReturn = 0;
        Iterator itrA = this.iterator();
        Iterator itrB = p.iterator();
        while(myReturn == 0) {
            if (itrA.hasNext() && itrB.hasNext()) {
                PolyNodeData nodeA = (PolyNodeData) itrA.next();
                PolyNodeData nodeB = (PolyNodeData) itrB.next();
                myReturn = (nodeA.getExponent() - nodeB.getExponent());
                if (myReturn == 0) {
                    if ((nodeA.getCoefficient() - nodeB.getCoefficient()) > 0) {
                        myReturn = 1;
                    } else if ((nodeA.getCoefficient() - nodeB.getCoefficient()) < 0) {
                        myReturn = -1;
                    } else {
                        myReturn = 0;
                    }
                }
            } else if (itrA.hasNext()) {
                myReturn = 1;
            } else {
                myReturn = -1;
            }
        }
        return myReturn;
    }
}


