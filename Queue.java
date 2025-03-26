// Node class for the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class using a singly linked list
class Queue {
    private Node front, rear;

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = this.rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue (insert) an element at the rear
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {  // If queue is empty
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue (remove) an element from the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot dequeue.");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {  // If queue becomes empty after dequeue
            rear = null;
        }

        return value;
    }

    // Peek (get the front element without removing it)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }

    // Display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method to test the queue
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();  // Output: 10 -> 20 -> 30 -> NULL

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 10

        queue.display();  // Output: 20 -> 30 -> NULL

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 20
    }
}