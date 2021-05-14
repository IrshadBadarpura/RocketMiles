Name: Irshad Badarpura
- Description: A cash register to show, put, take and change cash written in Java

# Files: 
- src
    - CashRegister.java
    - Test.java

# How to run using IDEA:
- Run the CashRegister.java file with any Java compatible IDE like IntelliJ IDEA
- Run the Test.java file to run sample test cases with any Java compatible IDE like IntelliJ IDEA

# How to run using command line:
- To run the CashRegister.java file 
-- Set the directory to the src path. First compile the file using __javac CashRegister.java__  command and then run the file using __java Main__ command

- To run the Test.java file
-- Set the directory to the src path. First compile the file using __javac Test.java__ command and then run the file using __java Test__ command

# Functions:
Assumption: The cash register is empty at the begining.

- show(): Use this method to display the total cash and number of denominations of each type in the cash register. This method returns a String

- put(String input): Use this method to enter the denominations in the cash register. Once, the insertion is successful, it displays the updated register

- take(String remove): Use this method to remove denominations from the cash register. If there are enough denominations to remove, it displays the updated cash register, otherwise displays the message "Not enough denomination to take"

- check(String arr[]): This method is used from the take method to see if there is enough cash that can be taken from the register. This method returns a boolean

- change(String change): Use this method to get change from the cash register. It returns the denominations that make up the change and removes the cash from the cash register. If change is not possible than it simply returns "Sorry"

- quit(): Use this method to quit the program

# Input
Please input the funtions in the following way:

Use the name of the method followed by space and the number of denominations, again separated by space

For example:
- put 1 2 3 4 5
- take 1 2 0 3 1
- show
- change 11
- quit

# Output

A sample output:
```sh
> Enter the function with the function name and values as String separated by space
> Example: put 1 2 3 4 5
> put 1 2 3 4 5
> $68 1 2 3 4 5
> show
> $68 1 2 3 4 5
> put 1 2 3 0 5
> $128 2 4 6 4 10
> take 1 4 3 0 10
> $43 1 0 3 4 0
> change 11
> 0 0 1 3 0
> change 14
> Sorry
> quit
> Bye
```
