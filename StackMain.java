import java.util.*;

class OurStack{
	
	private int max;
	private int[] stackArray;
	private int top;

	public OurStack (int size){
		max = size;
		stackArray = new int[max];
		top = -1;
	
	}

	public void push(int value){
	
		if(isFull()){
			System.out.println("Stack is Full! Cannot Push "+ value);
		}else{
			stackArray[++top] = value;
		}
		
	}

	public int pop(){
		
		if(isEmpty()){
			System.out.println("Stack is Empty! Cannot Pop.");
			return -1;
		}else{
			return stackArray[top--];
		}
	
	}
	
	public int peek(){
	
		if(isEmpty()){
			System.out.println("Stack Empty nothing to peek");
			return -1;
		}else{
			return stackArray[top];
		}
		
	
	}
	public boolean isEmpty(){
	
		return top == -1;
	
	}
	public boolean isFull() {
        return top == max - 1;
    }
}

class StackMain{

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the size of Stack:");
		int size = scanner.nextInt();
		
		OurStack stack = new OurStack(size);
		
		while(true){
		
		System.out.println("1.Push, 2.Pop, 3.Peek, 4.Exit");
		int s = scanner.nextInt();
		
		switch (s){
		
		case 1:
			System.out.print("Enter the value to push: ")
			int value = scanner.nextInt();
			stack.push(value);
		
		break;
		
		case 2:
		
			System.out.println(stack.pop());
		
		break;
		
		case 3:
		
			System.out.println(stack.peek());
		
		break;
		
		case 4:
			scanner.close();
			System.exit(0);

		break;
		
		default:
		}
		}
	}

}
