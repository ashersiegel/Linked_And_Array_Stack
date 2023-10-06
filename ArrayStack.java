public class ArrayStack<T> implements StackInterface<T>{
    
    private int size;
    private T[] stack;
    
    public ArrayStack() {
        size = 0;
        stack = (T[])new Object[10000];
    }
    // returns the logical size of the stack
    public int size() {
        return size;
    }
    
    // tests if this stack is empty
    public boolean empty() {
        return size == 0;
    }
    
    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek() throws StackUnderflowException {
        if(size == 0) {
            throw new StackUnderflowException();
        }
        else {
            return stack[size - 1];
        }
    }
    
    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException {
        if(size == 0) {
            throw new StackUnderflowException();
        }
        else {
            T object = stack[size - 1];
            stack[size - 1] = null;
            size--;
            return object;
        }
    }
    
    // pushes an item onto the top of this stack
    public T push(T item) {
        stack[size] = item;
        size++;
        return item;
    }
            
    // removes all of the elements from this stack
    public void clear() {
        stack = (T[])new Object[10000];
        size = 0;
    }
    
    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o) {
        for(int i = 0; i < size; i++) {
            if(stack[i].equals(o)) {
                return size - i;
            }
        }
        return -1;
    }
    
    public String toString() {
        String total = "";
        for(int i = size - 1; i > -1; i--) {
            total += stack[i] + "\n";
        }
        return total;
    }
}