package BSTs;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        Employee e1 = new Employee(88, "Aaron Flores", "IT");
        Employee e2 = new Employee(100, "Raul Gomez", "IT");
        Employee e3 = new Employee(405, "Arturo Dueñas", "IT");
        Employee e4 = new Employee(10, "Arnoldo Gaytan", "IT");
        Employee e5 = new Employee(22, "Andres Herrera", "IT");
        Employee e6 = new Employee(90, "Daniel Chavez", "IT");
        Employee e7 = new Employee(19, "Carlos Torres", "IT");
        Employee e8 = new Employee(99, "David Flores", "IT");

        BST tree = new BST();
        
        Arrays.asList(e1, e2 , e3, e4, e5, e6, e7, e8).forEach(tree::insert);

        tree.remove(88);

        tree.inOrder();
        
    }
}
