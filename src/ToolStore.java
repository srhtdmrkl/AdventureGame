import java.util.Scanner;

public class ToolStore extends NormalLocation{

    private Scanner input = new Scanner(System.in);

    public ToolStore() {
        super("Tool Store");
    }

    @Override
    public void onEnter(Player player) {
        System.out.println("You are at the tool store. You have " + player.inventory.getBalance() + " coins.");
        player.inventory.display();
        
        while (true) {        
            System.out.println("------------------------");
            System.out.println("What do you want to buy?");
            System.out.println("1. Weapons");
            System.out.println("2. Armors");
            System.out.println("3. Move to Another Location");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    Weapon.listWeapons();
                    Weapon.buyWeapon(player);
                    return;
                case 2:
                    Armor.listArmors();
                    Armor.buyArmor(player);
                    break;
                case 3:
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

}
