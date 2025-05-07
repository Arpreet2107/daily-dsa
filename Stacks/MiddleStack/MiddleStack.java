// File: MiddleStack.java

class DLLNode {
    int data;
    DLLNode prev, next;

    DLLNode(int data) {
        this.data = data;
    }
}

public class MiddleStack {
    DLLNode head, mid;
    int count;

    public void push(int x) {
        DLLNode newNode = new DLLNode(x);
        newNode.next = head;

        if (head != null) head.prev = newNode;
        head = newNode;

        count++;

        if (count == 1) {
            mid = newNode;
        } else {
            if (count % 2 != 0) {
                mid = mid.prev;
            }
        }
    }

    public int pop() {
        if (count == 0) throw new RuntimeException("Stack is Empty");

        int item = head.data;
        head = head.next;

        if (head != null) head.prev = null;

        count--;
        if (count % 2 == 0 && mid != null) {
            mid = mid.next;
        }

        return item;
    }

    public int findMiddle() {
        if (mid == null) throw new RuntimeException("No elements");
        return mid.data;
    }

    public int deleteMiddle() {
        if (mid == null) throw new RuntimeException("No elements");

        int val = mid.data;

        if (mid.prev != null) mid.prev.next = mid.next;
        if (mid.next != null) mid.next.prev = mid.prev;

        if (count == 1) {
            head = mid = null;
        } else if (count % 2 == 0) {
            mid = mid.next;
        } else {
            mid = mid.prev;
        }

        count--;
        return val;
    }

    public static void main(String[] args) {
        MiddleStack ms = new MiddleStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);

        System.out.println("Middle: " + ms.findMiddle()); // 3
        System.out.println("Deleted Middle: " + ms.deleteMiddle()); // 3
        System.out.println("New Middle: " + ms.findMiddle()); // 4
    }
}
