public class ArrayStackTester {
    public static void main(String[] args) {
        
        ArrayStack stack = new ArrayStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
    }
}