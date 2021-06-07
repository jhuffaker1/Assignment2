import java.util.*;


/*  Used https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/ as reference for a great deal of this code.

 */
public class Polynomial implements Iterable, Comparable<Polynomial> {
    private Node head = null; // the head of the list
    private Node last = null;

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


    private static class Node {
        private PolyNodeData data = new PolyNodeData();
        private Node next;
    }

    @Override
    public int compareTo(Polynomial p) {
        int myReturn = 0;
        Iterator itrA = this.iterator();
        Iterator itrB = p.iterator();
        while (myReturn == 0) {
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

    @Override
    public String toString() {
        Iterator myItr = this.iterator();
        String outputStr = "";
        if (myItr.hasNext()) {
            PolyNodeData firstNode = (PolyNodeData) myItr.next();
            if (firstNode.getCoefficient() != 0) {
                if (firstNode.getExponent() > 1) {
                    outputStr = firstNode.getCoefficient() + "x^" + firstNode.getExponent();
                } else if (firstNode.getExponent() == 1) {
                    outputStr = firstNode.getCoefficient() + "x";
                } else if (firstNode.getExponent() == 0) {
                    outputStr = Double.toString(firstNode.getCoefficient());
                }
            }
        } while (myItr.hasNext()) {
            PolyNodeData currentData = (PolyNodeData)myItr.next();
            String appendedStr = "";
            if (currentData.getExponent() > 1) {
                appendedStr = currentData.getCoefficient() + "x^" + currentData.getExponent();
            } else if (currentData.getExponent() == 1) {
                appendedStr = currentData.getCoefficient() + "x";
            } else if (currentData.getExponent() == 0) {
                appendedStr = Double.toString(currentData.getCoefficient());
            }
            if (currentData.getCoefficient() > 0) {
                outputStr = outputStr + " +" + appendedStr;
            } else if(currentData.getCoefficient() < 1) {
                outputStr = outputStr + " " + appendedStr;
            }
        }
        return outputStr;
    }
}


