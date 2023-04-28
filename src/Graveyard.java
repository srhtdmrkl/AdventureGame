public class Graveyard extends BattleLocation {
    
    public Graveyard() {
        super("Graveyard");
        creature = new Zombie();
    }

    @Override
    public void onEnter(Player player) {

        String message = "You have entered an eerie graveyard. Tombstones and statues are scattered throughout the area, casting ominous shadows in the moonlight. But be warned - the dead don't always stay that way around here. It's said that zombies rise from their graves in this place. Keep your weapons at the ready, and stay on your guard.";
        NarrativePrinter.printNarrative(10, message);

        System.out.println("");

        boolean playerTurn = BattleLogic.isPlayerTurn(player, creature);

        if(playerTurn) {
            NarrativePrinter.printNarrative(10, "As you wander through the graveyard, you hear the sound of rustling dirt behind you. You turn around to see a group of zombies lurching towards you, arms outstretched. They move slowly but relentlessly, and you know you're in for a fight.");
        } else {
            NarrativePrinter.printNarrative(10, "As you walk through the graveyard, you notice movement out of the corner of your eye. You turn to see a group of zombies slowly making their way towards you, arms outstretched. They haven't spotted you yet, but it's only a matter of time before they do.");
        }

        BattleLogic.fight(player, creature, playerTurn);

    }

}
