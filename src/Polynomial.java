import java.lang.Comparable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/*  Used https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/ as reference for a great deal of this code.

 */
public class Polynomial /*implements Comparable<Polynomial>, Iterable<Polynomial> */ {
    Node head; // the head of the list
    String unparsedPolynomial;
    ArrayList<Double> inputCoefficients = new ArrayList<Double>();
    ArrayList<Integer> inputExponents= new ArrayList<Integer>();

    public Polynomial(String fileLine) throws InvalidPolynomialSyntax{
        String[] myStrArr = fileLine.split(" ");
        for (int i = 0; i < myStrArr.length; i = i+2) {
            try {
                inputCoefficients.add(Double.parseDouble(myStrArr[i]));
            } catch (NumberFormatException e) {
                throw new InvalidPolynomialSyntax("The coefficent could not be parsed as a double.");
            }
        }
        for (int i = 1; i < myStrArr.length; i = i+2) {
            try {
                inputExponents.add(Integer.parseInt(myStrArr[i]));
            } catch (NumberFormatException e){
                throw new InvalidPolynomialSyntax("The exponent could not be parsed as an int.");
            }
        }
        if (inputExponents.size() == inputCoefficients.size()) {
            for (int i = 0; i < inputExponents.size(); i++) {

            }
        }
    }
    static class Node {
        double coefficient;
        int exponent;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node (double coEff, int exp) {
            coefficient = coEff;
            exponent = exp;
        }

        // Method to insert a new node
        public static Polynomial insert(Polynomial list, double nodeCoefficient, int nodeExponent)
        {
            // Create a new node with given data
            Node new_node = new Node(nodeCoefficient, nodeExponent);
            new_node.next = null;

            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            }
            else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }

            // Return the list by head
            return list;
        }
    }
}
