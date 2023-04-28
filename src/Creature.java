import java.util.Random;

public abstract class Creature {

    private String name;
    private int damage;
    private int health;
    protected int coin;
    private int awareness;

    
    public Creature(String name, int damage, int health, int awareness) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.awareness = awareness;
        Random rand = new Random();
        this.coin = rand.nextInt(getDamage());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCoin() {
        return coin;
    }

    public int getAwareness() {
        return awareness;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Player player){
        System.out.println("\n"+ getName() + " attacks " + player.getName() + " for " + getDamage() + " damage.");
        player.setHealth(player.getHealth() - getDamage());
    }
    
}