package condiments;


import java.util.Scanner;

public class CMM {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        CoffeeOS coffeeMachine = new CoffeeOS();


                String input = " ";
                Scanner sc = new Scanner(System.in);
                System.out.println("Make new Coffee? Enter Y for yes or N for no\n");
                System.out.println("Enter Q to quit\n");
                input = sc.nextLine();
                if(input.equalsIgnoreCase("Y"))
                {
                    coffeeMachine.run();
                }
                if(input.equalsIgnoreCase("N"))
                {
                    System.exit(0);
                }
                else if(input.equalsIgnoreCase("Q")){
                    System.out.println("Thank you for using Coffee Machine");
                    System.exit(0);

                }
            }
        }
