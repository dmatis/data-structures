import java.util.Arrays;

public class Stack {
    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;

    public Stack(int size) {
        this.stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String item) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = item;
            System.out.println(item + " was added to the Stack\n");
        } else {
            System.out.println("Sorry, Stack is full\n");
        }
    }

    public void displayStack() {
        if (topOfStack == -1) {
            System.out.println("Empty stack");
        } else {
            System.out.println("--TOP--");
            for (int i = 0; i <= topOfStack; i++) {
                System.out.println(stackArray[topOfStack-i]);
            }
            System.out.println("--BOTTOM--");
        }
    }

    public String pop() {
        if (topOfStack == -1) {
            return "Empty stack";
        }
        else {
            topOfStack--;
            return stackArray[topOfStack+1];
        }
    }

    public int getStackCapacity() {
        return this.stackSize;
    }

    public int getItemCount() {
        return topOfStack+1;
    }

    public int getTopOfStack() {
        return topOfStack;
    }

    public static void main(String[] args) {

    }
}
