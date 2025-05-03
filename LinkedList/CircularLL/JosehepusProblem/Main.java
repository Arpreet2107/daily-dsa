//import java.util.*;

class JosephusProblem {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head, tail;

        public void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
        }

        public int josephus(int k) {
            Node temp = head;
            while (temp.next != temp) {
                for (int count = 1; count < k; count++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            return temp.data;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Number of people in the circle
        int n = 5;
        // Step count (every 2nd person is eliminated)
        int k = 2;

        // Add people to the circular list
        for (int i = 1; i <= n; i++) {
            cll.addNode(i);
        }

        // Find the last person standing
        int lastPerson = cll.josephus(k);
        System.out.println("The last person standing is: " + lastPerson);
    }
}
