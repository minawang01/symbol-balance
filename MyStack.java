import java.util.*;

public class MyStack<T> implements MyStackInterface<T> {
    
    private static final int DEFAULT_CAPACITY = 10;
    private int stackSize;
    private T[] array;
    
    @SuppressWarnings("unchecked")
    public MyStack() {
        stackSize = 0;
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    public void push(T x) {
        ensureCapacity();
        if(stackSize >= array.length) {
            //return null;
            throw new RuntimeException("The stack is full.");
        }
        array[stackSize++] = x;
    }
    
	public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        return array[--stackSize];
    }
    
	public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        return array[stackSize-1];
    }
    
	public boolean isEmpty() {
        if(stackSize == 0) {
            return true;
        }
        return false;
    }
    
	public int size() {
        return stackSize;
        
    }
    
    public void ensureCapacity() {
        if(stackSize == array.length - 1) {
            T[] old = array;
            array = (T[]) new Object[stackSize*2 +1];
            for(int i = 0; i < size(); i++) {
                array[i] = old[i];
            }
        } else {
            return;
        }
       
    }
    
  
    
}