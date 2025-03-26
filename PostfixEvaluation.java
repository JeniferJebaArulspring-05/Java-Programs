public class PostfixEvaluation {

    // Method to evaluate a Postfix expression
    public static int evaluatePostfix(String expression) {
        // Create a stack to store operands
        Stack<Integer> stack = new Stack<>();
       
        // Loop through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
           
            // If the character is a digit, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // Convert char to integer and push to stack
            }
            // If the character is an operator, pop two elements, apply the operator, and push the result
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand
                int result;
               
                // Perform the operation based on the operator
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        // Handle division by zero
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
                // Push the result back to the stack
                stack.push(result);
            }
        }
       
        // The final result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "53+82-*"; // Example postfix expression
        System.out.println("Postfix Expression: " + postfixExpression);
       
        try {
            int result = evaluatePostfix(postfixExpression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}