package EmailApp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fname = sc.next();
        System.out.println("Enter last name: ");
        String lname = sc.next();

        Email email = new Email(fname, lname);
        int choice = -1;
        do {
            System.out.println("\n******\nEnter your choice\n1.Show Info\n2.Change password\n3.Change mailbox capacity\n4.Set Alternative email");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    email.getInfo();
                    break;
                case 2:
                    email.setPassword();
                    break;
                case 3:
                    email.setEmailCap();
                    break;
                case 4:
                    email.alternativeEmail();
                    break;
                case 5:
                    email.storefile();
                    break;
                case 6:
                    email.readFile();
                    break;
                case 7:
                    System.out.println("Thank you for using our application...");
                default:
                    System.out.println("Invalid choice enter proper choice again...");
            }
        }while(choice!=7);
    }
}
