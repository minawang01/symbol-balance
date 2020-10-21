import java.io.*;
import java.util.Scanner;

@SuppressWarnings("Unchecked")
public class SymbolBalance implements SymbolBalanceInterface{
    
    private String file;
    private MyStack<Character> theStack;
 
    
    public void setFile(String filename) {
        file = filename;
        
    }
 
    public BalanceError checkFile() {  
        try {
        theStack = new MyStack<Character>();
        File testerFile = new File(file);
        Scanner in = new Scanner(testerFile);
        int line = 1;
        String input = "";
        boolean skip = false;
        boolean quotes = false;
            
        
        while(in.hasNextLine()) {
            input = in.nextLine();
            for(int i = 0; i < input.length(); i ++) {
                
                char c = input.charAt(i);
                
                if(c == '"' && !quotes && !skip) {
                    theStack.push(c);
                    quotes = true;
                } else if(c == '*' && input.charAt(i-1) == '/' && !skip && !quotes) {
                    theStack.push(c);
                    skip = true;
                } else if (((c == '{')||(c == '(')||(c=='[')) && !skip && !quotes) {
                    theStack.push(c);
                }
                
                
                if(c == '*' && input.charAt(i-1) == '/' && !quotes && skip) {
                    continue;
                }
                else if(c == '*' && input.charAt(i+1) == '/' && !quotes && skip) {
                    if(theStack.isEmpty()) {
                        BalanceError f = new EmptyStackError(line);
                        return f;
                    } else if(!skip) {
                        char popped = theStack.pop();
                        BalanceError e = new MismatchError(line, c, popped);
                        return e;
                    } else {
                        theStack.pop();
                        skip = false;
                    }
                } else if (c == '"' && !skip && quotes) {
                    if(theStack.isEmpty()) {
                        BalanceError f = new EmptyStackError(line);
                        return f;
                    } else if(!quotes) {
                        char popped = theStack.pop();
                        BalanceError e = new MismatchError(line, c, popped);
                        return e;
                    } else {
                        theStack.pop();
                        quotes = false;
                    }
                } else if((c == ')' || c == '}' || c == ']') && !skip && !quotes) {
                    if(theStack.isEmpty()) {
                        BalanceError f = new EmptyStackError(line);
                        return f;
                    } else {
                        if(c == '}' && theStack.peek() == '{') {
                            char popped = theStack.pop();
                        
                        } else if(c == ')' && theStack.peek() == '(') {
                            char popped = theStack.pop();
                        
                        } else if(c == ']' && theStack.peek() == '[') {
                            char popped = theStack.pop();
                    
                        } else {
                            char popped = theStack.pop();
                            BalanceError e = new MismatchError(line, c, popped);
                            return e;
                        }
                    }    
                }
            } 
            line++; 
        }
       // System.out.println(theStack.peek());
        if(!theStack.isEmpty()) {
            BalanceError g = new NonEmptyStackError(theStack.peek(), theStack.size());
            return g;      
        }
    } catch(FileNotFoundException e) {
            System.out.println("Invalid input");
    }
    return null;
    }
}
   