public class Forest extends BattleLocation {
    
    public Forest() {
        super("Forest");
        creature = new Werewolf();
    }

    
    @Override
    public void onEnter(Player player) {
        String message = "You have entered a dense forest. The air is filled with the scent of pine and the sound of rustling leaves. But you're not alone - reports have come in of werewolves stalking these woods. Stay alert, and be ready to defend yourself if needed.";
        
        NarrativePrinter.printNarrative(10, message);

        System.out.println("");

        boolean playerTurn = BattleLogic.isPlayerTurn(player, creature);

        if (playerTurn) { 
            NarrativePrinter.printNarrative(10, "As you make your way through the forest, you hear the sound of something large crashing through the underbrush. You turn around to see a massive werewolf charging towards you, saliva dripping from its jaws. It attacks without warning, and you must defend yourself.");
        } else {
            NarrativePrinter.printNarrative(10, "As you wander through the forest, you spot a pair of glowing eyes staring at you from the underbrush. You squint to see what it is, and suddenly realize that it's a werewolf. It snarls at you, clearly ready for a fight.");
        }

        BattleLogic.fight(player, creature, playerTurn);
    }

}
