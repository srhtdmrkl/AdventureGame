public class NarrativePrinter {

    public static void printNarrative(int delay, String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void playerKillsNarrative(Player player, Creature creature) {

        String playerKillsZombieBarehand = "\nWith nothing but bare hands, "+player.getName()+" charges towards the zombie, determined to take it down. With a flurry of punches and kicks, "+player.getName()+" lands a fatal blow, sending the zombie crashing to the ground.";
        String playerKillsZombieCrossbow = "\n"+player.getName()+" carefully aims the crossbow at the approaching zombie, taking a deep breath before firing. The bolt strikes the zombie straight in the head, sending it toppling to the ground with a sickening thud.";
        String playerKillsZombieSword = "\nDrawing a trusty sword, "+player.getName()+" takes a defensive stance as the zombie lurches towards them. With lightning-fast reflexes, "+player.getName()+" slashes the sword through the air, landing a precise blow that cuts the zombie in two.";
        String playerKillsVampireBarehand = "\nWith a fierce determination in the eyes, "+player.getName()+" charges at the vampire, relying on bare hands alone. Dodging the vampire's attacks, "+player.getName()+" lands a series of quick, precise blows that eventually weaken the vampire enough to land the final, fatal punch.";
        String playerKillsVampireCrossbow = "\nWith a steady hand, "+player.getName()+" loads a bolt into their crossbow and takes aim at the vampire's heart. The bolt flies through the air, striking the vampire squarely in the chest and causing it to collapse in a heap.";
        String playerKillsVampireSword = "\nDrawing their sword, "+player.getName()+" expertly parries the vampire's attacks before finding an opening to strike. The blade plunges into the vampire's heart, sending it crumbling to dust.";
        String playerKillsWerewolfBarehand = "\n"+player.getName()+" charges towards the werewolf, relying on their strength and cunning to take it down with their bare hands. After a brutal struggle, "+player.getName()+" lands a crushing blow that sends the werewolf crashing to the ground.";
        String playerKillsWerewolfCrossbow = "\n"+player.getName()+" takes careful aim with their crossbow, waiting for the perfect opportunity to strike the werewolf. As the werewolf charges towards them, "+player.getName()+" fires a bolt that pierces the werewolf's heart, sending it falling to the ground in a heap.";
        String playerKillsWerewolfSword = "\nWith sword in hand, "+player.getName()+" engages in a fierce battle with the werewolf. Dodging and weaving around the werewolf's attacks, "+player.getName()+" finally lands a fatal blow that causes the werewolf to revert back to its human form.";
                    
        if(creature instanceof Zombie) {
            if(player.inventory.getWeapon()==null){
                NarrativePrinter.printNarrative(10, playerKillsZombieBarehand);
            } else if(player.inventory.getWeapon().getName()=="Sword") {
                NarrativePrinter.printNarrative(10, playerKillsZombieSword);
            } else if(player.inventory.getWeapon().getName()=="Crossbow") {
                NarrativePrinter.printNarrative(10, playerKillsZombieCrossbow);
            }
        } else if(creature instanceof Vampire) {
            if(player.inventory.getWeapon()==null){
                NarrativePrinter.printNarrative(10, playerKillsVampireBarehand);
            } else if(player.inventory.getWeapon().getName()=="Sword") {
                NarrativePrinter.printNarrative(10, playerKillsVampireSword);
            } else if(player.inventory.getWeapon().getName()=="Crossbow") {
                NarrativePrinter.printNarrative(10, playerKillsVampireCrossbow);
            }
        } else if(creature instanceof Werewolf) {
            if(player.inventory.getWeapon()==null){
                NarrativePrinter.printNarrative(10, playerKillsWerewolfBarehand);
            } else if(player.inventory.getWeapon().getName()=="Sword") {
                NarrativePrinter.printNarrative(10, playerKillsWerewolfSword);
            } else if(player.inventory.getWeapon().getName()=="Crossbow") {
                NarrativePrinter.printNarrative(10, playerKillsWerewolfCrossbow);
            }
        }
    }
    
    public static void creatureKillsNarrative(Player player, Creature creature){

        String zombieKillsPlayer = "\nThe zombie stumbles towards "+player.getName()+", its eyes vacant and its limbs jerking awkwardly. Despite "+player.getName()+"'s best efforts to fight it off, the zombie manages to overpower them, tearing chunks of flesh from their body until they are no longer able to resist.";
        String vampireKillsPlayer = "\nThe vampire moves with inhuman speed, darting around "+player.getName()+" and sinking its fangs into "+player.getName()+"'s neck without leaving a chance to react. "+player.getName()+" feels their life force draining away as the vampire feeds, unable to escape its grasp.";
        String werewolfKillsPlayer = "\nThe werewolf's powerful jaws clamp down on "+player.getName()+"'s throat, cutting off air supply and leaving "+player.getName()+" helpless. Despite "+player.getName()+"'s best efforts to fight back, the werewolf's strength is unchallengable.";

        if(creature instanceof Zombie){
            printNarrative(10, zombieKillsPlayer);
        } else if(creature instanceof Vampire){
            printNarrative(10, vampireKillsPlayer);
        } else if(creature instanceof Werewolf){
            printNarrative(10, werewolfKillsPlayer);
        }
    }

}