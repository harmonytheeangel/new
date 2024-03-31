import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.*;

//automated teller machine
public class Atm {
    public static String[] name = {"Harmony Abayomi", " Felix Nnedu", "Freda Efod" , "George-Chibuisi Chidinma Precious"};
    public static String email, phone_number ;

    public static int age, cash ,  new_account_no ;
    public static int[] password ={1801 ,5632 , 7983 , 3109};
    public static int[] main_balance = {12000, 36050, 267000 , 205950};
    public static int[] account_no = {865228 , 129715  , 971395 , 942378};

    public static void create_account() {
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME: ");
        String name = input.nextLine();

        System.out.println("YOUR EMAIL ADDRESS: ");
        email = input.nextLine();
        System.out.print("ARE YOU UP TO 18?\nENTER YOUR AGE: ");
        age = input.nextInt();
        if (age >= 18) {
            System.out.print("YOUR EIGHT DIGIT ACCOUNT NUMBER");
            int account_ = input.nextInt();
            //ArrayList <Integer> account_no = new ArrayList<>();
            //account_no.add(account_);
            //System.out.println(account_no);
            System.out.print("ENTER YOUR PHONE NUMBER\n");
            phone_number = input.next();
            System.out.printf("THE FASTEST BANKING NETWORK");
        }
        else
            System.out.println("You are not eligible for this feature");
            //System.exit(0);
    }
    public static void Withdraw() {
        System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAW");
        Scanner input = new Scanner(System.in);
        cash = input.nextInt();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("ENTER YOUR ACCOUNT NUMBER: ");
        new_account_no = input.nextInt();//receiving account
        int pin = input.nextInt();
        for (int k = 0; k <= 3; k++)
            if (account_no[k] == new_account_no || pin == password[k]) {
                String balance = currency.format(main_balance[k] - cash);
                System.out.println("YOU HAVE WITHDRAWN " + currency.format(cash));
                Logger.getLogger("TRY AGAIN" );

        //if(option = )
    }
    }
    public static void CHECK_BALANCE() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER YOUR ACCOUNT NUMBER: ");
        new_account_no = input.nextInt();
        for (int k = 0; k <= 3; k++)
            if (account_no[k] == new_account_no) {
                String NUM = currency.format(main_balance[k] - cash);
                System.out.println("YOUR ACCOUNT BALANCE IS " + NUM);
            }
    }
    public static void Transfer() {
        int i, j;

        System.out.println("WHAT IS THE CODE FOR YOUR ACCOUNT");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        System.out.println("HOW MUCH DO YOU WANT TO TRANSFER");
        cash = input.nextInt();
        if (main_balance[i] > cash) {//to check if the user has enough money for the transaction
            System.out.println("ENTER YOUR PIN: ");
            int password_new;//user input
            password_new = input.nextInt();
            if (password_new == password[i]) {
                System.out.println("ENTER THE RECEIVING ACCOUNT NUMBER");
                new_account_no = input.nextInt();
                for (int k = 0; k  < 3;k ++)
                    if (new_account_no == account_no[k]) {
                        NumberFormat currency = NumberFormat.getCurrencyInstance();
                        String NUM = currency.format(cash);
                        //name[j] = ;
                        System.out.println("YOU HAVE SUCCESSFULLY TRANSFERRED " + NUM + " to "
                                + name[k]);
                    }
        }
            }else{
            System.out.println("INSUFFICIENT BALANCE");
    }
        }

    public static void account_statement() {
        System.out.println("ENTER YOUR ACCOUNT NUMBER: ");
        Scanner input = new Scanner(System.in);
        new_account_no = input.nextInt();
        System.out.println("YOUR PIN");
        int pin = input.nextInt();
        for (int k = 0; k <= 3; k++) {
            if (account_no[k] == new_account_no || pin == password[k]) {
                System.out.println("NAME OF USER: "+name[k]);
                System.out.println("ACCOUNT NUMBER: " + account_no[k]);
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String money = currency.format(main_balance[k]);
                System.out.println("ACCOUNT BALANCE: " + money );
                break;
            }
        }
    }

    public static void change_pin() {
        System.out.println("ENTER THE ACCOUNT NO: ");
        Scanner input = new Scanner(System.in);
        new_account_no = input.nextInt();
        System.out.print("ENTER YOUR OLD PASSWORD");
        int pin = input.nextInt();
        for (int k = 0; k <= 3;) {
            if (account_no[k] == new_account_no || pin == password[k]) {
                   System.out.print("ENTER YOUR NEW PIN ");
                   int new_pin = input.nextInt();
                   System.out.println("PIN CHANGED SUCCESSFULLY \nTHANK YOU FOR BANKING WITH US");
            }
            else
                System.out.println("WRONG TRANSACTION");
                break;
    }
    }
    public static void main(String[] args) {
        JFrame frame= new JFrame("Game" );
        JButton button = new JButton("click here");
        button.setBounds(120 , 110 , 95 , 30);

        frame.add(button);
        frame.setSize(400 , 400);
        frame.setLayout(null);
        frame.setVisible(true);



         System.out.println("WELCOME TO FIRST WORLD BANK");
         JOptionPane.showMessageDialog(null,
                "welcome to First world bank\n Press okay!");

        // JOptionPane.showMessageDialog(null , "What would you like to do today!" );
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                "What would you like to do today!\nCREATE ACCOUNT - 0\n WITHDRAW CASH - 1 \n" +
                "CHECK BALANCE - 2\n TRANSFER - 3\n ACCOUNT STATEMENT - 4\n" +
                "CHANGE PIN - 5"));

        switch (option) {
            case 0:
                create_account();
                break;
            case 1:
                Withdraw();
                break;
            case 2:
                CHECK_BALANCE();
                break;
            case 3:
                Transfer();
                break;
            case 4:
               account_statement();
               break;
            case 5:
                change_pin();
                break;
            default:
                System.out.println("TRY AGAIN");
        }
    }
}