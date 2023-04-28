This is a project from Java102 course in patika.dev

While developing this project, I tried to follow the original class diagrams given for the assignment. I made small changes to existing classes and added new ones, especially for storytelling and combat logic. 

The game prints different narratives through the game depending on the character, the weapons, the creatures, and the combat locations.

Instead of using Player's total damage directly, the game calculates an effective damage based on the character and the weapon the player uses. For the maximum effective damage, the Players must use the weapons their characters are skilled with.

In the game, both the players and creatures have an "awareness" value that is used to calculate the probability of being spotted. This awareness value is used to determine how easily a player or creature can detect the presence of others.

I'm planning to add more:
- The effectiveness of weapons and armors will degrade over time as they are used.
- The player will progress through battle locations. As they go deeper in the location they will have to follow the route back to a safe location.
- More narratives based on the combination of characters, weapons, armors, creatures, and locations.


