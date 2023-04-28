public class Cave extends BattleLocation {
    
    public Cave() {
        super("Cave");
        creature = new Vampire();
    }

    @Override
    public void onEnter(Player player) {
        String message = "You have entered a dark and musty cave. The walls are lined with jagged rocks, and you can hear the sound of dripping water echoing in the distance. But beware - this cave is known to be a haunt of vampires. Keep your wits about you, and be ready for a fight if necessary.";

        NarrativePrinter.printNarrative(10, message);

        System.out.println("");

        boolean playerTurn = BattleLogic.isPlayerTurn(player, creature);

        if (playerTurn) {
            NarrativePrinter.printNarrative(10, "As you make your way through the cave, you catch sight of a vampire lurking in the shadows up ahead. It hasn't seen you yet, but you know that it's only a matter of time before it does. You have a split second to decide whether to confront it or try to escape.");
        } else {
            NarrativePrinter.printNarrative(10, "As you continue through the cave, you hear a low growling sound coming from up ahead. Suddenly, a vampire jumps out from behind a rocky outcropping, fangs bared. It lunges towards you, and you're forced to fight for your life.");
        }

        BattleLogic.fight(player, creature, playerTurn);

        
    }
}