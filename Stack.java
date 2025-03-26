// Stack implementation in Java
class Stack {
    // Store elements of the stack
    private int arr[];
    // Represent the top of the stack
    private int top;
    // Total capacity of the stack
    private int capacity;

    // Creating a stack
    Stack(int size) {
        arr = new int[size];  // Initialize the array
        capacity = size;      // Set stack capacity
        top = -1;             // Initialize top to -1
    }

    // Push elements to the top of the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            // Terminate the program
            System.exit(1);
        }
        // Insert element on top of stack
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // Pop elements from the top of the stack
    public int pop() {
        // If stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty");
            // Terminate the program
            System.exit(1);
        }
        // Pop element from top of stack
        return arr[top--];
    }

    // Return the size of the stack
    public int getSize() {
        return top + 1;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display elements of the stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        // Push elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Stack: ");
        stack.printStack();

        // Remove element from the stack
        stack.pop();
        System.out.println("\nAfter popping out:");
        stack.printStack();
    }
}