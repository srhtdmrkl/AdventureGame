import java.util.Random;
import java.util.Scanner;

public class BattleLogic {

    private static final Random RANDOM = new Random();
    private static Scanner input = new Scanner(System.in);
    
    public static boolean isPlayerTurn(Player player, Creature creature) {
        int playerAwareness = player.getAwareness();
        int creatureAwareness = creature.getAwareness();
        int totalAwareness = playerAwareness + creatureAwareness;
        int characterSpotChance = 100 * playerAwareness / totalAwareness;
        int randomNumber = RANDOM.nextInt(100) + 1;
        return randomNumber <= characterSpotChance;
    }

    public static void fight(Player player, Creature creature, boolean playerTurn) {
        boolean isPlayerRanAway = false;
        while (player.isAlive() && creature.isAlive()) {
            if (playerTurn) {                    
                System.out.println("\nYour health is " + player.getHealth());
                System.out.println("\n(F)ight or (R)un?");
                String choice = input.nextLine().toLowerCase();
                switch (choice) {
                    case "f":
                        player.attack(creature);
                        break;
                    case "r":
                        System.out.println("\n"+ player.getName() + " runs away from " + creature.getName());
                        isPlayerRanAway = true;
                        break;
                    default:
                        System.out.println("\n"+ player.getName() + " hesitates to make a move.");
                        creature.attack(player);
                        break;
                }
                if (isPlayerRanAway) {
                    break;
                }
            } else {
                creature.attack(player);
            }
            playerTurn = !playerTurn;
            }
        
        if (player.isAlive() && !isPlayerRanAway) {
            NarrativePrinter.playerKillsNarrative(player, creature);
            player.inventory.setBalance(player.inventory.getBalance() + creature.getCoin());
            String message = "\nAs the victorious " + player.getName() + " stands over the defeated " + creature.getName() + ", " + player.getName() + " notice a glint of gold in the " + creature.getName() + "'s hand. With a triumphant smile, "+player.getName()+" pockets "+creature.getCoin()+" coins and continues the journey, ready for whatever challenges lie ahead.";
            NarrativePrinter.printNarrative(10, message);
        } else if(!player.isAlive()) {
            NarrativePrinter.creatureKillsNarrative(player, creature);
            System.exit(0);
        }
    }
}

