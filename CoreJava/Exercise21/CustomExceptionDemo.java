import java.util.Scanner;

public class CustomExceptionDemo {

    public static void validateAge(int age)
            throws InvalidAgeException {

        if(age < 18) {

            throw new InvalidAgeException(
                    "Age must be 18 or above");
        }

        System.out.println(
                "Eligible to vote");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age: ");

        int age = sc.nextInt();

        try {

            validateAge(age);

        } catch (InvalidAgeException e) {

            System.out.println(
                    e.getMessage());
        }

        sc.close();
    }
}