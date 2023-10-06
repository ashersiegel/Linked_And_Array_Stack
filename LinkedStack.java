public class LinkedStack<T> implements StackInterface<T> {
    
    private int size;
    private LLNode stack;
    
    public LinkedStack() {
        size = 0;
        stack = new LLNode("my stack");
    }
    
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
        LLNode<T> cur = stack;
        while (cur.getLink() != null) {
            cur = cur.getLink();
        }
        return cur.getInfo();
    }
    
    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException {
        if(size == 0) {
            throw new StackUnderflowException();
        }
        LLNode<T> cur = stack;
        while(cur.getLink().getLink() != null) {
            cur = cur.getLink();
        }
        T ret = cur.getLink().getInfo();
        cur.setLink(null);
        size--;
        return ret;
    }
    
    // pushes an item onto the top of this stack
    public T push(T item) {
        LLNode newNode = new LLNode(item);
        if(size == 0) {
            stack.setLink(newNode);
            size++;
            return item;
        }
        LLNode<T> cur = stack;
        while(cur.getLink() != null) {
            cur = cur.getLink();
        }
        cur.setLink(newNode);
        size++;
        return item;
    }
        
    // removes all of the elements from this stack
    public void clear() {
        stack.setLink(null);
        size = 0;
    }
    
    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o) {
        int count = 0;
        LLNode<T> cur = stack;
        while(cur.getLink() != null && !(cur.getLink().getInfo().equals(o))) {
            cur = cur.getLink();
            count++;
        }
        if(size < 1 ||size - count == 0) {
            return -1;
        }
        return size - count;
    }
    
    public String toString() {
        String ret = "";
        LLNode cur = stack;
        while(cur.getLink() != null) {
            ret += cur.getInfo() + "\n";
            cur = cur.getLink();
        }
        ret += cur.getInfo();
        return ret;
    }
}