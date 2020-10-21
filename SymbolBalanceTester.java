import java.io.*;
import java.util.Scanner;

public class SymbolBalanceTester {
    
    public static void main(String[] args) {
        
        SymbolBalance x = new SymbolBalance();
        x.setFile(args[0]);
        System.out.println(x.checkFile());
       
    }
}