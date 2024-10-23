import java.util.Scanner;

class Stack {
    private int top;
    private int maxSize;
    private String[] stackArray;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }

    // Push an element onto the stack
    public void push(String element) {
        if (top < maxSize - 1) {
            stackArray[++top] = element;
        }
    }

    // Pop an element from the stack
    public String pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return null; // Return null if stack is empty
    }

    // Peek the top element of the stack
    public String peek() {
        if (top >= 0) {
            return stackArray[top];
        }
        return null; // Return null if stack is empty
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}

public class PrefixToPostfix {

    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    // Method to convert prefix expression to postfix expression
    public static String prefixToPostfix(String expression) {
        Stack stack = new Stack(expression.length());

        // Traverse the prefix expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            // If the character is an operand, push it onto the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            }
            // If the character is an operator, pop two operands from the stack,
            // form a postfix expression and push it back onto the stack
            else if (isOperator(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                if (operand1 == null || operand2 == null) {
                    return "Invalid Expression";
                }

                // Form the new postfix expression
                String postfix = operand1 + operand2 + c;

                // Push the new postfix expression onto the stack
                stack.push(postfix);
            }
        }

        // The remaining element on the stack is the postfix expression
        return stack.pop();
    }

    // Main method to take input from the user and test the conversion
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prefix expression: ");
        String prefixExpression = scanner.nextLine();

        String postfixExpression = prefixToPostfix(prefixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        scanner.close();
    }
}
