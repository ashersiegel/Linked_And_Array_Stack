public class LinkedStackTester {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(-1));
        
    }
}