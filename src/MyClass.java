import Calculaution.Calculation;
import Calculaution.CalculationWrapper;

class Person {
    String firstName;
    String lastName;

    public Person() {
        firstName = lastName = "";
    }

    public Person(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }
}

public class MyClass {

    public static void main(String[] args) {
        int[] arr = { -4, 5, -6, 8 };
        int[] arr2 = { -4, 5, -6, 8 };
        System.out.println(arr.equals(arr2));

        Person p = new Person("hassan", "Mourad");
        Person p2 = new Person("hassan", "Mourad");
        System.out.println(p.equals(p2));

        CalculationWrapper test = new CalculationWrapper(new Calculation());
        try {
            System.out.println(test.findMinimum(null));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
