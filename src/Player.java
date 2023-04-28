import java.util.Random;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private Character character;
    private Location currentLocation;
    public Inventory inventory;
    private int awareness;


    public Player(String name, Character character) {
        this.name = name;
        this.character = character;
        this.damage = character.getDamage();
        this.health = character.getHealth();
        this.money = character.getMoney();
        this.awareness = character.getAwareness();
        this.inventory = new Inventory(this.money,null,null);
    }

    public Character getCharacter(){
        return character;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location){
        this.currentLocation = location;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAwareness() {
        return awareness;
    }

    public int getEffectiveDamage(){
        Random rand = new Random();
        if(inventory.getWeapon() == null) {
            return getDamage() - rand.nextInt(2);
        } else if ((getCharacter().getCharacterName()=="Hunter" && inventory.getWeapon().getName()=="Crossbow") || (getCharacter().getCharacterName()=="Soldier" && inventory.getWeapon().getName()=="Sword"))  {
            return getDamage();
        } else { 
            return getDamage() - rand.nextInt(3);
        }
    }

    public void attack(Creature creature){
        int effectiveDamage = getEffectiveDamage();
        System.out.println("\n"+ getName() + " attacks " + creature.getName() + " for " + effectiveDamage + " damage.");
        creature.setHealth(creature.getHealth()-effectiveDamage);
    }

    
}
