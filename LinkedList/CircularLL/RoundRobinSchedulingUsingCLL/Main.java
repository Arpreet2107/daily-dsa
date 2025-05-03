class RoundRobinScheduling {
    Node head;

    // Node class to represent a process
    class Node {
        String processName;
        Node next;

        Node(String processName) {
            this.processName = processName;
            this.next = null;
        }
    }

    // Method to add processes to the queue
    public void addProcess(String processName) {
        Node newNode = new Node(processName);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular reference
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; // Circular reference
        }
    }

    // Method to execute the round-robin scheduling
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Node temp = head;
        do {
            System.out.println("Executing process: " + temp.processName);
            // Simulate process execution for timeQuantum
            try {
                Thread.sleep(timeQuantum * 1000); // Simulate execution time (in seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp = temp.next; // Move to the next process in the circular queue
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr = new RoundRobinScheduling();
        rr.addProcess("Process 1");
        rr.addProcess("Process 2");
        rr.addProcess("Process 3");
        rr.addProcess("Process 4");

        int timeQuantum = 2; // Time quantum in seconds
        System.out.println("Round-robin scheduling execution:");
        rr.roundRobinScheduling(timeQuantum);
    }
}
