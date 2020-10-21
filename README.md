**Project was a coding problem from a Data Structures and Algorithms in Java course taken at Columbia University**

Implements a stack in a class called MyStack. Implements and defines a class called *SymbolBalance* in the empty SymbolBalance.java file.

The `SymbolBalance` class will read through a Java file and check for simple syntatical errors. There are two methods.

The first method, `setFile`, takes in a String representing the path to the file that should be checked.

The second method, `checkFile`, reads in the file character by character and check to make sure that all { }'s, ( )'s, [ ]'s, " "'s, and /\* \*/'s are properly balanced. It ignore characters within literal strings (" ") and comment blocks (/\* \*/). It processes the file by iterating through it one character at a time. During iteration, the symbol currently pointed to in the loop will be referred to as `<Current Symbol>` henceforth.

There are three types of errors that can be encountered:

* The file ends with one or more opening symbols missing their corresponding closing symbols.
* There is a closing symbol without an opening symbol.
* There is a mismatch between closing and opening symbols (for example: { [ } ] ).

Once an error is encountered, a `BalanceError` object containing error information is returned. Each error type has its own class that descends from `BalanceError` and each has its own required parameters:

- Symbol mismatch after popping stack: return `MismatchError(int lineNumber, char currentSymbol, char symbolPopped)`
- Empty stack popped: `EmptyStackError(int lineNumber)`
- Non-empty stack after parsing entire file: `NonEmptyStackError(char topElement, int sizeOfStack)`

If no error is found, `null` is returned.

Some test cases provided.

To run the project, compile and run the file SymbolBalanceTester.java.
