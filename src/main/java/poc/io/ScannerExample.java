package poc.io;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scan = new Scanner(System.in).useDelimiter("\\r\\n|[\\n\\r\\u2028\\u2029\\u0085]");
        System.out.println("Enter name, age and phone number: ");
        Person person = new Person(scanner.next(), scanner.nextInt(), scanner.nextLong());
    }

    private static class Person {
        private String name;
        private int age;
        private long phoneNumber;

        Person(String name, int age, long phoneNumber) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            System.out.println("A person is created, name: " + name + " age: " + age + " phoneNumber: " + phoneNumber);
        }
    }
}
