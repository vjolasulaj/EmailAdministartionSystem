package EmailApp;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner sc = new Scanner(System.in);
    private String firstname;
    private String lastname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;


    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        System.out.println("New Employee: " + this.firstname+"" + this.lastname);

        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();


    }

    private String generate_email(){
        return firstname.toLowerCase() + "." + lastname.toLowerCase()+"@"+dept.toLowerCase()+".company.com";
    }

    private String setDept(){
        System.out.println("Department codes \n for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter department code: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        }while(!flag);
        return null;
    }

    //GENERATE RANDOM PASSWORD//
    private String generate_password(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_chars = "abcdefghijklmnopqrsutvwxyz";
        String number = "0123456789";
        String symbols = "!@#$%^&*?";
        String values = Capital_chars+small_chars+number+symbols;
        String password="";
        for (int i=0; i<length;i++){
            password=password+values.charAt(r.nextInt(values.length()));
        }
        return password;

    }

    //CHANGE PASSWORD//
    public void set_password(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password?(Y/N)");
            char choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'N') {
                flag = true;
                System.out.println("Enter current password: ");
                String temp = sc.next();
                if (temp.equals(password)) {
                    System.out.println("Enter new password: ");
                    password = sc.next();
                    System.out.println("Password changed successfully.");
                } else {
                    System.out.println("Incorrect password.");
                }
            }else if(choice == 'N' || choice == 'n'){
                    flag=true;
                    System.out.println("Password changed option cancelled!");
                }else{
                System.out.println("Enter valid choice!");
            }
        }while (!flag);
    }

    public void sel_emailCap(){
        System.out.println("Current capacity = " + mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        mailCapacity = sc.nextInt();
        System.out.println("Mailbox capacity is successfully changed!");
    }

    public void alternative_email(){
        System.out.println("Enter new alternative email: ");
        alter_email = sc.next();
        System.out.println("Alternative email is set: " );
    }

    public void getInfo(){
        System.out.println("New: " + firstname + lastname);
        System.out.println("Department: " + dept);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Mailbox capacity: " + mailCapacity);
        System.out.println("Alternative email: " + alter_email);
    }

    public void storefile(){
        try{
            FileWriter in = new FileWriter("C:\\Users\\sulaj\\OneDrive\\Desktop\\EmailApplication");
            in.write("First name: " + firstname);
            in.append("\nLast name: " + lastname);
            in.append("\nEmail: " + email);
            in.append("\nPassword: " + password);
            in.append("\nCapacity: " + mailCapacity);
            in.append("\nAlternative mail: " + alter_email);
            in.close();
            System.out.println("Data stored...");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read_file(){
        try{
            FileReader f1 = new FileReader("C:\\Users\\sulaj\\OneDrive\\Desktop\\EmailApplication");
            int i;
            while ((i= f1.read())!=-1) {
                System.out.println((char)i);
            }
            System.out.println();
            f1.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
