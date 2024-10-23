import java.util.Scanner;

class Stack {
    private int top;
    private int maxSize;
    private char[] stackArray;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    // Push an element onto the stack
    public void push(char ch) {
        if (top < maxSize - 1) {
            stackArray[++top] = ch;
        }
    }

    // Pop an element from the stack
    public char pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return '\0'; // Return null character if stack is empty
    }

    // Peek the top element of the stack
    public char peek() {
        if (top >= 0) {
            return stackArray[top];
        }
        return '\0'; // Return null character if stack is empty
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}

public class InfixToPrefix {

    // Method to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    // Method to reverse a string
    private static String reverse(String expression) {
        String reversed = "";
        for (int i = expression.length() - 1; i >= 0; i--) {
            reversed += expression.charAt(i);
        }
        return reversed;
    }

    // Method to convert infix expression to postfix expression
    private static String infixToPostfix(String expression) {
        String result = "";
        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the scanned character is an operand, add it to the result
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and output from the stack
            // until an '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else { // An operator is encountered
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    // Method to convert infix expression to prefix expression
    public static String infixToPrefix(String expression) {
        // Step 1: Reverse the infix expression
        String reversed = reverse(expression);
        
        // Step 2: Replace '(' with ')' and vice versa
        String modifiedExpression = "";
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (c == '(') {
                modifiedExpression += ')';
            } else if (c == ')') {
                modifiedExpression += '(';
            } else {
                modifiedExpression += c;
            }
        }

        // Step 3: Convert the modified expression to postfix
        String postfix = infixToPostfix(modifiedExpression);
        
        // Step 4: Reverse the postfix expression to get the prefix
        String prefix = reverse(postfix);
        
        return prefix;
    }

    // Main method to take input from the user and test the conversion
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();

        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);

        scanner.close();
    }
}
