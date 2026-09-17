package loginsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();

        System.out.println("--- REGISTRATION ---");
        System.out.print("Enter First Name: ");
        user.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        user.setLastName(scanner.nextLine());

        while (true) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            user.setUsername(username);
            
            if (user.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        while (true) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            user.setPassword(password);

            if (user.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        while (true) {
            System.out.print("Enter Cell Phone Number (e.g., +27838968976): ");
            String cell = scanner.nextLine();
            user.setCellPhoneNumber(cell);

            if (user.checkCellPhoneNumber(cell)) {
                System.out.println("Cell number successfully captured.");
                break;
            } else {
                System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        }

        System.out.println("\nRegistration Complete!\n");

        System.out.println("--- LOGIN ---");
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();

        boolean success = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(success));

        scanner.close();
    }
}
