// File: TwoStacksInOneArray.java

public class TwoStacksInOneArray {
    int[] arr;
    int size;
    int top1, top2;

    // Constructor
    public TwoStacksInOneArray(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    // Push to Stack1
    void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow in Stack 1");
        }
    }

    // Push to Stack2
    void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow in Stack 2");
        }
    }

    // Pop from Stack1
    int pop1() {
        if (top1 >= 0)
            return arr[top1--];
        else
            throw new RuntimeException("Stack Underflow in Stack 1");
    }

    // Pop from Stack2
    int pop2() {
        if (top2 < size)
            return arr[top2++];
        else
            throw new RuntimeException("Stack Underflow in Stack 2");
    }

    public static void main(String[] args) {
        TwoStacksInOneArray ts = new TwoStacksInOneArray(10);
        ts.push1(1);
        ts.push2(100);
        ts.push1(2);
        ts.push2(200);

        System.out.println("Pop from Stack1: " + ts.pop1());
        System.out.println("Pop from Stack2: " + ts.pop2());
    }
}
