import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {

        System.out.println("Welcome to Adventure Game!");
        System.out.println("Choose your character: ");
        System.out.print("1. ");
        System.out.println(new Hunter().getAttributes());
        System.out.print("2. ");
        System.out.println(new Soldier().getAttributes());
        
        int choice = input.nextInt();
        Character character = null;
        
        switch (choice) {
            case 1:
                character = new Hunter();
                break;
            case 2:
                character = new Soldier();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        
        System.out.println("Enter your name: ");
        String playerName = input.next();

        Player player = new Player(playerName, character);
        String message = character.getDescription() + " Your name is " + player.getName() + " and you're a " + character.getCharacterName() + ". \n";
        NarrativePrinter.printNarrative(10, message);        

        while (true) {
            System.out.println("\n------------------------");
            System.out.println("Where do you want to go?");
            System.out.println("1. Safe House");
            System.out.println("2. Tool Store");
            System.out.println("3. Cave");
            System.out.println("4. Forest");
            System.out.println("5. Graveyard");
            System.out.println("6. Exit game");

            int choice2 = input.nextInt();

            switch (choice2) {
                case 1:
                    if (player.getCurrentLocation() instanceof SafeHouse) {
                        System.out.println("You are already at Safe House.");
                    } else {
                        player.setCurrentLocation(new SafeHouse());
                        player.getCurrentLocation().onEnter(player);
                    }
                    break;
                case 2:
                    if (player.getCurrentLocation() instanceof ToolStore) {
                        System.out.println("You are already at Tool Store.");
                    } else {
                        player.setCurrentLocation(new ToolStore());
                        player.getCurrentLocation().onEnter(player);
                    }
                    break;
                case 3:
                    if (player.getCurrentLocation() instanceof Cave) {
                        System.out.println("You are already at Cave.");
                    } else {
                        player.setCurrentLocation(new Cave());
                        player.getCurrentLocation().onEnter(player);
                    }
                    break;
                case 4:
                    if (player.getCurrentLocation() instanceof Forest) {
                        System.out.println("You are already at Forest.");
                    } else {
                        player.setCurrentLocation(new Forest());
                        player.getCurrentLocation().onEnter(player);
                    }
                    break;
                case 5:
                    if (player.getCurrentLocation() instanceof Graveyard) {
                        System.out.println("You are already at Graveyard.");
                    } else {
                        player.setCurrentLocation(new Graveyard());
                        player.getCurrentLocation().onEnter(player);
                    }
                    break;
                case 6:
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        

    }

}