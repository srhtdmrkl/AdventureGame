import java.util.Scanner;

public class SafeHouse extends NormalLocation{

    private Scanner input = new Scanner(System.in);

    public SafeHouse() {
        super("Safe House");
    }

    @Override
    public void onEnter(Player player) {
        System.out.println("You are at the safe house. Your health is  " + player.getHealth() +".");
        
        while (true) {        
            System.out.println("------------------------");
            System.out.println("What do you want to do?");
            System.out.println("1. Restore Health");
            System.out.println("2. Leave Safe House");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    int restorePrice = player.getCharacter().getHealth() - player.getHealth();
                    System.out.println("It costs " + restorePrice + " coins to restore your health.");
                    System.out.println("Confirm? (Y/N)");
                    String confirmation = input.next();
                
                    if (confirmation.equalsIgnoreCase("Y")) {
                        player.setHealth(player.getCharacter().getHealth());
                        player.inventory.setBalance(player.inventory.getBalance()-restorePrice);
                        System.out.println("You have restored your health to " + player.getHealth() + ".");
                    } else {
                        System.out.println("Purchase canceled.");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("You have left the Safe House");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }


    }
}
